package cdu.jhb.prescription.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 处方实体
* @author jhb
* @date 2023/2/21 11:28
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("prescription_table")
public class PrescriptionDO {
    /**
     * 处方ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long prescriptionId;

    /**
     * 处方所对应病历ID
     */
    private Long prescriptionAdviceId;

    /**
     * 处方类别
     */
    private String prescriptionCategory;

    /**
     * 处方医嘱
     */
    private String prescriptionOrder;

    /**
     * 处方开设时间
     */
    private String prescriptionTime;

    /**
     * 处方开设医生ID
     */
    private Integer prescriptionDoctorId;

    /**
     * 处方开设医生名字
     */
    private String prescriptionDoctorName;

    /**
     * 处方所属患者ID
     */
    private Long prescriptionPatientId;

    /**
     * 处方所属患者名字
     */
    private String prescriptionPatientName;

    /**
     * 处方单金额
     */
    private BigDecimal prescriptionMoney;

    /**
     * 处方所属诊所
     */
    private Long prescriptionTenantId;
}
