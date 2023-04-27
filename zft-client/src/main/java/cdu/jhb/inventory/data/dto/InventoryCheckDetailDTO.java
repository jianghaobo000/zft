package cdu.jhb.inventory.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description: 盘点单明细DTO
 * @author jhb
 * @date 2023/2/20 22:26
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheckDetailDTO {
    /**
     * 盘点单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckDetailId;

    /**
     * 盘点单主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckId;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckCommodityId;

    /**
     * 商品名称
     */
    private String inventoryCheckCommodityName;

    /**
     * 商品国家码
     */
    private String inventoryCheckCountryCode;

    /**
     * 商品规格
     */
    private String inventoryCheckCommoditySpecification;

    /**
     * 商品是否拆零销售
     */
    private Integer inventoryCheckSplitSaleStatus;

    /**
     * 商品库存单位（大）
     */
    private String inventoryCheckLargeUnit;

    /**
     * 商品库存单位（小）
     */
    private String inventoryCheckSmallUnit;

    /**
     * 商品大小单位转换比
     */
    private Integer inventoryCheckDosageForm;

    /**
     * 商品盘点前数量（大）
     */
    private Integer inventoryCheckBeforeLargeNum;

    /**
     * 商品盘点前数量（小）
     */
    private Integer inventoryCheckBeforeSmallNum;

    /**
     * 商品盘点后数量（大）
     */
    private Integer inventoryCheckAfterLargeNum;

    /**
     * 商品盘点后数量（小）
     */
    private Integer inventoryCheckAfterSmallNum;

    /**
     * 商品盘点状态（盘盈、盘平、盘亏）
     */
    private String inventoryCheckStatus;

    /**
     * 商品盘点数量（大）
     */
    private Integer inventoryCheckLargeNum;

    /**
     * 商品盘点数量（小）
     */
    private Integer inventoryCheckSmallNum;
}
