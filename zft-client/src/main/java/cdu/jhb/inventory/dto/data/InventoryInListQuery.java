package cdu.jhb.inventory.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 入库单查询对象
* @author jhb
* @date 2023/04/07 21:33
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryInListQuery {
    /**
     * 入库单状态
     */
    private String inventory_in_status;

    /**
     * 入库单类型 1:创建时间 2:入库时间
     */
    private Integer inventory_in_date_category;

    /**
     * 入库单开始时间
     */
    private String inventory_in_begin_time;

    /**
     * 入库单结束时间
     */
    private String inventory_in_end_time;

    /**
     * 入库单供应商ID
     */
    private Long inventory_in_supplier_id;

    /**
     * 入库人ID
     */
    private Long inventory_in_operator_id;

    /**
     * 入库单所属诊所
     */
    private Long inventory_in_tenant_id;
}
