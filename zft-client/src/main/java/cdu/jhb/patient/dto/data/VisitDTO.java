package cdu.jhb.patient.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 就诊DTO
* @author jhb
* @date 2023/2/20 22:04
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDTO {
    /**
     * 就诊ID
     */
    private Long visit_id;

    /**
     * 就诊患者ID
     */
    private Long visit_patient_id;

    /**
     * 就诊患者姓名
     */
    private String visit_patient_name;

    /**
     * 就诊时间
     */
    private String visit_time;

    /**
     * 就诊症状
     */
    private String visit_symptom;

    /**
     * 就诊医生ID
     */
    private Long visit_doctor_id;

    /**
     * 就诊医生名称
     */
    private String visit_doctor_name;

    /**
     * 就诊所属诊所
     */
    private Long visit_tenant_id;
}
