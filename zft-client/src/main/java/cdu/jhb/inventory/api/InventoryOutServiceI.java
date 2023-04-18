package cdu.jhb.inventory.api;

import cdu.jhb.inventory.dto.data.InventoryOutDTO;
import cdu.jhb.inventory.dto.data.InventoryOutDetailDTO;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryOutServiceI {

    List<InventoryOutInfoDTO> getInventoryOutList(InventoryOutListQuery query);

    InventoryOutInfoDTO selectOutDetailById(Long id);
}
