package cdu.jhb.patient.service;

import cdu.jhb.common.Constant;
import cdu.jhb.patient.api.PatientServiceI;
import cdu.jhb.patient.command.PatientModExe;
import cdu.jhb.patient.command.PatientQryExe;
import cdu.jhb.patient.data.response.VisitListResponse;
import cdu.jhb.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:02
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientServiceI {

    private final PatientModExe patientModExe;

    private final PatientQryExe patientQryExe;

    /**
     * 根据所选时间获取就诊列表
     * @param date
     * @return
     */
    @Override
    public List<VisitListResponse> getVisitList(String date) {
        // 处理时间
        String beginTime = date + Constant.BEGIN_TIME;
        String endTime = date + Constant.END_TIME;
        return patientQryExe.getVisitList(beginTime,endTime);
    }

    /**
     * 获取该患者历史就诊信息
     * @param pid
     * @return
     */
    @Override
    public List<VisitListResponse> getPatientVisitHistory(Long pid) {
        return patientQryExe.getPatientVisitHistory(pid);
    }
}
