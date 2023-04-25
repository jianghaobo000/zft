package cdu.jhb.inventory.dto.data;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 入库单明细DTO
* @author jhb
* @date 2023/2/20 22:16
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInDetailDTO {
    /**
     * 入库单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryInDetailId;

    /**
     * 入库单主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryInId;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryInCommodityId;

    /**
     * 商品名称
     */
    private String inventoryInCommodityName;

    /**
     * 商品国家码
     */
    private String inventoryInCountryCode;

    /**
     * 商品规格
     */
    private String inventoryInCommoditySpecification;

    /**
     * 商品是否拆零销售
     */
    private Integer inventoryInSplitSaleStatus;

    /**
     * 商品进价(大)
     */
    private BigDecimal inventoryInCommodityLargeBidPrice;

    /**
     * 商品进价(小)
     */
    private BigDecimal inventoryInCommoditySmallBidPrice;

    /**
     * 商品售价(大)
     */
    private BigDecimal inventoryInCommodityLargeSalePrice;

    /**
     * 商品售价(小)
     */
    private BigDecimal inventoryInCommoditySmallSalePrice;

    /**
     * 商品库存单位（大）
     */
    private String inventoryInLargeUnit;

    /**
     * 商品库存单位（小）
     */
    private String inventoryInSmallUnit;

    /**
     * 商品入库前数量（大）
     */
    private Integer inventoryInBeforeLargeNum;

    /**
     * 商品入库前数量（小）
     */
    private Integer inventoryInBeforeSmallNum;

    /**
     * 商品入库后数量（大）
     */
    private Integer inventoryInAfterLargeNum;

    /**
     * 商品入库后数量（小）
     */
    private Integer inventoryInAfterSmallNum;

    /**
     * 商品入库数量（大）
     */
    private Integer inventoryInLargeNum;

    /**
     * 商品入库数量（小）
     */
    private Integer inventoryInSmallNum;
}
