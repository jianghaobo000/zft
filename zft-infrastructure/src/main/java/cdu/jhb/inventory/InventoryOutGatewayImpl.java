package cdu.jhb.inventory;

import cdu.jhb.common.Constant;
import cdu.jhb.domain.inventory.InventoryInInfo;
import cdu.jhb.domain.inventory.InventoryOut;
import cdu.jhb.domain.inventory.InventoryOutDetail;
import cdu.jhb.domain.inventory.InventoryOutInfo;
import cdu.jhb.domain.inventory.gateway.InventoryOutGateway;
import cdu.jhb.inventory.data.dto.InventoryInInfoDTO;
import cdu.jhb.inventory.data.dto.InventoryOutInfoDTO;
import cdu.jhb.inventory.data.response.InventoryInListResponse;
import cdu.jhb.inventory.data.response.InventoryOutListResponse;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.InventoryOutDetailMapper;
import cdu.jhb.inventory.database.InventoryOutMapper;
import cdu.jhb.inventory.database.dataobject.*;
import cdu.jhb.inventory.data.request.InventoryOutListQuery;
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
public class InventoryOutGatewayImpl implements InventoryOutGateway {

    private final InventoryMapper inventoryMapper;

    private final InventoryOutMapper inventoryOutMapper;

    private final InventoryOutDetailMapper inventoryOutDetailMapper;

    /**
     * 获取出库单列表
     * @param query
     * @return
     */
    @Override
    public InventoryOutListResponse getInventoryOutList(InventoryOutListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryOutTenantId(RedisUtil.getLocalTenantId());
        List<InventoryOutInfo> outInfoList = inventoryOutMapper.getInventoryOutList(query);
        // 分页
        Map<String,Integer> pageMap = Calculate.assemblyPagination(query.getPageIndex(),query.getPageSize(),outInfoList.size());
        InventoryOutListResponse outListResponse = new InventoryOutListResponse();
        outListResponse.setTotal(outInfoList.size());
        outListResponse.setMaxPage(outInfoList.size()/query.getPageSize() + 1);
        outInfoList = outInfoList.subList(pageMap.get(Constant.START_INDEX),pageMap.get(Constant.END_INDEX));
        outListResponse.setOutDTOList(Convert.listConvert(outInfoList, InventoryOutInfoDTO.class));
        return outListResponse;
    }

    /**
     * 获取出库单主表信息
     * @param id
     * @return
     */
    @Override
    public InventoryOutInfo selectOutInfo(Long id) {
        return inventoryOutMapper.getInventoryOutInfo(id,RedisUtil.getLocalTenantId());
    }

    /**
     * 获取出库单明细列表
     * @param id
     * @return
     */
    @Override
    public List<InventoryOutDetail> selectOutDetail(Long id) {
        QueryWrapper<InventoryOutDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryOutDetailDO::getInventoryOutId,id);
        List<InventoryOutDetailDO> outDetailDOList = inventoryOutDetailMapper.selectList(queryWrapper);
        return Convert.listConvert(outDetailDOList, InventoryOutDetail.class);
    }

    /**
     * 保存出库单
     * @param inventoryOut
     * @param outDetailList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInventoryOut(InventoryOut inventoryOut, List<InventoryOutDetail> outDetailList) {
        // 将出库单主表实体转换为数据库表对象
        InventoryOutDO inventoryOutDO = Convert.entityConvert(inventoryOut,InventoryOutDO.class);
        inventoryOutDO.setInventoryOutTenantId(RedisUtil.getLocalTenantId());
        // 新增出库单主表信息
        inventoryOutMapper.insert(inventoryOutDO);
        // 将出库单明细表实体集合转换为数据库表对象集合
        List<InventoryOutDetailDO> outDetailDOList = Convert.listConvert(outDetailList,InventoryOutDetailDO.class);
        // 组装库存数量数据
        AssemblyData(outDetailDOList,inventoryOutDO,1);
        return true;
    }

    /**
     * 重新发起出库单
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean waitToSaveOut(Long id) {
        // 找到对应的出库单
        InventoryOutDO inventoryOutDO = inventoryOutMapper.selectById(id);
        // 修改出库单状态为已出库
        inventoryOutDO.setInventoryOutStatus(Constant.ALREADY_WAREHOUSING);
        // 设置出库时间
        inventoryOutDO.setInventoryOutTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        // 为了使最新数据ID都最新，先删除旧的再新增新的
        inventoryOutMapper.deleteById(inventoryOutDO.getInventoryOutId());
        inventoryOutDO.setInventoryOutId(null);
        inventoryOutMapper.insert(inventoryOutDO);

        // 获取对应的明细数据
        QueryWrapper<InventoryOutDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryOutDetailDO::getInventoryOutId,id);
        List<InventoryOutDetailDO> outDetailDOList = inventoryOutDetailMapper.selectList(queryWrapper);
        // 组装库存数量数据
        AssemblyData(outDetailDOList,inventoryOutDO,2);
        return true;
    }

    /**
     * 组装数据
     * @param outDetailDOList
     * @param inventoryOutDO
     * @param status
     */
    @Transactional(rollbackFor = Exception.class)
    public void AssemblyData(List<InventoryOutDetailDO> outDetailDOList, InventoryOutDO inventoryOutDO, int status){
        // 将涉及到的商品ID的库存信息查出来
        QueryWrapper<InventoryDO> inventoryDOQueryWrapper = new QueryWrapper<>();
        inventoryDOQueryWrapper.lambda().in(InventoryDO::getInventoryCommodityId,outDetailDOList.stream().map(InventoryOutDetailDO::getInventoryOutCommodityId).collect(Collectors.toList()));
        List<InventoryDO> inventoryDOList = inventoryMapper.selectList(inventoryDOQueryWrapper);

        // 对库存数量进行处理
        inventoryDOList.forEach(inventoryDO -> {
            // 将商品ID相同的对象匹配起来
            InventoryOutDetailDO inventoryOutDetailDO = outDetailDOList.stream().filter(detail -> detail.getInventoryOutCommodityId().equals(inventoryDO.getInventoryCommodityId())).findFirst().orElse(null);
            assert inventoryOutDetailDO != null;
            // 设置明细表的主表ID
            inventoryOutDetailDO.setInventoryOutId(inventoryOutDO.getInventoryOutId());
            // 出库明细单设置出库操作之前的库存数量
            inventoryOutDetailDO.setInventoryOutBeforeLargeNum(inventoryDO.getInventoryLargeNum());
            inventoryOutDetailDO.setInventoryOutBeforeSmallNum(inventoryDO.getInventorySmallNum());

            if(status == 1){
                // 通过大小转换单位比计算出出库数量
                Map<String, Integer> map1 = Calculate.inventoryQuantity(
                        inventoryOutDetailDO.getInventoryOutLargeNum(),
                        inventoryOutDetailDO.getInventoryOutSmallNum(),
                        inventoryDO.getInventoryDosageForm());
                // 出库明细单设置出库操作的库存数量
                inventoryOutDetailDO.setInventoryOutLargeNum(map1.get(Constant.LARGE_NUM));
                inventoryOutDetailDO.setInventoryOutSmallNum(map1.get(Constant.SMALL_NUM));
            }


            // 通过大小转换单位比计算之后库存
            Map<String, Integer> map2 = Calculate.inventoryQuantity(
                    inventoryDO.getInventoryLargeNum() - inventoryOutDetailDO.getInventoryOutLargeNum(),
                    inventoryDO.getInventorySmallNum() - inventoryOutDetailDO.getInventoryOutSmallNum(),
                    inventoryDO.getInventoryDosageForm());
            if(map2.get(Constant.LARGE_NUM) < 0){
                throw new RuntimeException("商品ID为"+inventoryDO.getInventoryCommodityId()+"的商品库存不足！");
            }
            // 库存主表设置出库操作之后的库存数
            inventoryDO.setInventoryLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryDO.setInventorySmallNum(map2.get(Constant.SMALL_NUM));
            // 出库明细单设置出库操作之后的库存数量
            inventoryOutDetailDO.setInventoryOutAfterLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryOutDetailDO.setInventoryOutAfterSmallNum(map2.get(Constant.SMALL_NUM));

            // 如果状态为已出库则更新库存主表
            if (Constant.ALREADY_OUTBOUND.equals(inventoryOutDO.getInventoryOutStatus())) {
                // 更新库存主表的信息
                inventoryMapper.updateById(inventoryDO);
            }
            if(status == 2){
                // 先删除旧的出库明细表信息，再添加新的
                inventoryOutDetailMapper.deleteById(inventoryOutDetailDO.getInventoryOutDetailId());
            }
            // 新增出库明细表信息,清空主键id
            inventoryOutDetailDO.setInventoryOutDetailId(null);
            inventoryOutDetailMapper.insert(inventoryOutDetailDO);
        });
    }
}
