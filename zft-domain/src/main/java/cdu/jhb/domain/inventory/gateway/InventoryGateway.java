package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.InventoryInfo;
import cdu.jhb.inventory.data.request.InventoryListQuery;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:19
* @version 1.0
*/
public interface InventoryGateway {
    /**
     * 药品物资页面获取商品列表
     * @param query
     * @return
     */
    List<InventoryInfo> getInventoryList(InventoryListQuery query);
}
