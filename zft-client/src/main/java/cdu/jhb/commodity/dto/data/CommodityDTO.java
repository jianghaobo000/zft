package cdu.jhb.commodity.dto.data;

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
    private Long commodity_id;

    /**
     * 商品名称
     */
    private String commodity_name;

    /**
     * 商品国家编码
     */
    private String commodity_country_code;

    /**
     * 商品类别
     */
    private String commodity_category;

    /**
     * 商品条码
     */
    private String commodity_bar_code;

    /**
     * 商品生产厂家
     */
    private String commodity_manufacturer;

    /**
     * 商品批准文号
     */
    private String commodity_approval_no;

    /**
     * 商品规格
     */
    private String commodity_specification;

    /**
     * 商品单位（大）
     */
    private String commodity_large_unit;

    /**
     * 商品单位（小）
     */
    private String commodity_small_unit;

    /**
     * 商品定价（大）
     */
    private BigDecimal commodity_large_price;

    /**
     * 商品定价（小）
     */
    private BigDecimal commodity_small_price;

    /**
     * 商品大小转换比
     */
    private Integer commodity_dosage_form;

    /**
     * 商品剂型
     */
    private String commodity_form_drug;

    /**
     * 商品剂量
     */
    private String commodity_dosage;

    /**
     * 商品剂量单位
     */
    private String commodity_dosage_unit;

    /**
     * 商品服用方式
     */
    private String commodity_take;

    /**
     * 商品服用频率
     */
    private String commodity_usage_frequency;

    /**
     * 商品是否拆零销售
     */
    private Integer commodity_split_sale_status;

    /**
     * 商品使用状态
     */
    private Integer commodity_enable_status;

    /**
     * 商品所属诊所
     */
    private Long commodity_tenant_id;
}
