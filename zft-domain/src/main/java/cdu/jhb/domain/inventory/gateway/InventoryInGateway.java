package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:19
* @version 1.0
*/
public interface InventoryInGateway {

    List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query);
}
