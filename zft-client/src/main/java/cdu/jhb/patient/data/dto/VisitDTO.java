package cdu.jhb.patient.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long visitId;

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
}
