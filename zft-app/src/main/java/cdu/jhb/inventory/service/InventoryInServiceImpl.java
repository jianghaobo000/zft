package cdu.jhb.inventory.service;

import cdu.jhb.common.Constant;
import cdu.jhb.inventory.api.InventoryInServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
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
        if(!Constant.NULL_STRING.equals(query.getInventoryInBeginTime()) && !Constant.NULL_STRING.equals(query.getInventoryInEndTime())){
            query.setInventoryInBeginTime(query.getInventoryInBeginTime()+Constant.BEGIN_TIME);
            query.setInventoryInEndTime(query.getInventoryInEndTime()+Constant.END_TIME);
        }
        return inventoryQryExe.getInventoryInList(query);
    }

    /**
     * 获取入库单明细
     * @param id
     * @return
     */
    @Override
    public InventoryInInfoDTO selectInDetailById(Long id) {
        return inventoryQryExe.selectInDetailById(id);
    }

    /**
     * 保存入库单
     * @param inventoryInDTO
     * @return
     */
    @Override
    public Boolean saveInventoryIn(InventoryInDTO inventoryInDTO) {
        return inventoryModExe.saveInventoryIn(inventoryInDTO);
    }

    /**
     * 待入库发起入库
     * @param id
     * @return
     */
    @Override
    public Boolean waitToSave(String id) {
        return inventoryModExe.waitToSave(id);
    }
}
