package cdu.jhb.inventory.service;

import cdu.jhb.inventory.api.InventoryCheckServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @description: 库存服务层
* @author jhb
* @date 2023/04/01 21:16
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class InventoryCheckServiceImpl implements InventoryCheckServiceI {

    private final InventoryModExe inventoryModExe;

    private final InventoryQryExe inventoryQryExe;
}
