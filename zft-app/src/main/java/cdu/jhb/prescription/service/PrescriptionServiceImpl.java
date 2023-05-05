package cdu.jhb.prescription.service;

import cdu.jhb.prescription.api.PrescriptionServiceI;
import cdu.jhb.prescription.command.PrescriptionModExe;
import cdu.jhb.prescription.command.PrescriptionQryExe;
import cdu.jhb.prescription.data.request.SaveVisitInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:04
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionServiceI {

    private final PrescriptionModExe prescriptionModExe;

    private final PrescriptionQryExe prescriptionQryExe;

    /**
     * 保存就诊信息
     * @param request
     * @return
     */
    @Override
    public Boolean saveVisit(SaveVisitInfoRequest request) {
        return prescriptionModExe.saveVisit(request);
    }
}
