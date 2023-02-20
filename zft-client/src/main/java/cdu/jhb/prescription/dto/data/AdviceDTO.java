package cdu.jhb.prescription.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 医嘱DTO
* @author jhb
* @date 2023/2/20 21:44
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviceDTO {
    /**
     * 医嘱ID
     */
    private Long advice_id;

    /**
     * 患者ID
     */
    private Long advice_patient_id;

    /**
     * 时间
     */
    private String advice_time;

    /**
     * 既往史
     */
    private String advice_past_history;

    /**
     * 遗传史
     */
    private String advice_genetic_history;

    /**
     * 体温
     */
    private String advice_temperature;

    /**
     * 血压（高压）
     */
    private Integer advice_high_pressure;

    /**
     * 血压（低压）
     */
    private Integer advice_low_pressure;

    /**
     * 心率
     */
    private Integer advice_heart_rate;

    /**
     * 描述症状
     */
    private String advice_description;

    /**
     * 婚姻状态
     */
    private String advice_marital_status;

    /**
     * 育子状态
     */
    private String advice_fertile_status;

    /**
     * 望闻问切
     */
    private String advice_look_hear_ask;

    /**
     * 诊断
     */
    private String advice_diagnosis;

    /**
     * 治法
     */
    private String advice_treatment_method;

    /**
     * 医嘱所属诊所
     */
    private Long advice_tenant_id;
}
