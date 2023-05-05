package cdu.jhb.prescription.command;

import cdu.jhb.common.Constant;
import cdu.jhb.domain.patient.Patient;
import cdu.jhb.domain.prescription.Advice;
import cdu.jhb.domain.prescription.Prescription;
import cdu.jhb.domain.prescription.gateway.PrescriptionGateway;
import cdu.jhb.prescription.data.request.SaveVisitInfoRequest;
import cdu.jhb.util.Convert;
import cdu.jhb.util.DateUtil;
import cdu.jhb.util.RedisUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:06
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class PrescriptionModExe {

    private PrescriptionGateway prescriptionGateway;

    /**
     * 完成接诊
     * @param request
     * @return
     */
    public Boolean saveVisit(SaveVisitInfoRequest request) {
        Patient patient = Convert.entityConvert(request.getPatientDTO(),Patient.class);
        Advice advice = Convert.entityConvert(request.getAdviceDTO(),Advice.class);
        Prescription prescription = Convert.entityConvert(request.getAdviceDTO(),Prescription.class);

        // 设置租户ID
        Long tenantId = RedisUtil.getLocalTenantId();
        patient.setPatientTenantId(tenantId);
        advice.setAdviceTenantId(tenantId);
        prescription.setPrescriptionTenantId(tenantId);

        // 设置操作人与时间
        String time = DateUtil.DateToString(Constant.YMDHMS,new Date());

        advice.setAdviceTime(time);
        advice.setAdviceDoctorName(RedisUtil.getString(Constant.EMPLOYEE_NAME));
        advice.setAdviceDoctorId(RedisUtil.getLong(Constant.EMPLOYEE_ID));

        prescription.setPrescriptionTime(time);
        prescription.setPrescriptionDoctorName(RedisUtil.getString(Constant.EMPLOYEE_NAME));
        prescription.setPrescriptionDoctorId(RedisUtil.getLong(Constant.EMPLOYEE_ID));

        return prescriptionGateway.saveVisit(patient,advice,prescription);
    }
}
