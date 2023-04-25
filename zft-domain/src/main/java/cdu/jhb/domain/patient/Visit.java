package cdu.jhb.domain.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 就诊实体
* @author jhb
* @date 2023/2/21 11:26
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
    /**
     * 就诊ID
     */
    private Long visitId;

    /**
     * 就诊患者ID
     */
    private Long visitPatientId;

    /**
     * 就诊患者姓名
     */
    private String visitPatientName;

    /**
     * 就诊时间
     */
    private String visitTime;

    /**
     * 就诊症状
     */
    private String visitSymptom;

    /**
     * 就诊医生ID
     */
    private Long visitDoctorId;

    /**
     * 就诊医生名称
     */
    private String visitDoctorName;

    /**
     * 就诊所属诊所
     */
    private Long visitTenantId;
}
