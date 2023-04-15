package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.InventoryInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
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
public class InventoryGatewayImpl implements InventoryGateway {

    private final InventoryMapper inventoryMapper;

    @Override
    public List<InventoryInfo> getInventoryList(InventoryListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventory_tenant_id(RedisUtil.getLocalTenantId());
        return inventoryMapper.getInventoryList(query);
    }
}
