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
@TableName("inventory_out_detail_table")
public class InventoryOutDetailDO {
    /**
     * 出库单明细ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventoryOutDetailId;

    /**
     * 出库单主表ID
     */
    private Long inventoryOutId;

    /**
     * 商品ID
     */
    private Long inventoryOutCommodityId;

    /**
     * 商品名称
     */
    private String inventoryOutCommodityName;

    /**
     * 商品国家码
     */
    private String inventoryOutCountryCode;

    /**
     * 商品规格
     */
    private String inventoryOutCommoditySpecification;

    /**
     * 商品是否拆零销售
     */
    private Integer inventoryOutSplitSaleStatus;

    /**
     * 商品售价(大)
     */
    private BigDecimal inventoryOutCommodityLargeSalePrice;

    /**
     * 商品售价(小)
     */
    private BigDecimal inventoryOutCommoditySmallSalePrice;

    /**
     * 商品库存单位（大）
     */
    private String inventoryOutLargeUnit;

    /**
     * 商品库存单位（小）
     */
    private String inventoryOutSmallUnit;

    /**
     * 商品出库前数量（大）
     */
    private Integer inventoryOutBeforeLargeNum;

    /**
     * 商品出库前数量（小）
     */
    private Integer inventoryOutBeforeSmallNum;

    /**
     * 商品出库后数量（大）
     */
    private Integer inventoryOutAfterLargeNum;

    /**
     * 商品出库后数量（小）
     */
    private Integer inventoryOutAfterSmallNum;

    /**
     * 商品出库数量（大）
     */
    private Integer inventoryOutLargeNum;

    /**
     * 商品出库数量（小）
     */
    private Integer inventoryOutSmallNum;
}
