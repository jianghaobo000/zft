package cdu.jhb.inventory.data.response;

import cdu.jhb.inventory.data.dto.InventoryInInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @description: 入库单列表响应参数
* @author jhb
* @date 2023/04/27 10:54
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInListResponse {
    /**
     * 入库单列表
     */
    private List<InventoryInInfoDTO> inDTOList;

    /**
     * 入库单总数
     */
    private Integer total;

    /**
     * 最大页数
     */
    private Integer maxPage;
}
