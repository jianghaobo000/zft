package cdu.jhb.patient.command;

import cdu.jhb.domain.patient.Patient;
import cdu.jhb.domain.patient.Visit;
import cdu.jhb.domain.patient.gateway.PatientGateway;
import cdu.jhb.patient.data.response.VisitListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:05
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class PatientQryExe {

    private final PatientGateway patientGateway;

    /**
     * 根据所选时间获取就诊列表
     * @return
     */
    public List<VisitListResponse> getVisitList(String beginTime,String endTime){
        return patientGateway.getVisitList(beginTime,endTime);
    }

    /**
     * 获取该患者历史就诊信息
     * @param pid
     * @return
     */
    public List<VisitListResponse> getPatientVisitHistory(Long pid) {
        return patientGateway.getPatientVisitHistory(pid);
    }
}
