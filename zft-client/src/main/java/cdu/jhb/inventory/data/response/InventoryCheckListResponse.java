package cdu.jhb.inventory.data.response;

import cdu.jhb.inventory.data.dto.InventoryCheckInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/27 10:55
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheckListResponse {
    /**
     * 入库单列表
     */
    private List<InventoryCheckInfoDTO> checkDTOList;

    /**
     * 入库单总数
     */
    private Integer total;

    /**
     * 最大页数
     */
    private Integer maxPage;
}
