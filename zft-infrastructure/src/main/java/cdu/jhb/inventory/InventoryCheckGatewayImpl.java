package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;
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
public class InventoryCheckGatewayImpl implements InventoryCheckGateway {

    private final InventoryCheckMapper inventoryCheckMapper;

    @Override
    public List<InventoryCheckInfoDTO> getInventoryCheckList(InventoryCheckListQuery query) {
        Jedis jedis = new Jedis();
        query.setInventory_check_tenant_id(Long.valueOf(jedis.get("tenantId")));
        return inventoryCheckMapper.getInventoryCheckList(query);
    }
}
