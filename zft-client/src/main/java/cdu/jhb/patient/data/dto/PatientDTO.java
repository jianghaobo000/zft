package cdu.jhb.patient.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 患者DTO
* @author jhb
* @date 2023/2/20 21:23
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
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
