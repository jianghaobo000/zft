package cdu.jhb.domain.prescription;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
* @description: 处方实体
* @author jhb
* @date 2023/2/21 11:28
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    /**
     * 处方ID
     */
    private Long prescriptionId;

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
    private Long prescriptionDoctorId;

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

    /**
     * 处方明细集合
     */
    private List<PrescriptionDetail> prescriptionDetailList;
}
