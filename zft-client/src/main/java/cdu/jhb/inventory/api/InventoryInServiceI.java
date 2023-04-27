package cdu.jhb.inventory.api;

import cdu.jhb.inventory.data.dto.InventoryInDTO;
import cdu.jhb.inventory.data.dto.InventoryInInfoDTO;
import cdu.jhb.inventory.data.request.InventoryInListQuery;
import cdu.jhb.inventory.data.response.InventoryInListResponse;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryInServiceI {

    /**
     * 获取入库单列表
     * @param query
     * @return
     */
    InventoryInListResponse getInventoryInList(InventoryInListQuery query);

    /**
     * 查询入库单详情
     * @param id
     * @return
     */
    InventoryInInfoDTO selectInDetailById(Long id);

    /**
     * 保存入库单
     * @param inventoryInDTO
     * @return
     */
    Boolean saveInventoryIn(InventoryInDTO inventoryInDTO);

    /**
     * 待入库发起入库
     * @param id
     * @return
     */
    Boolean waitToSaveIn(Long id);
}
