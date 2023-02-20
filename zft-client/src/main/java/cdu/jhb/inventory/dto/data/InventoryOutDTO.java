package cdu.jhb.inventory.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 出库单主表DTO
* @author jhb
* @date 2023/2/20 22:20
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOutDTO {
    /**
     * 出库单ID
     */
    private Long inventory_out_id;

    /**
     * 出库时间
     */
    private String inventory_out_time;

    /**
     * 出库人
     */
    private Long inventory_out_operator_id;

    /**
     * 出库品种数
     */
    private Integer inventory_out_variety;

    /**
     * 出库单所属诊所
     */
    private Long inventory_out_tenant_id;
}
