package cdu.jhb.prescription.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("advice_table")
public class AdviceDO {
    /**
     * 病历ID
     */
    @TableId(type = IdType.ID_WORKER)
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
