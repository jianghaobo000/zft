package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 出库单实体
* @author jhb
* @date 2023/2/21 11:20
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOut {
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
