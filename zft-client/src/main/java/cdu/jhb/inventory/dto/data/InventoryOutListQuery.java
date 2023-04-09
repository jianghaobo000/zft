package cdu.jhb.inventory.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 品相信息查询条件
* @author jhb
* @date 2023/04/01 16:14
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryOutListQuery {
    /**
     * 出库单状态
     */
    private String inventory_out_status;

    /**
     * 出库单类型 1:创建时间 2:出库时间
     */
    private Integer inventory_out_date_status;

    /**
     * 出库单开始时间
     */
    private String inventory_out_begin_time;

    /**
     * 出库单结束时间
     */
    private String inventory_out_end_time;

    /**
     * 出库单类型 领料出库、报损出库
     */
    private String inventory_out_category;

    /**
     * 出库人ID
     */
    private Long inventory_out_operator_id;

    /**
     * 出库单所属诊所
     */
    private Long inventory_out_tenant_id;
}
