package cdu.jhb.inventory.database.dataobject;

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
public class InventoryCheckInfoDO {
    /**
     * 盘点单ID
     */
    private Long inventory_check_id;

    /**
     * 盘点单状态
     */
    private String inventory_check_status;

    /**
     * 盘点单盈亏数量
     */
    private String inventory_in_supplier_name;

    /**
     * 盘点时间
     */
    private String inventory_in_time;

    /**
     * 盘点单创建时间
     */
    private String inventory_in_create_time;

    /**
     * 盘点单盈亏金额-进价
     */
    private BigDecimal inventory_check_bid_money;

    /**
     * 盘点单盈亏金额-售价
     */
    private BigDecimal inventory_check_sale_money;

    /**
     * 盘点人
     */
    private String inventory_in_operator;

    /**
     * 盘点品种数
     */
    private Integer inventory_check_variety;

    /**
     * 盘点单备注
     */
    private String inventory_remarks;

}
