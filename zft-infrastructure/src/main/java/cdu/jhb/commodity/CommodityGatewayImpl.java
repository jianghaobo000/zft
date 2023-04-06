package cdu.jhb.commodity;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.database.dataobject.CommodityDO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import cdu.jhb.domain.inventory.Inventory;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.dataobject.InventoryDO;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
    private final TenantGateway tenantGateway;

    /**
     * 新增品项
     * @param commodity
     * @return
     */
    @Override
    public Boolean addCommodity(Commodity commodity) {
        CommodityDO commodityDO = DozerBeanMapperBuilder.buildDefault().map(commodity,CommodityDO.class);
        // 从redis缓存中获取当前登录租户国家码
        Jedis jedis = new Jedis();
        commodityDO.setCommodity_tenant_id(Long.valueOf(jedis.get("tenantId")));
        // 如果没有商品ID，则为新增，反之修改
        if(commodityDO.getCommodity_id()==null){
            int row1 = commodityMapper.insert(commodityDO);
            if(row1 == 1){
                InventoryDO inventoryDO = new InventoryDO();
                inventoryDO.setInventory_commodity_id(commodityDO.getCommodity_id());
                inventoryDO.setInventory_commodity_name(commodityDO.getCommodity_name());
                inventoryDO.setInventory_large_unit(commodityDO.getCommodity_large_unit());
                inventoryDO.setInventory_small_unit(commodityDO.getCommodity_small_unit());
                inventoryDO.setInventory_tenant_id(commodityDO.getCommodity_tenant_id());
                int row2 = inventoryMapper.insert(inventoryDO);
                return row2 == 1;
            }
        }else{
            int row1 = commodityMapper.updateById(commodityDO);
            if(row1 == 1){
                UpdateWrapper<InventoryDO> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("inventory_commodity_id",commodityDO.getCommodity_id())
                        .set("inventory_commodity_name",commodityDO.getCommodity_name())
                        .set("inventory_large_unit",commodityDO.getCommodity_large_unit())
                        .set("inventory_small_unit",commodityDO.getCommodity_small_unit());
                int row2 = inventoryMapper.update(null,updateWrapper);
                return row2 == 1;
            }
        }
        return false;
    }
}
