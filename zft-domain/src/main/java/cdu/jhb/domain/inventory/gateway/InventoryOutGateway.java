package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.*;
import cdu.jhb.inventory.data.request.InventoryOutListQuery;
import cdu.jhb.inventory.data.response.InventoryOutListResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:19
* @version 1.0
*/
public interface InventoryOutGateway {

    /**
     * 获取出库单列表
     * @param query
     * @return
     */
    InventoryOutListResponse getInventoryOutList(InventoryOutListQuery query);

    /**
     * 获取出库单主表
     * @param id
     * @return
     */
    InventoryOutInfo selectOutInfo(Long id);

    /**
     * 获取出库单明细列表
     * @param id
     * @return
     */
    List<InventoryOutDetail> selectOutDetail(Long id);

    /**
     * 保存入库单
     * @param inventoryOut
     * @param outDetailList
     * @return
     */
    Boolean saveInventoryOut(InventoryOut inventoryOut, List<InventoryOutDetail> outDetailList);

    /**
     * 待入库发起入库
     * @param id
     * @return
     */
    Boolean waitToSaveOut(Long id);
}
