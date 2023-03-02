package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 入库单实体
* @author jhb
* @date 2023/2/21 11:19
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryIn {
    /**
     * 入库单ID
     */
    private Long inventory_in_id;

    /**
     * 入库时间
     */
    private String inventory_in_time;

    /**
     * 入库人
     */
    private Long inventory_in_operator_id;

    /**
     * 入库品种数
     */
    private Integer inventory_in_variety;

    /**
     * 入库单所属诊所
     */
    private Long inventory_in_tenant_id;
}
