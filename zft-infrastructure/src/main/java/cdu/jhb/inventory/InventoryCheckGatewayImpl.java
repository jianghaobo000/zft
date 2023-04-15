package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.InventoryCheckInfo;
import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
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
public class InventoryCheckGatewayImpl implements InventoryCheckGateway {

    private final InventoryCheckMapper inventoryCheckMapper;

    @Override
    public List<InventoryCheckInfo> getInventoryCheckList(InventoryCheckListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventory_check_tenant_id(RedisUtil.getLocalTenantId());
        return inventoryCheckMapper.getInventoryCheckList(query);
    }
}
