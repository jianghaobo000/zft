package cdu.jhb.inventory.service;

import cdu.jhb.inventory.api.InventoryOutServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.dto.data.InventoryOutDTO;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;
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
public class InventoryOutServiceImpl implements InventoryOutServiceI {

    private final InventoryModExe inventoryModExe;

    private final InventoryQryExe inventoryQryExe;

    /**
     * 获取出库单列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryOutInfoDTO> getInventoryOutList(InventoryOutListQuery query) {
        return inventoryQryExe.getInventoryOutList(query);
    }
}
