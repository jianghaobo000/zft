package cdu.jhb.prescription.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long prescriptionCommodityId;

    /**
     * 处方药品用法
     */
    private String prescriptionDosage;

    /**
     * 处方药品总量（大单位）
     */
    private Integer prescriptionTotalLarge;

    /**
     * 处方药品总量（小单位）
     */
    private Integer prescriptionTotalSmall;
}
