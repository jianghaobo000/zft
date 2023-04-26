package cdu.jhb.inventory.command;

import cdu.jhb.common.Constant;
import cdu.jhb.domain.inventory.InventoryIn;
import cdu.jhb.domain.inventory.InventoryInDetail;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.util.Convert;
import cdu.jhb.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
* @description: 库存修改器
* @author jhb
* @date 2023/04/01 21:18
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryModExe {

    private final InventoryInMapper inventoryInMapper;

    private final InventoryInGateway inventoryInGateway;

    /**
     * 保存入库单
     * @param inventoryInDTO
     * @return
     */
    public Boolean saveInventoryIn(InventoryInDTO inventoryInDTO) {
        InventoryIn inventoryIn = Convert.entityConvert(inventoryInDTO,InventoryIn.class);
        // 如果入库单状态为已入库，那就更新入库时间为当前时间
        if(Constant.ALREADY_WAREHOUSING.equals(inventoryIn.getInventoryInStatus())){
            inventoryIn.setInventoryInTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        }else{
            inventoryIn.setInventoryInTime(null);
        }
        inventoryIn.setInventoryInCreateTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        List<InventoryInDetail> inDetailList = Convert.listConvert(inventoryInDTO.getInventoryInDetailList(),InventoryInDetail.class);
        return inventoryInGateway.saveInventoryIn(inventoryIn,inDetailList);
    }

    /**
     * 待入库发起入库
     * @param id
     * @return
     */
    public Boolean waitToSave(String id) {
        return inventoryInGateway.waitToSave(id);
    }
}
