package cdu.jhb.inventory.command;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.database.dataobject.CommodityDO;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.domain.inventory.gateway.InventoryOutGateway;
import cdu.jhb.inventory.InventoryGatewayImpl;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.InventoryOutMapper;
import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import cdu.jhb.inventory.dto.data.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
* @description: 库存查询器
* @author jhb
* @date 2023/04/01 21:18
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryQryExe {

    private final InventoryGateway inventoryGateway;

    private final InventoryInGateway inventoryInGateway;

    private final InventoryOutGateway inventoryOutGateway;

    private final InventoryCheckGateway inventoryCheckGateway;

    private final InventoryInMapper inventoryInMapper;

    private final InventoryOutMapper inventoryOutMapper;

    private final InventoryCheckMapper inventoryCheckMapper;

    private final InventoryMapper inventoryMapper;

    private final CommodityMapper commodityMapper;

    /**
     * 通过条件获取商品列表
     * @param query
     * @return
     */
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query){
        Jedis jedis = new Jedis();
        query.setInventory_tenant_id(Long.valueOf(jedis.get("tenantId")));
        return inventoryGateway.getInventoryList(query);
    }

    /**
     * 通过Id查询商品
     * @param id
     * @return
     */
    public Commodity selectById(Long id){
        CommodityDO commodityDO = commodityMapper.selectById(id);
        return DozerBeanMapperBuilder.buildDefault().map(commodityDO,Commodity.class);
    }

    /**
     * 查询入库单列表
     * @return
     */
    public List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query){
        return inventoryInGateway.getInventoryInList(query);
    }

    /**
     * 查询入库单列表
     * @return
     */
    public List<InventoryOutInfoDTO> getInventoryOutList(InventoryOutListQuery query){
        return inventoryOutGateway.getInventoryOutList(query);
    }

    /**
     * 查询供应商列表
     * @return
     */
    public List<SupplierDTO> getSupplierList(){
        Jedis jedis = new Jedis();
        Long tenantId = Long.valueOf(jedis.get("tenantId"));
        return inventoryMapper.getSupplierList(tenantId);
    }
}
