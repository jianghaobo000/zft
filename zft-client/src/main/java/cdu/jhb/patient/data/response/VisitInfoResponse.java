package cdu.jhb.patient.data.response;

import cdu.jhb.patient.data.dto.PatientDTO;
import cdu.jhb.prescription.data.dto.AdviceDTO;
import cdu.jhb.prescription.data.dto.PrescriptionDTO;
import cdu.jhb.prescription.data.dto.PrescriptionDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 就诊信息
* @author jhb
* @date 2023/05/05 16:04
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitInfoResponse {

    private PatientDTO patientDTO;

    private AdviceDTO adviceDTO;

    private PrescriptionDTO prescriptionDTO;
}
