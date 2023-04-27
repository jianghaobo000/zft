package cdu.jhb.inventory.service;

import cdu.jhb.common.Constant;
import cdu.jhb.inventory.api.InventoryOutServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.data.dto.InventoryOutDTO;
import cdu.jhb.inventory.data.dto.InventoryOutInfoDTO;
import cdu.jhb.inventory.data.request.InventoryOutListQuery;
import cdu.jhb.inventory.data.response.InventoryOutListResponse;
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
    public InventoryOutListResponse getInventoryOutList(InventoryOutListQuery query) {
        //设置日期格式 开始时间为一天的开始，结束时间为一天的最后
        if(!Constant.NULL_STRING.equals(query.getInventoryOutBeginTime()) && !Constant.NULL_STRING.equals(query.getInventoryOutEndTime())){
            query.setInventoryOutBeginTime(query.getInventoryOutBeginTime()+Constant.BEGIN_TIME);
            query.setInventoryOutEndTime(query.getInventoryOutEndTime()+Constant.END_TIME);
        }
        return inventoryQryExe.getInventoryOutList(query);
    }

    /**
     * 获取出库单详情
     * @param id
     * @return
     */
    @Override
    public InventoryOutInfoDTO selectOutDetailById(Long id) {
        return inventoryQryExe.selectOutDetailById(id);
    }

    /**
     * 保存入库单
     * @param inventoryOutDTO
     * @return
     */
    @Override
    public Boolean saveInventoryOut(InventoryOutDTO inventoryOutDTO) {
        return inventoryModExe.saveInventoryOut(inventoryOutDTO);
    }

    /**
     * 出库单重新发起
     * @param id
     * @return
     */
    @Override
    public Boolean waitToSaveOut(Long id) {
        return inventoryModExe.waitToSaveOut(id);
    }


}
