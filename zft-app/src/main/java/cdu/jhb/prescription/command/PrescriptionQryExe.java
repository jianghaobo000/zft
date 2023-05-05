package cdu.jhb.prescription.command;

import cdu.jhb.domain.prescription.gateway.PrescriptionGateway;
import cdu.jhb.patient.data.response.VisitInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:06
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class PrescriptionQryExe {

    private final PrescriptionGateway prescriptionGateway;

    /**
     * 通过病历ID获取门诊信息
     * @param aid
     * @return
     */
    public VisitInfoResponse getClinicInfo(Long aid) {
        return prescriptionGateway.getClinicInfo(aid);
    }
}
