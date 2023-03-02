package cdu.jhb.domain.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 处方明细实体
* @author jhb
* @date 2023/2/21 11:28
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDetail {
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
