package cdu.jhb.inventory.service;

import cdu.jhb.common.Constant;
import cdu.jhb.inventory.api.InventoryCheckServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
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
public class InventoryCheckServiceImpl implements InventoryCheckServiceI {

    private final InventoryModExe inventoryModExe;

    private final InventoryQryExe inventoryQryExe;


    /**
     * 获取盘点单列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryCheckInfoDTO> getInventoryCheckList(InventoryCheckListQuery query) {
        if(!Constant.NULL_STRING.equals(query.getInventory_check_begin_time()) && !Constant.NULL_STRING.equals(query.getInventory_check_end_time())){
            query.setInventory_check_begin_time(query.getInventory_check_begin_time()+Constant.BEGIN_TIME);
            query.setInventory_check_end_time(query.getInventory_check_end_time()+Constant.END_TIME);
        }
        return inventoryQryExe.getInventoryCheckList(query);
    }


    /**
     * 查询盘点单明细列表
     * @param id
     * @return
     */
    @Override
    public InventoryCheckInfoDTO selectCheckDetailById(Long id) {
        return inventoryQryExe.selectCheckDetailById(id);
    }
}
