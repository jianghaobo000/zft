package cdu.jhb.domain.prescription;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 医嘱实体
* @author jhb
* @date 2023/2/21 11:27
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advice {
    /**
     * 病历ID
     */
    private Long adviceId;

    /**
     * 病历单对应处方单ID
     */
    private Long advicePrescriptionId;

    /**
     * 患者ID
     */
    private Long advicePatientId;

    /**
     * 病历单开设医生ID
     */
    private Long adviceDoctorId;

    /**
     * 病历单开设医生名称
     */
    private String adviceDoctorName;

    /**
     * 时间
     */
    private String adviceTime;

    /**
     * 现病史
     */
    private String advicePresentHistory;

    /**
     * 既往史
     */
    private String advicePastHistory;

    /**
     * 遗传史
     */
    private String adviceGeneticHistory;

    /**
     * 婚育史
     */
    private String adviceMarryHistory;

    /**
     * 体温
     */
    private String adviceTemperature;

    /**
     * 血压（高压）
     */
    private Integer adviceHighPressure;

    /**
     * 血压（低压）
     */
    private Integer adviceLowPressure;

    /**
     * 心率
     */
    private Integer adviceHeartRate;

    /**
     * 描述症状
     */
    private String adviceDescription;

    /**
     * 诊断
     */
    private String adviceDiagnosis;

    /**
     * 治法
     */
    private String adviceTreatmentMethod;

    /**
     * 医嘱所属诊所
     */
    private Long adviceTenantId;
}
