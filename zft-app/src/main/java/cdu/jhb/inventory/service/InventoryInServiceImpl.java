package cdu.jhb.inventory.service;

import cdu.jhb.inventory.api.InventoryInServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
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

    private final InventoryModExe inventoryModExe;

    private final InventoryQryExe inventoryQryExe;

    /**
     * 获取入库单列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query) {
        //设置日期格式 开始时间为一天的开始，结束时间为一天的最后
        query.setInventory_in_begin_time(query.getInventory_in_begin_time()+" 00:00:00");
        query.setInventory_in_end_time(query.getInventory_in_end_time()+" 23:59:59");
        return inventoryQryExe.getInventoryInList(query);
    }
}
