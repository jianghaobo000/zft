package cdu.jhb.domain.patient.gateway;

import cdu.jhb.patient.data.response.VisitListResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:07
* @version 1.0
*/
public interface PatientGateway {

    /**
     * 根据所选时间获取就诊记录
     * @param beginTime
     * @param endTime
     * @return
     */
    List<VisitListResponse> getVisitList(String beginTime, String endTime);

    /**
     * 获取该患者历史就诊信息
     * @param pid
     * @return
     */
    List<VisitListResponse> getPatientVisitHistory(Long pid);
}
