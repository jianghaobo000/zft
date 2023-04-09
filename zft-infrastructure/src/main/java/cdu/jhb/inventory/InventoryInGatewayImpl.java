package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
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
public class InventoryInGatewayImpl implements InventoryInGateway {

    private final InventoryInMapper inventoryInMapper;

    @Override
    public List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query) {
        Jedis jedis = new Jedis();
        query.setInventory_in_tenant_id(Long.valueOf(jedis.get("tenantId")));
        return inventoryInMapper.getInventoryInList(query);
    }
}
