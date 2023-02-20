package cdu.jhb.prescription.dto.data;

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
    private Long prescription_detail_id;

    /**
     * 处方主表ID
     */
    private Long prescription_id;

    /**
     * 处方药品ID
     */
    private Long prescription_commodity_id;

    /**
     * 处方药品用法
     */
    private String prescription_dosage;

    /**
     * 处方药品总量（大单位）
     */
    private Integer prescription_total_large;

    /**
     * 处方药品总量（小单位）
     */
    private Integer prescription_total_small;
}
