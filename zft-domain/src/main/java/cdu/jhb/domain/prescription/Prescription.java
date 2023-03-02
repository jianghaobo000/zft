package cdu.jhb.domain.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 处方实体
* @author jhb
* @date 2023/2/21 11:28
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    /**
     * 处方ID
     */
    private long prescription_id;

    /**
     * 处方类别
     */
    private String prescription_category;

    /**
     * 处方医嘱
     */
    private String prescription_order;

    /**
     * 处方开设时间
     */
    private String prescription_time;

    /**
     * 处方开设医生ID
     */
    private Integer prescription_doctor_id;

    /**
     * 处方开设医生名字
     */
    private String prescription_doctor_name;

    /**
     * 处方所属患者ID
     */
    private Long prescription_patient_id;

    /**
     * 处方所属患者名字
     */
    private String prescription_patient_name;

    /**
     * 处方所属诊所
     */
    private Long prescription_tenant_id;
}
