package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 商品品项信息
* @author jhb
* @date 2023/04/01 16:35
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryInfoDTO {
    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
     * 商品使用状态
     */
    private Integer commodity_enable_status;

    /**
     * 商品库存数量（大）
     */
    private Integer inventory_large_num;

    /**
     * 商品库存数量（小）
     */
    private Integer inventory_small_num;

    /**
     * 商品是否拆零销售
     */
    private Integer commodity_split_sale_status;
}
