package cdu.jhb.inventory.api;

import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryServiceI {
    /**
     * 获取库存商品列表
     * @param query
     * @return
     */
    List<InventoryInfoDTO> getInventoryList(InventoryListQuery query);
}
