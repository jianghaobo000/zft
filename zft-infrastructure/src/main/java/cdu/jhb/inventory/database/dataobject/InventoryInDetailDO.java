package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("inventory_in_detail_table")
public class InventoryInDetailDO {
    /**
     * 入库单明细ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventory_in_detail_id;

    /**
     * 入库单主表ID
     */
    private Long inventory_in_id;

    /**
     * 商品ID
     */
    private Long inventory_in_commodity_id;

    /**
     * 商品名称
     */
    private String inventory_in_commodity_name;

    /**
     * 商品国家码
     */
    private String inventory_in_country_code;

    /**
     * 商品规格
     */
    private String inventory_in_commodity_specification;

    /**
     * 商品是否拆零销售
     */
    private Integer inventory_in_split_sale_status;

    /**
     * 商品进价(大)
     */
    private BigDecimal inventory_in_commodity_large_bid_price;

    /**
     * 商品进价(小)
     */
    private BigDecimal inventory_in_commodity_small_bid_price;

    /**
     * 商品售价(大)
     */
    private BigDecimal inventory_in_commodity_large_sale_price;

    /**
     * 商品售价(小)
     */
    private BigDecimal inventory_in_commodity_small_sale_price;

    /**
     * 商品库存单位（大）
     */
    private String inventory_in_large_unit;

    /**
     * 商品库存单位（小）
     */
    private String inventory_in_small_unit;

    /**
     * 商品入库前数量（大）
     */
    private Integer inventory_in_before_large_num;

    /**
     * 商品入库前数量（小）
     */
    private Integer inventory_in_before_small_num;

    /**
     * 商品入库后数量（大）
     */
    private Integer inventory_in_after_large_num;

    /**
     * 商品入库后数量（小）
     */
    private Integer inventory_in_after_small_num;

    /**
     * 商品入库数量（大）
     */
    private Integer inventory_in_large_num;

    /**
     * 商品入库数量（小）
     */
    private Integer inventory_in_small_num;
}
