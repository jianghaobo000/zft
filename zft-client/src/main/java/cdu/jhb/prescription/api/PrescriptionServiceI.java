package cdu.jhb.prescription.api;

import cdu.jhb.prescription.data.request.SaveVisitInfoRequest;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:02
* @version 1.0
*/
public interface PrescriptionServiceI {

    /**
     * 保存就诊信息
     * @param request
     * @return
     */
    Boolean saveVisit(SaveVisitInfoRequest request);
}
