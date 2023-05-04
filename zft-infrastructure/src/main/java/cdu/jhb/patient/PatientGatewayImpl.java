package cdu.jhb.patient;

import cdu.jhb.domain.patient.gateway.PatientGateway;
import cdu.jhb.patient.data.response.VisitListResponse;
import cdu.jhb.patient.database.PatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:07
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class PatientGatewayImpl implements PatientGateway {

    private final PatientMapper patientMapper;

    /**
     * 根据所选时间获取就诊列表
     * @param beginTime
     * @param endTime
     * @return
     */
    @Override
    public List<VisitListResponse> getVisitList(String beginTime, String endTime) {
        return patientMapper.getVisitList(beginTime,endTime);
    }

    /**
     * 获取该患者历史就诊信息
     * @param pid
     * @return
     */
    @Override
    public List<VisitListResponse> getPatientVisitHistory(Long pid) {
        return patientMapper.getPatientVisitHistory(pid);
    }
}
