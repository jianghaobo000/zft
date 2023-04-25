package cdu.jhb.prescription.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 处方DTO
* @author jhb
* @date 2023/2/20 21:36
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {
    /**
     * 处方ID
     */
    private long prescriptionId;

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
     * 处方所属诊所
     */
    private Long prescriptionTenantId;
}
