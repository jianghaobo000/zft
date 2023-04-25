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
    private Long inventoryOutId;

    /**
     * 出库单状态
     */
    private String inventoryOutStatus;

    /**
     * 出库类型
     */
    private String inventoryOutCategory;

    /**
     * 出库品种数
     */
    private int inventoryOutVariety;

    /**
     * 出库时间
     */
    private String inventoryOutTime;

    /**
     * 出库单创建时间
     */
    private String inventoryOutCreateTime;

    /**
     * 出库人
     */
    private String inventoryOutOperator;

    /**
     * 出库单金额
     */
    private BigDecimal inventoryOutMoney;

    /**
     * 出库单备注
     */
    private String inventoryOutRemarks;
}
