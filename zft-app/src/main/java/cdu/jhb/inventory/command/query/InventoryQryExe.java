package cdu.jhb.inventory.command.query;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.InventoryGatewayImpl;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    /**
     *
     * @param query
     * @return
     */
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query){
        return inventoryGateway.getInventoryList(query);
    }
}
