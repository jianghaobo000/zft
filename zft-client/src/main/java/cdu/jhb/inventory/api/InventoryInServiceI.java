package cdu.jhb.inventory.api;

import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;

import java.util.List;

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
    List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query);

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
    Boolean waitToSave(String id);
}
