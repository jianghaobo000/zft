package cdu.jhb.commodity.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description: 商品DTO
 * @author jhb
 * @date 2023/2/20 22:07
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommodityDTO {
    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long commodityId;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品拼音
     */
    private String commodityPinyin;

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
     * 商品剂型
     */
    private String commodityFormDrug;

    /**
     * 商品剂量
     */
    private String commodityDosage;

    /**
     * 商品剂量单位
     */
    private String commodityDosageUnit;

    /**
     * 商品服用方式
     */
    private String commodityTake;

    /**
     * 商品服用频率
     */
    private String commodityUsageFrequency;

    /**
     * 商品单词服用剂量
     */
    private String commoditySingleDose;

    /**
     * 商品是否拆零销售
     */
    private Integer commoditySplitSaleStatus;

    /**
     * 商品使用状态
     */
    private Integer commodityEnableStatus;

    /**
     * 商品所属诊所
     */
    private Long commodityTenantId;
}
