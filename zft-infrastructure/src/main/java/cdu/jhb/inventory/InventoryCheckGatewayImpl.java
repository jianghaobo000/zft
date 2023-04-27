package cdu.jhb.inventory;

import cdu.jhb.common.Constant;
import cdu.jhb.common.DictException;
import cdu.jhb.domain.inventory.InventoryCheck;
import cdu.jhb.domain.inventory.InventoryCheckDetail;
import cdu.jhb.domain.inventory.InventoryCheckInfo;
import cdu.jhb.domain.inventory.InventoryInInfo;
import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.inventory.data.dto.InventoryCheckInfoDTO;
import cdu.jhb.inventory.data.dto.InventoryInInfoDTO;
import cdu.jhb.inventory.data.response.InventoryCheckListResponse;
import cdu.jhb.inventory.data.response.InventoryInListResponse;
import cdu.jhb.inventory.database.InventoryCheckDetailMapper;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.dataobject.*;
import cdu.jhb.inventory.data.request.InventoryCheckListQuery;
import cdu.jhb.util.Calculate;
import cdu.jhb.util.Convert;
import cdu.jhb.util.DateUtil;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:20
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryCheckGatewayImpl implements InventoryCheckGateway {

    private final InventoryCheckMapper inventoryCheckMapper;

    private final InventoryCheckDetailMapper inventoryCheckDetailMapper;

    private final InventoryMapper inventoryMapper;

    /**
     * 获取盘点单列表
     * @param query
     * @return
     */
    @Override
    public InventoryCheckListResponse getInventoryCheckList(InventoryCheckListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryCheckTenantId(RedisUtil.getLocalTenantId());
        List<InventoryCheckInfo> checkInfoList = inventoryCheckMapper.getInventoryCheckList(query);
        // 分页
        Map<String,Integer> pageMap = Calculate.assemblyPagination(query.getPageIndex(),query.getPageSize(),checkInfoList.size());
        InventoryCheckListResponse checkListResponse = new InventoryCheckListResponse();
        checkListResponse.setTotal(checkInfoList.size());
        checkListResponse.setMaxPage(checkInfoList.size()/query.getPageSize() + 1);
        checkInfoList = checkInfoList.subList(pageMap.get(Constant.START_INDEX),pageMap.get(Constant.END_INDEX));
        checkListResponse.setCheckDTOList(Convert.listConvert(checkInfoList, InventoryCheckInfoDTO.class));
        return checkListResponse;
    }

    /**
     * 查询盘点单主表
     * @param id
     * @return
     */
    @Override
    public InventoryCheckInfo selectCheckInfo(Long id) {
        return inventoryCheckMapper.getInventoryCheckInfo(id,RedisUtil.getLocalTenantId());
    }

    /**
     * 查询盘点单明细列表
     * @param id
     * @return
     */
    @Override
    public List<InventoryCheckDetail> selectCheckDetail(Long id) {
        QueryWrapper<InventoryCheckDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryCheckDetailDO::getInventoryCheckId,id);
        List<InventoryCheckDetailDO> checkDetailDOList = inventoryCheckDetailMapper.selectList(queryWrapper);
        return Convert.listConvert(checkDetailDOList, InventoryCheckDetail.class);
    }


    /**
     * 保存盘点单
     * @param inventoryCheck
     * @param checkDetailList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInventoryCheck(InventoryCheck inventoryCheck, List<InventoryCheckDetail> checkDetailList) {
        // 将盘点单主表实体转换为数据库表对象
        InventoryCheckDO inventoryCheckDO = Convert.entityConvert(inventoryCheck,InventoryCheckDO.class);
        inventoryCheckDO.setInventoryCheckTenantId(RedisUtil.getLocalTenantId());
        // 新增盘点单主表信息
        inventoryCheckMapper.insert(inventoryCheckDO);
        // 将盘点单明细表实体集合转换为数据库表对象集合
        List<InventoryCheckDetailDO> checkDetailDOList = Convert.listConvert(checkDetailList,InventoryCheckDetailDO.class);
        // 组装库存数量数据
        AssemblyData(checkDetailDOList,inventoryCheckDO,1);
        return true;
    }


    /**
     * 待盘点重新发起
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean waitToSaveCheck(Long id) {
        // 找到对应的盘点单
        InventoryCheckDO inventoryCheckDO = inventoryCheckMapper.selectById(id);
        // 修改盘点单状态为已盘点
        inventoryCheckDO.setInventoryCheckStatus(Constant.ALREADY_CHECK);
        // 设置盘点时间
        inventoryCheckDO.setInventoryCheckTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        // 为了使最新数据ID都最新，先删除旧的再新增新的
        inventoryCheckMapper.deleteById(inventoryCheckDO.getInventoryCheckId());
        inventoryCheckDO.setInventoryCheckId(null);
        inventoryCheckMapper.insert(inventoryCheckDO);

        // 获取对应的明细数据
        QueryWrapper<InventoryCheckDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryCheckDetailDO::getInventoryCheckId,id);
        List<InventoryCheckDetailDO> checkDetailDOList = inventoryCheckDetailMapper.selectList(queryWrapper);
        // 组装库存数量数据
        AssemblyData(checkDetailDOList,inventoryCheckDO,2);
        return true;
    }

    /**
     * 组装数据
     * @param checkDetailDOList
     * @param inventoryCheckDO
     * @param status
     */
    @Transactional(rollbackFor = Exception.class)
    public void AssemblyData(List<InventoryCheckDetailDO> checkDetailDOList, InventoryCheckDO inventoryCheckDO, int status){
        // 将涉及到的商品ID的库存信息查出来
        QueryWrapper<InventoryDO> inventoryDOQueryWrapper = new QueryWrapper<>();
        inventoryDOQueryWrapper.lambda().in(InventoryDO::getInventoryCommodityId,checkDetailDOList.stream().map(InventoryCheckDetailDO::getInventoryCheckCommodityId).collect(Collectors.toList()));
        List<InventoryDO> inventoryDOList = inventoryMapper.selectList(inventoryDOQueryWrapper);

        // 对库存数量进行处理
        inventoryDOList.forEach(inventoryDO -> {
            // 将商品ID相同的对象匹配起来
            InventoryCheckDetailDO inventoryCheckDetailDO = checkDetailDOList.stream().filter(detail -> detail.getInventoryCheckCommodityId().equals(inventoryDO.getInventoryCommodityId())).findFirst().orElse(null);
            assert inventoryCheckDetailDO != null;
            // 设置明细表的主表ID
            inventoryCheckDetailDO.setInventoryCheckId(inventoryCheckDO.getInventoryCheckId());
            if(status == 1){
                inventoryCheckDetailDO = AssemblyPhaseData(inventoryCheckDetailDO);
            }else{
                // 如果账面库存发生变动,那么盘点单失效
                if(!inventoryCheckDetailDO.getInventoryCheckBeforeLargeNum().equals(inventoryDO.getInventoryLargeNum()) || !inventoryCheckDetailDO.getInventoryCheckBeforeSmallNum().equals(inventoryDO.getInventorySmallNum())){
                    throw new RuntimeException(DictException.BOOK_INVENTORY_CHANGE);
                }
            }

            // 通过大小转换单位比计算盘点之后库存
            Map<String, Integer> map2 = Calculate.inventoryQuantity(
                    inventoryCheckDetailDO.getInventoryCheckAfterLargeNum(),
                    inventoryCheckDetailDO.getInventoryCheckAfterSmallNum(),
                    inventoryDO.getInventoryDosageForm());
            // 库存主表设置盘点操作之后的库存数
            inventoryDO.setInventoryLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryDO.setInventorySmallNum(map2.get(Constant.SMALL_NUM));
            // 盘点明细单设置盘点操作之后的库存数量
            inventoryCheckDetailDO.setInventoryCheckAfterLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryCheckDetailDO.setInventoryCheckAfterSmallNum(map2.get(Constant.SMALL_NUM));

            // 如果状态为已盘点则更新库存主表
            if (Constant.ALREADY_CHECK.equals(inventoryCheckDO.getInventoryCheckStatus())) {
                // 更新库存主表的信息
                inventoryMapper.updateById(inventoryDO);
            }
            if(status == 2){
                // 先删除旧的盘点明细表信息，再添加新的
                inventoryCheckDetailMapper.deleteById(inventoryCheckDetailDO.getInventoryCheckDetailId());
            }
            // 新增盘点明细表信息,清空主键id
            inventoryCheckDetailDO.setInventoryCheckDetailId(null);
            inventoryCheckDetailMapper.insert(inventoryCheckDetailDO);
        });
    }

    /**
     * 组装盈亏数据
     * @return
     */
    public InventoryCheckDetailDO AssemblyPhaseData(InventoryCheckDetailDO inventoryCheckDetailDO){
        // 之前总数
        int beforeNum = inventoryCheckDetailDO.getInventoryCheckBeforeLargeNum() * inventoryCheckDetailDO.getInventoryCheckDosageForm() + inventoryCheckDetailDO.getInventoryCheckBeforeSmallNum();
        int afterNum = inventoryCheckDetailDO.getInventoryCheckAfterLargeNum() * inventoryCheckDetailDO.getInventoryCheckDosageForm() + inventoryCheckDetailDO.getInventoryCheckAfterSmallNum();
        int num = afterNum - beforeNum;
        if(num > 0){
            // 盘盈
            inventoryCheckDetailDO.setInventoryCheckStatus(Constant.CHECK_PROFIT);
        }else if(num == 0){
            // 盘平
            inventoryCheckDetailDO.setInventoryCheckStatus(Constant.CHECK_EQUAL);
        }else{
            // 盘亏
            inventoryCheckDetailDO.setInventoryCheckStatus(Constant.CHECK_LOSS);
        }
        inventoryCheckDetailDO.setInventoryCheckLargeNum(Math.abs(num)/inventoryCheckDetailDO.getInventoryCheckDosageForm());
        inventoryCheckDetailDO.setInventoryCheckSmallNum(Math.abs(num)%inventoryCheckDetailDO.getInventoryCheckDosageForm());
        return inventoryCheckDetailDO;
    }
}
