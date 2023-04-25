package cdu.jhb.domain.prescription;

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
     * 医嘱ID
     */
    private Long adviceId;

    /**
     * 患者ID
     */
    private Long advicePatientId;

    /**
     * 时间
     */
    private String adviceTime;

    /**
     * 既往史
     */
    private String advicePastHistory;

    /**
     * 遗传史
     */
    private String adviceGeneticHistory;

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
     * 婚姻状态
     */
    private String adviceMaritalStatus;

    /**
     * 育子状态
     */
    private String adviceFertileStatus;

    /**
     * 望闻问切
     */
    private String adviceLookHearAsk;

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
