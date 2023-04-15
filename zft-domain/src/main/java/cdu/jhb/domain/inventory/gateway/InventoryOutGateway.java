package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.InventoryOutInfo;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;

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
    List<InventoryOutInfo> getInventoryOutList(InventoryOutListQuery query);
}
