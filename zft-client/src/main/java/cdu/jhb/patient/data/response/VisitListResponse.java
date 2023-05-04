package cdu.jhb.patient.data.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:13
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitListResponse {
    /**
     * 就诊ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long visitId;

    /**
     * 就诊记录所属病历单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long visitAdviceId;

    /**
     * 就诊患者ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long visitDoctorId;

    /**
     * 就诊医生名称
     */
    private String visitDoctorName;

    /**
     * 就诊所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long visitTenantId;

    /**
     * 患者ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者性别
     */
    private String patientSex;

    /**
     * 患者生日
     */
    private String patientBirthday;

    /**
     * 患者身份证号
     */
    private Integer patientIdNumber;

    /**
     * 患者所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long patientTenantId;
}
