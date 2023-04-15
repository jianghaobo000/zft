package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.InventoryCheckInfo;
import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:19
* @version 1.0
*/
public interface InventoryCheckGateway {

    List<InventoryCheckInfo> getInventoryCheckList(InventoryCheckListQuery query);
}
