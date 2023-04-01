package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:23
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_out_detail_table")
public class InventoryOutDetailDO {
    /**
     * 出库单明细ID
     */
    private Long inventory_out_detail_id;

    /**
     * 出库单主表ID
     */
    private Long inventory_out_id;

    /**
     * 商品ID
     */
    private Long inventory_out_commodity_id;

    /**
     * 商品名称
     */
    private String inventory_out_commodity_name;

    /**
     * 商品库存单位（大）
     */
    private String inventory_out_large_unit;

    /**
     * 商品库存单位（小）
     */
    private String inventory_out_small_unit;

    /**
     * 商品出库前数量（大）
     */
    private Integer inventory_out_before_large_num;

    /**
     * 商品出库前数量（小）
     */
    private Integer inventory_out_before_small_num;

    /**
     * 商品出库后数量（大）
     */
    private Integer inventory_out_after_large_num;

    /**
     * 商品出库后数量（小）
     */
    private Integer inventory_out_after_small_num;

    /**
     * 商品出库数量（大）
     */
    private Integer inventory_out_large_num;

    /**
     * 商品出库数量（小）
     */
    private Integer inventory_out_small_num;
}
