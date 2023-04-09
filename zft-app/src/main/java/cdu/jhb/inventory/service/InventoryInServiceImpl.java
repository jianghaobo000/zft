package cdu.jhb.inventory.service;

import cdu.jhb.inventory.api.InventoryInServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 库存服务层
* @author jhb
* @date 2023/04/01 21:16
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class InventoryInServiceImpl implements InventoryInServiceI {

    private final InventoryQryExe inventoryQryExe;

    @Override
    public List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query) {
        return inventoryQryExe.getInventoryInList(query);
    }
}
