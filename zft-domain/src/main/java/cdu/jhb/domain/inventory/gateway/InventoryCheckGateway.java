package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.InventoryCheckDetail;
import cdu.jhb.domain.inventory.InventoryCheckInfo;
import cdu.jhb.domain.inventory.InventoryOutDetail;
import cdu.jhb.domain.inventory.InventoryOutInfo;
import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;

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
    List<InventoryCheckInfo> getInventoryCheckList(InventoryCheckListQuery query);

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
}
