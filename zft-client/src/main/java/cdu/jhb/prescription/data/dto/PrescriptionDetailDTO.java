package cdu.jhb.prescription.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 处方明细DTO
* @author jhb
* @date 2023/2/20 21:41
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDetailDTO {
    /**
     * 处方明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long prescriptionDetailId;

    /**
     * 处方主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long prescriptionId;

    /**
     * 处方药品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long prescriptionDetailCommodityId;

    /**
     * 处方药品名称
     */
    private String prescriptionDetailCommodityName;

    /**
     * 处方药品用法
     */
    private String prescriptionDetailDosage;

    /**
     * 处方药品是否拆零销售
     */
    private Integer prescriptionDetailSplitSaleStatus;

    /**
     * 处方药品大小单位转换比
     */
    private Integer prescriptionDetailDosageForm;

    /**
     * 处方明细药品大单位价格
     */
    private BigDecimal prescriptionDetailLargePrice;

    /**
     * 处方明细药品小单位价格
     */
    private BigDecimal prescriptionDetailSmallPrice;

    /**
     * 处方药品（大单位）
     */
    private Integer prescriptionDetailLargeNum;

    /**
     * 处方药品（小单位）
     */
    private Integer prescriptionDetailSmallNum;

    /**
     * 处方药品大单位
     */
    private String prescriptionDetailLargeUnit;

    /**
     * 处方药品小单位
     */
    private String prescriptionDetailSmallUnit;
}
