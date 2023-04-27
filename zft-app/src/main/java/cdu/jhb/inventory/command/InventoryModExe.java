package cdu.jhb.inventory.command;

import cdu.jhb.common.Constant;
import cdu.jhb.domain.inventory.*;
import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.domain.inventory.gateway.InventoryOutGateway;
import cdu.jhb.inventory.data.dto.InventoryCheckDTO;
import cdu.jhb.inventory.data.dto.InventoryOutDTO;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.data.dto.InventoryInDTO;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.InventoryOutMapper;
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

    private final InventoryMapper inventoryMapper;

    private final InventoryGateway inventoryGateway;

    private final InventoryInMapper inventoryInMapper;

    private final InventoryInGateway inventoryInGateway;

    private final InventoryOutMapper inventoryOutMapper;

    private final InventoryOutGateway inventoryOutGateway;

    private final InventoryCheckMapper inventoryCheckMapper;

    private final InventoryCheckGateway inventoryCheckGateway;

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
    public Boolean waitToSaveIn(Long id) {
        return inventoryInGateway.waitToSaveIn(id);
    }

    /**
     * 保存出库单
     * @param inventoryOutDTO
     * @return
     */
    public Boolean saveInventoryOut(InventoryOutDTO inventoryOutDTO) {
        InventoryOut inventoryOut = Convert.entityConvert(inventoryOutDTO,InventoryOut.class);
        // 如果出库单状态为已入库，那就更新出库时间为当前时间
        if(Constant.ALREADY_OUTBOUND.equals(inventoryOut.getInventoryOutStatus())){
            inventoryOut.setInventoryOutTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        }else{
            inventoryOut.setInventoryOutTime(null);
        }
        inventoryOut.setInventoryOutCreateTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        List<InventoryOutDetail> OutDetailList = Convert.listConvert(inventoryOutDTO.getInventoryOutDetailList(),InventoryOutDetail.class);
        return inventoryOutGateway.saveInventoryOut(inventoryOut,OutDetailList);
    }

    public Boolean waitToSaveOut(Long id) {
        return inventoryOutGateway.waitToSaveOut(id);
    }

    /**
     * 新增盘点单
     * @param inventoryCheckDTO
     * @return
     */
    public Boolean saveInventoryCheck(InventoryCheckDTO inventoryCheckDTO) {
        InventoryCheck inventoryCheck = Convert.entityConvert(inventoryCheckDTO,InventoryCheck.class);
        // 如果盘点单状态为已盘点，那就更新盘点时间为当前时间
        if(Constant.ALREADY_CHECK.equals(inventoryCheck.getInventoryCheckStatus())){
            inventoryCheck.setInventoryCheckTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        }else{
            inventoryCheck.setInventoryCheckTime(null);
        }
        inventoryCheck.setInventoryCheckCreateTime(DateUtil.DateToString(Constant.YMDHMS,new Date()));
        List<InventoryCheckDetail> checkDetailList = Convert.listConvert(inventoryCheckDTO.getInventoryCheckDetailList(),InventoryCheckDetail.class);
        return inventoryCheckGateway.saveInventoryCheck(inventoryCheck,checkDetailList);
    }

    /**
     * 待盘点重新发起
     * @param id
     * @return
     */
    public Boolean waitToSaveCheck(Long id) {
        return inventoryCheckGateway.waitToSaveCheck(id);
    }
}
