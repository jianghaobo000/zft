package cdu.jhb.inventory.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 入库单信息DTO
* @author jhb
* @date 2023/04/07 22:17
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInInfoDTO {
    /**
     * 入库单ID
     */
    private Long inventory_in_id;

    /**
     * 入库单状态
     */
    private String inventory_in_status;

    /**
     * 入库单供应商
     */
    private String inventory_in_supplier_name;

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
    private String inventory_in_operator;

    /**
     * 入库品种数
     */
    private Integer inventory_in_variety;

    /**
     * 入库单备注
     */
    private String inventory_remarks;

    /**
     * 入库单金额
     */
    private BigDecimal inventory_in_money;
}
