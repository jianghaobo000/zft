package cdu.jhb.inventory.api;

import cdu.jhb.inventory.data.dto.InventoryCheckDTO;
import cdu.jhb.inventory.data.dto.InventoryCheckInfoDTO;
import cdu.jhb.inventory.data.request.InventoryCheckListQuery;
import cdu.jhb.inventory.data.response.InventoryCheckListResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryCheckServiceI {

    InventoryCheckListResponse getInventoryCheckList(InventoryCheckListQuery query);

    InventoryCheckInfoDTO selectCheckDetailById(Long id);

    Boolean saveInventoryCheck(InventoryCheckDTO inventoryCheckDTO);

    Boolean waitToSaveCheck(Long id);

}
