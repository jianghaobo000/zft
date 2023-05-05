package cdu.jhb.domain.prescription.gateway;

import cdu.jhb.domain.patient.Patient;
import cdu.jhb.domain.prescription.Advice;
import cdu.jhb.domain.prescription.Prescription;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:07
* @version 1.0
*/
public interface PrescriptionGateway {

    /**
     * 完成接诊
     * @param patient
     * @param advice
     * @param prescription
     * @return
     */
    Boolean saveVisit(Patient patient, Advice advice, Prescription prescription);
}
