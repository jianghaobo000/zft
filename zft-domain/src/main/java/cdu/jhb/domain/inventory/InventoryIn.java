package cdu.jhb.domain.inventory;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
     * 入库单状态
     */
    private String inventory_in_status;

    /**
     * 入库单供应商ID
     */
    private Long inventory_in_supplier_id;

    /**
     * 入库时间
     */
    private String inventory_in_time;

    /**
     * 入库单创建时间
     */
    private String inventory_in_create_time;

    /**
     * 入库人
     */
    private Long inventory_in_operator_id;

    /**
     * 入库品种数
     */
    private Integer inventory_in_variety;

    /**
     * 入库单备注
     */
    private String inventory_in_remarks;

    /**
     * 入库单金额
     */
    private BigDecimal inventory_in_money;

    /**
     * 入库单所属诊所
     */
    private Long inventory_in_tenant_id;
}
