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
    private Long inventory_in_id;

    /**
     * 入库单状态
     */
    private String inventory_in_status;

    /**
     * 入库单供应商ID
     */
    private Long inventory_in_supplier_id;

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
    private Long inventory_in_operator_id;

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

    /**
     * 入库单所属诊所
     */
    private Long inventory_in_tenant_id;
}
