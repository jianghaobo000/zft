package cdu.jhb.patient.dto.data;

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
    private Long patient_id;

    /**
     * 患者姓名
     */
    private String patient_name;

    /**
     * 患者性别
     */
    private String patient_sex;

    /**
     * 患者生日
     */
    private String patient_birthday;

    /**
     * 患者医保号
     */
    private Integer patient_medical_number;

    /**
     * 患者医保余额
     */
    private Integer patient_medical_balance;

    /**
     * 患者身份证号
     */
    private Integer patient_id_number;

    /**
     * 患者所患疾病
     */
    private String patient_disease;

    /**
     * 患者所属科室ID
     */
    private Long patient_department_id;

    /**
     * 患者所属科室名字
     */
    private String patient_department_name;

    /**
     * 患者就诊时间
     */
    private String patient_time;

    /**
     * 患者所属诊所
     */
    private Long patient_tenant_id;
}
