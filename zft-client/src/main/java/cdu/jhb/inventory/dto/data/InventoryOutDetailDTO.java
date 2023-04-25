package cdu.jhb.inventory.dto.data;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 出库单明细DTO
* @author jhb
* @date 2023/2/20 22:22
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOutDetailDTO {
    /**
     * 出库单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryOutDetailId;

    /**
     * 出库单主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryOutId;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
