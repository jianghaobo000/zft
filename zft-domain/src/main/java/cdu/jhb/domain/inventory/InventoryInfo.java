package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:35
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInfo {
    /**
     * 商品ID
     */
    private Long commodityId;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品国家编码
     */
    private String commodityCountryCode;

    /**
     * 商品类别
     */
    private String commodityCategory;

    /**
     * 商品条码
     */
    private String commodityBarCode;

    /**
     * 商品生产厂家
     */
    private String commodityManufacturer;

    /**
     * 商品批准文号
     */
    private String commodityApprovalNo;

    /**
     * 商品规格
     */
    private String commoditySpecification;

    /**
     * 商品单位（大）
     */
    private String commodityLargeUnit;

    /**
     * 商品单位（小）
     */
    private String commoditySmallUnit;

    /**
     * 商品定价（大）
     */
    private BigDecimal commodityLargePrice;

    /**
     * 商品定价（小）
     */
    private BigDecimal commoditySmallPrice;

    /**
     * 商品大小转换比
     */
    private Integer commodityDosageForm;

    /**
     * 商品使用状态
     */
    private Integer commodityEnableStatus;

    /**
     * 商品库存数量（大）
     */
    private Integer inventoryLargeNum;

    /**
     * 商品库存数量（小）
     */
    private Integer inventorySmallNum;

    /**
     * 商品是否拆零销售
     */
    private Integer commoditySplitSaleStatus;
}
