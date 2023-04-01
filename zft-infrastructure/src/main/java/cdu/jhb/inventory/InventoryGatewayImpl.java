package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query) {
        return inventoryMapper.getInventoryList(query);
    }
}
