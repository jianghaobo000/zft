package cdu.jhb.domain.inventory;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 盘点单实体
* @author jhb
* @date 2023/2/21 11:22
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheck {
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
    private Long inventoryCheckOperatorId;

    /**
     * 盘点品种数
     */
    private Integer inventoryCheckVariety;

    /**
     * 盘点单备注
     */
    private String inventoryCheckRemarks;

    /**
     * 盘点单所属诊所
     */
    private Long inventoryCheckTenantId;
}
