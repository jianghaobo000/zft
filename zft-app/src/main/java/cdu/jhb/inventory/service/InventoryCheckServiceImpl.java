package cdu.jhb.inventory.service;

import cdu.jhb.common.Constant;
import cdu.jhb.inventory.api.InventoryCheckServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.data.dto.InventoryCheckDTO;
import cdu.jhb.inventory.data.dto.InventoryCheckInfoDTO;
import cdu.jhb.inventory.data.request.InventoryCheckListQuery;
import cdu.jhb.inventory.data.response.InventoryCheckListResponse;
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
    public InventoryCheckListResponse getInventoryCheckList(InventoryCheckListQuery query) {
        if(!Constant.NULL_STRING.equals(query.getInventoryCheckBeginTime()) && !Constant.NULL_STRING.equals(query.getInventoryCheckEndTime())){
            query.setInventoryCheckBeginTime(query.getInventoryCheckBeginTime()+Constant.BEGIN_TIME);
            query.setInventoryCheckEndTime(query.getInventoryCheckEndTime()+Constant.END_TIME);
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

    /**
     * 新增盘点单
     * @param inventoryCheckDTO
     * @return
     */
    @Override
    public Boolean saveInventoryCheck(InventoryCheckDTO inventoryCheckDTO) {
        return inventoryModExe.saveInventoryCheck(inventoryCheckDTO);
    }

    /**
     * 待盘点重新发起
     * @param id
     * @return
     */
    @Override
    public Boolean waitToSaveCheck(Long id) {
        return inventoryModExe.waitToSaveCheck(id);
    }
}
