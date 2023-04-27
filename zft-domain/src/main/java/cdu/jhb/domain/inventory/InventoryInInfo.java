package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 入库单信息实体
* @author jhb
* @date 2023/04/07 22:17
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInInfo {
    /**
     * 入库单ID
     */
    private String inventoryInId;

    /**
     * 入库单状态
     */
    private String inventoryInStatus;

    /**
     * 入库单供应商
     */
    private String inventoryInSupplierName;

    /**
     * 入库时间
     */
    private String inventoryInTime;

    /**
     * 入库单创建时间
     */
    private String inventoryInCreateTime;

    /**
     * 入库人
     */
    private String inventoryInOperator;

    /**
     * 入库品种数
     */
    private Integer inventoryInVariety;

    /**
     * 入库单备注
     */
    private String inventoryInRemarks;

    /**
     * 入库单金额
     */
    private BigDecimal inventoryInMoney;
}
