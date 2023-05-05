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
* @date 2023/04/01 21:23
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_out_table")
public class InventoryOutDO {
    /**
     * 出库单ID
     */
    @TableId(type = IdType.ID_WORKER)
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
     * 出库单创建时间
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
