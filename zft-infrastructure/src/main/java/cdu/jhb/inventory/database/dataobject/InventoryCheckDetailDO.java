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
* @date 2023/04/01 21:24
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_check_detail_table")
public class InventoryCheckDetailDO {
    /**
     * 盘点单明细ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventory_check_detail_id;

    /**
     * 盘点单主表ID
     */
    private Long inventory_check_id;

    /**
     * 商品ID
     */
    private Long inventory_check_commodity_id;

    /**
     * 商品名称
     */
    private String inventory_check_commodity_name;

    /**
     * 商品国家码
     */
    private String inventory_check_country_code;

    /**
     * 商品规格
     */
    private String inventory_check_commodity_specification;

    /**
     * 商品是否拆零销售
     */
    private Integer inventory_check_split_sale_status;

    /**
     * 商品盈亏金额(进价)
     */
    private BigDecimal inventory_check_commodity_bid_money;

    /**
     * 商品盈亏金额(售价)
     */
    private BigDecimal inventory_check_commodity_sale_money;

    /**
     * 商品库存单位（大）
     */
    private String inventory_check_large_unit;

    /**
     * 商品库存单位（小）
     */
    private String inventory_check_small_unit;

    /**
     * 商品盘点前数量（大）
     */
    private Integer inventory_check_before_large_num;

    /**
     * 商品盘点前数量（小）
     */
    private Integer inventory_check_before_small_num;

    /**
     * 商品盘点后数量（大）
     */
    private Integer inventory_check_after_large_num;

    /**
     * 商品盘点后数量（小）
     */
    private Integer inventory_check_after_small_num;

    /**
     * 商品盘点数量（大）
     */
    private Integer inventory_check_large_num;

    /**
     * 商品盘点数量（小）
     */
    private Integer inventory_check_small_num;
}
