package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:24
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_check_table")
public class InventoryCheckDO {
    /**
     * 盘点单ID
     */
    @TableId(type = IdType.ID_WORKER)
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
