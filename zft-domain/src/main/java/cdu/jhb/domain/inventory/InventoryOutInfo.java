package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 出库单信息DTO
* @author jhb
* @date 2023/04/07 22:17
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOutInfo {
    /**
     * 出库单ID
     */
    private Long inventory_out_id;

    /**
     * 出库单状态
     */
    private String inventory_out_status;

    /**
     * 出库类型
     */
    private String inventory_out_category;

    /**
     * 出库品种数
     */
    private int inventory_out_variety;

    /**
     * 出库时间
     */
    private String inventory_out_time;

    /**
     * 出库单创建时间
     */
    private String inventory_out_create_time;

    /**
     * 出库人
     */
    private String inventory_out_operator;

    /**
     * 出库单金额
     */
    private BigDecimal inventory_out_money;
}
