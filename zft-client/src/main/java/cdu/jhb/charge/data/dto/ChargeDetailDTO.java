package cdu.jhb.charge.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 收费单明细DTO
* @author jhb
* @date 2023/2/20 21:57
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeDetailDTO {
    /**
     * 收费单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargeDetailId;

    /**
     * 所属收费单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargeId;

    /**
     * 收费单商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargeDetailCommodityId;

    /**
     * 收费单商品名
     */
    private String chargeDetailCommodityName;

    /**
     * 收费单药品是否拆零销售
     */
    private Integer chargeDetailSplitSaleStatus;

    /**
     * 收费单药品大小单位转换比
     */
    private Integer chargeDetailDosageForm;

    /**
     * 收费单明细药品大单位价格
     */
    private BigDecimal chargeDetailLargePrice;

    /**
     * 收费单明细药品小单位价格
     */
    private BigDecimal chargeDetailSmallPrice;

    /**
     * 收费单药品数量（大单位）
     */
    private Integer chargeDetailLargeNum;

    /**
     * 收费单药品数量（小单位）
     */
    private Integer chargeDetailSmallNum;

    /**
     * 收费单药品大单位
     */
    private String chargeDetailLargeUnit;

    /**
     * 收费单药品小单位
     */
    private String chargeDetailSmallUnit;
}
