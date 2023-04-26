package cdu.jhb.inventory.database.dataobject;

import com.alibaba.fastjson.annotation.JSONField;
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
* @date 2023/04/01 21:22
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_in_table")
public class InventoryInDO {
    /**
     * 入库单ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventoryInId;

    /**
     * 入库单状态
     */
    private String inventoryInStatus;

    /**
     * 入库单供应商ID
     */
    private Long inventoryInSupplierId;

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
    private Long inventoryInOperatorId;

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

    /**
     * 入库单所属诊所
     */
    private Long inventoryInTenantId;
}
