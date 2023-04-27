package cdu.jhb.inventory.api;

import cdu.jhb.inventory.data.dto.InventoryOutDTO;
import cdu.jhb.inventory.data.dto.InventoryOutInfoDTO;
import cdu.jhb.inventory.data.request.InventoryOutListQuery;
import cdu.jhb.inventory.data.response.InventoryOutListResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryOutServiceI {

    InventoryOutListResponse getInventoryOutList(InventoryOutListQuery query);

    InventoryOutInfoDTO selectOutDetailById(Long id);

    Boolean saveInventoryOut(InventoryOutDTO inventoryOutDTO);

    Boolean waitToSaveOut(Long id);
}
