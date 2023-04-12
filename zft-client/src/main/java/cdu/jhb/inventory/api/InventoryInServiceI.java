package cdu.jhb.inventory.api;

import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryInServiceI {

    List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query);

    InventoryInInfoDTO selectInDetailById(Long id);
}
