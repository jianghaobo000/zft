package cdu.jhb.patient.api;

import cdu.jhb.patient.data.response.VisitListResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:01
* @version 1.0
*/
public interface PatientServiceI {

    /**
     * 获取所选时间就诊列表
     * @param date
     * @return
     */
    List<VisitListResponse> getVisitList(String date);

    /**
     * 获取该患者历史就诊信息
     * @param pid
     * @return
     */
    List<VisitListResponse> getPatientVisitHistory(Long pid);
}
