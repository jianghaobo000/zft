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
public class InventoryCheckListQuery {
    /**
     * 盘点单状态
     */
    private String inventory_check_status;

    /**
     * 盘点单类型 1:创建时间 2:出库时间
     */
    private Integer inventory_check_date_category;

    /**
     * 盘点单开始时间
     */
    private String inventory_check_begin_time;

    /**
     * 盘点单结束时间
     */
    private String inventory_check_end_time;

    /**
     * 盘点人ID
     */
    private Long inventory_check_operator_id;

    /**
     * 盘点单所属诊所
     */
    private Long inventory_check_tenant_id;
}
