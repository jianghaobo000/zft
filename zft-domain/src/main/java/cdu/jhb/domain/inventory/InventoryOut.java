package cdu.jhb.domain.inventory;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private Long inventoryOutId;

    /**
     * 出库单状态
     */
    private String inventoryOutStatus;

    /**
     * 出库时间
     */
    private String inventoryOutTime;

    /**
     * 出库单状态
     */
    private String inventoryOutCreateTime;

    /**
     * 出库单类型
     */
    private String inventoryOutCategory;

    /**
     * 出库人
     */
    private Long inventoryOutOperatorId;

    /**
     * 出库品种数
     */
    private Integer inventoryOutVariety;

    /**
     * 出库单备注
     */
    private String inventoryOutRemarks;

    /**
     * 出库单金额
     */
    private BigDecimal inventoryOutMoney;

    /**
     * 出库单所属诊所
     */
    private Long inventoryOutTenantId;
}
