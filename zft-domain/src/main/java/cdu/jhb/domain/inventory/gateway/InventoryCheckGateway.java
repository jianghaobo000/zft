package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.InventoryCheck;
import cdu.jhb.domain.inventory.InventoryCheckDetail;
import cdu.jhb.domain.inventory.InventoryCheckInfo;
import cdu.jhb.inventory.data.request.InventoryCheckListQuery;
import cdu.jhb.inventory.data.response.InventoryCheckListResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:19
* @version 1.0
*/
public interface InventoryCheckGateway {

    /**
     * 获取盘点单列表
     * @param query
     * @return
     */
    InventoryCheckListResponse getInventoryCheckList(InventoryCheckListQuery query);

    /**
     * 获取盘点单主表
     * @param id
     * @return
     */
    InventoryCheckInfo selectCheckInfo(Long id);

    /**
     * 获取盘点单明细列表
     * @param id
     * @return
     */
    List<InventoryCheckDetail> selectCheckDetail(Long id);

    /**
     * 保存盘点单
     * @param inventoryCheck
     * @param checkDetailList
     * @return
     */
    Boolean saveInventoryCheck(InventoryCheck inventoryCheck,List<InventoryCheckDetail> checkDetailList);

    /**
     * 待盘点重新发起
     * @param id
     * @return
     */
    Boolean waitToSaveCheck(Long id);
}
