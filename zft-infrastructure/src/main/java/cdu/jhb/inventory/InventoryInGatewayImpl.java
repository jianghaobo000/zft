package cdu.jhb.inventory;

import cdu.jhb.common.Constant;
import cdu.jhb.domain.inventory.Inventory;
import cdu.jhb.domain.inventory.InventoryIn;
import cdu.jhb.domain.inventory.InventoryInDetail;
import cdu.jhb.domain.inventory.InventoryInInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.inventory.database.InventoryInDetailMapper;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.dataobject.InventoryDO;
import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import cdu.jhb.inventory.database.dataobject.InventoryInDetailDO;
import cdu.jhb.inventory.dto.data.*;
import cdu.jhb.util.Calculate;
import cdu.jhb.util.Convert;
import cdu.jhb.util.DateUtil;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:20
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryInGatewayImpl implements InventoryInGateway {

    private final InventoryInMapper inventoryInMapper;

    private final InventoryInDetailMapper inventoryInDetailMapper;

    private final InventoryMapper inventoryMapper;

    /**
     * 获取入库单信息列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryInInfo> getInventoryInList(InventoryInListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryInTenantId(RedisUtil.getLocalTenantId());
        return inventoryInMapper.getInventoryInList(query);
    }

    /**
     * 获取入库单主表信息
     * @param id
     * @return
     */
    @Override
    public InventoryInInfo selectInInfo(Long id) {
        return inventoryInMapper.getInventoryInInfo(id,RedisUtil.getLocalTenantId());
    }

    /**
     * 根据主表ID获取入库单明细表列表
     * @param id
     * @return
     */
    @Override
    public List<InventoryInDetail> selectInDetail(Long id) {
        QueryWrapper<InventoryInDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryInDetailDO::getInventoryInId,id);
        List<InventoryInDetailDO> inDetailDOList = inventoryInDetailMapper.selectList(queryWrapper);
        return Convert.listConvert(inDetailDOList,InventoryInDetail.class);
    }

    /**
     * 保存入库
     * @param inventoryIn
     * @param inDetailList
     * @return
     */
    @Override
    public Boolean saveInventoryIn(InventoryIn inventoryIn, List<InventoryInDetail> inDetailList) {
        // 将入库单主表实体转换为数据库表对象
        InventoryInDO inventoryInDO = Convert.entityConvert(inventoryIn,InventoryInDO.class);
        inventoryInDO.setInventoryInTenantId(RedisUtil.getLocalTenantId());
        // 新增入库单主表信息
        inventoryInMapper.insert(inventoryInDO);
        // 将入库单明细表实体集合转换为数据库表对象集合
        List<InventoryInDetailDO> inDetailDOList = Convert.listConvert(inDetailList,InventoryInDetailDO.class);
        // 组装库存数量数据
        AssemblyData(inDetailDOList,inventoryInDO,1);
        return true;
    }

    /**
     * 待入库发起入库
     * @param id
     * @return
     */
    @Override
    public Boolean waitToSave(String id) {
        // 找到对应的入库单
        InventoryInDO inventoryInDO = inventoryInMapper.selectById(id);
        // 修改入库单状态为已入库
        inventoryInDO.setInventoryInStatus(Constant.ALREADY_WAREHOUSING);
        // 设置入库时间
        inventoryInDO.setInventoryInTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        // 为了使最新数据ID都最新，先删除旧的再新增新的
        inventoryInMapper.deleteById(inventoryInDO.getInventoryInId());
        inventoryInDO.setInventoryInId(null);
        inventoryInMapper.insert(inventoryInDO);

        // 获取对应的明细数据
        QueryWrapper<InventoryInDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryInDetailDO::getInventoryInId,id);
        List<InventoryInDetailDO> inDetailDOList = inventoryInDetailMapper.selectList(queryWrapper);
        // 组装库存数量数据
        AssemblyData(inDetailDOList,inventoryInDO,2);
        return true;
    }

    /**
     * 组装数据
     * @param inDetailDOList
     * @param inventoryInDO
     * @param status
     */
    public void AssemblyData(List<InventoryInDetailDO> inDetailDOList,InventoryInDO inventoryInDO,int status){
        // 将涉及到的商品ID的库存信息查出来
        QueryWrapper<InventoryDO> inventoryDOQueryWrapper = new QueryWrapper<>();
        inventoryDOQueryWrapper.lambda().in(InventoryDO::getInventoryCommodityId,inDetailDOList.stream().map(InventoryInDetailDO::getInventoryInCommodityId).collect(Collectors.toList()));
        List<InventoryDO> inventoryDOList = inventoryMapper.selectList(inventoryDOQueryWrapper);

        // 对库存数量进行处理
        inventoryDOList.forEach(inventoryDO -> {
            // 将商品ID相同的对象匹配起来
            InventoryInDetailDO inventoryInDetailDO = inDetailDOList.stream().filter(detail -> detail.getInventoryInCommodityId().equals(inventoryDO.getInventoryCommodityId())).findFirst().orElse(null);
            assert inventoryInDetailDO != null;
            // 设置明细表的主表ID
            inventoryInDetailDO.setInventoryInId(inventoryInDO.getInventoryInId());
            // 入库明细单设置入库操作之前的库存数量
            inventoryInDetailDO.setInventoryInBeforeLargeNum(inventoryDO.getInventoryLargeNum());
            inventoryInDetailDO.setInventoryInBeforeSmallNum(inventoryDO.getInventorySmallNum());

            if(status == 1){
                // 通过大小转换单位比计算出入库数量
                Map<String, Integer> map1 = Calculate.inventoryQuantity(
                        inventoryInDetailDO.getInventoryInLargeNum(),
                        inventoryInDetailDO.getInventoryInSmallNum(),
                        inventoryDO.getInventoryDosageForm());
                // 入库明细单设置入库操作的库存数量
                inventoryInDetailDO.setInventoryInLargeNum(map1.get(Constant.LARGE_NUM));
                inventoryInDetailDO.setInventoryInSmallNum(map1.get(Constant.SMALL_NUM));
            }

            // 通过大小转换单位比计算之后库存
            Map<String, Integer> map2 = Calculate.inventoryQuantity(
                    inventoryDO.getInventoryLargeNum() + inventoryInDetailDO.getInventoryInLargeNum(),
                    inventoryDO.getInventorySmallNum() + inventoryInDetailDO.getInventoryInSmallNum(),
                    inventoryDO.getInventoryDosageForm());
            // 库存主表设置入库操作之后的库存数
            inventoryDO.setInventoryLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryDO.setInventorySmallNum(map2.get(Constant.SMALL_NUM));

            // 入库明细单设置入库操作之后的库存数量
            inventoryInDetailDO.setInventoryInAfterLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryInDetailDO.setInventoryInAfterSmallNum(map2.get(Constant.SMALL_NUM));

            // 如果状态为已入库则更新库存主表
            if (Constant.ALREADY_WAREHOUSING.equals(inventoryInDO.getInventoryInStatus())) {
                // 更新库存主表的信息
                inventoryMapper.updateById(inventoryDO);
            }
            if(status == 2){
                // 先删除旧的入库明细表信息，再添加新的
                inventoryInDetailMapper.deleteById(inventoryInDetailDO.getInventoryInDetailId());
            }
            // 新增入库明细表信息,清空主键id
            inventoryInDetailDO.setInventoryInDetailId(null);
            inventoryInDetailMapper.insert(inventoryInDetailDO);
        });
    }

}
