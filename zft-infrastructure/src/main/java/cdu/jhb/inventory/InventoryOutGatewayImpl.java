package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.InventoryOutInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryOutGateway;
import cdu.jhb.inventory.database.InventoryOutMapper;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;
import cdu.jhb.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:20
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryOutGatewayImpl implements InventoryOutGateway {

    private final InventoryOutMapper inventoryOutMapper;

    /**
     * 获取出库单列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryOutInfo> getInventoryOutList(InventoryOutListQuery query) {
        query.setInventory_out_tenant_id(RedisUtil.getLocalTenantId());
        return inventoryOutMapper.getInventoryOutList(query);
    }
}
