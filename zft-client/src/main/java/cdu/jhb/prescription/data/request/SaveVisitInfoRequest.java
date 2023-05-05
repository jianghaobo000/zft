package cdu.jhb.prescription.data.request;

import cdu.jhb.patient.data.dto.PatientDTO;
import cdu.jhb.prescription.data.dto.AdviceDTO;
import cdu.jhb.prescription.data.dto.PrescriptionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 保存就诊请求实体
* @author jhb
* @date 2023/05/05 10:35
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveVisitInfoRequest {

    private PatientDTO patientDTO;

    private AdviceDTO adviceDTO;

    private PrescriptionDTO prescriptionDTO;
}
