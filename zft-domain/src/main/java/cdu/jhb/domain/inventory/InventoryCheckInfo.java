package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author jhb
* @date 2023/04/12 20:12
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheckInfo {
    /**
     * 盘点单ID
     */
    private Long inventoryCheckId;

    /**
     * 盘点单状态
     */
    private String inventoryCheckStatus;

    /**
     * 盘点时间
     */
    private String inventoryCheckTime;

    /**
     * 盘点单创建时间
     */
    private String inventoryCheckCreateTime;

    /**
     * 盘点人
     */
    private String inventoryCheckOperator;

    /**
     * 盘点品种数
     */
    private Integer inventoryCheckVariety;

    /**
     * 盘点单备注
     */
    private String inventoryCheckRemarks;

}
