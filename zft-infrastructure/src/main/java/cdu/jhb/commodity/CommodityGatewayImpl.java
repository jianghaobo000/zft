package cdu.jhb.commodity;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.database.dataobject.CommodityDO;
import cdu.jhb.common.DictException;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import cdu.jhb.domain.inventory.Inventory;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.dataobject.InventoryDO;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
* @description: 商品网关层
* @author jhb
* @date 2023/03/31 18:19
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class CommodityGatewayImpl implements CommodityGateway {

    private final CommodityMapper commodityMapper;
    private final InventoryMapper inventoryMapper;

    /**
     * 新增品项
     * @param commodity
     * @return
     */
    @Override
    public Boolean addCommodity(Commodity commodity) {
        // 将实体转换为表对象
        CommodityDO commodityDO = Convert.entityConvert(commodity, CommodityDO.class);
        // 从redis缓存中获取当前登录租户国家码
        commodityDO.setCommodityTenantId(RedisUtil.getLocalTenantId());
        // 如果没有商品ID，则为新增，反之修改
        if(commodityDO.getCommodityId()==null){
            int row1 = commodityMapper.insert(commodityDO);
            if(row1 == 1){
                InventoryDO inventoryDO = new InventoryDO();
                inventoryDO.setInventoryCommodityId(commodityDO.getCommodityId());
                inventoryDO.setInventoryCommodityName(commodityDO.getCommodityName());
                inventoryDO.setInventoryCommodityPinyin(commodityDO.getCommodityPinyin());
                inventoryDO.setInventoryDosageForm(commodityDO.getCommodityDosageForm());
                inventoryDO.setInventoryLargeUnit(commodityDO.getCommodityLargeUnit());
                inventoryDO.setInventorySmallUnit(commodityDO.getCommoditySmallUnit());
                inventoryDO.setInventoryTenantId(commodityDO.getCommodityTenantId());
                int row2 = inventoryMapper.insert(inventoryDO);
                return row2 == 1;
            }
        }else{
            int row1 = commodityMapper.updateById(commodityDO);
            if(row1 == 1){
                UpdateWrapper<InventoryDO> updateWrapper = new UpdateWrapper<>();
                updateWrapper.lambda().eq(InventoryDO::getInventoryCommodityId,commodityDO.getCommodityId())
                        .set(InventoryDO::getInventoryCommodityName,commodityDO.getCommodityName())
                        .set(InventoryDO::getInventoryCommodityPinyin,commodityDO.getCommodityPinyin())
                        .set(InventoryDO::getInventoryDosageForm,commodityDO.getCommodityDosageForm())
                        .set(InventoryDO::getInventoryLargeUnit,commodityDO.getCommodityLargeUnit())
                        .set(InventoryDO::getInventorySmallUnit,commodityDO.getCommoditySmallUnit());
                int row2 = inventoryMapper.update(null,updateWrapper);
                return row2 == 1;
            }
        }
        return false;
    }

    /**
     * 搜索药品(可通过名称与拼音全拼简拼进行模糊查询)
     * @param name
     * @return
     */
    @Override
    public List<Commodity> selectCommodity(String name) {
        QueryWrapper<CommodityDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(CommodityDO::getCommodityName,name)
                .or()
                .like(CommodityDO::getCommodityPinyin,name)
                .eq(CommodityDO::getCommodityEnableStatus,1)
                .eq(CommodityDO::getCommodityTenantId,RedisUtil.getLocalTenantId());
        List<CommodityDO> commodityDOList = commodityMapper.selectList(queryWrapper);
        return Convert.listConvert(commodityDOList,Commodity.class);
    }

    /**
     * 通过ID搜索药品
     * @param id
     * @return
     */
    @Override
    public Commodity selectCommodityById(Long id) {
        CommodityDO commodityDO = commodityMapper.selectById(id);
        return Convert.entityConvert(commodityDO,Commodity.class);
    }

    /**
     * 设置商品启用状态
     * @param id
     * @param enable
     * @return
     */
    @Override
    public Boolean enableOrDeactivate(Long id, Integer enable) {
        UpdateWrapper<CommodityDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(CommodityDO::getCommodityId,id).set(CommodityDO::getCommodityEnableStatus,enable);
        if(commodityMapper.update(null,updateWrapper) != 1){
            throw new RuntimeException(DictException.UPDATE_PRODUCT_ENABLE_FAILED);
        }
        return true;
    }
}
