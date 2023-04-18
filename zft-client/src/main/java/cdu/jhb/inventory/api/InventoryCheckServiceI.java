package cdu.jhb.inventory.api;

import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryCheckServiceI {

    List<InventoryCheckInfoDTO> getInventoryCheckList(InventoryCheckListQuery query);

    InventoryCheckInfoDTO selectCheckDetailById(Long id);

}
