package cdu.jhb.web.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 患者Controller
* @author jhb
* @date 2023/3/10 13:46
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("patient")
public class PatientController {

    /**
     * 跳转患者数据界面
     * @return
     */
    @GetMapping("toPatientInfo")
    public String toPatientInfo(){
        return "patient/patientInfo";
    }

    /**
     * 跳转电子病历界面
     * @return
     */
    @GetMapping("toCaseHistory")
    public String toPatientCaseHistory(){
        return "patient/patientCaseHistory";
    }

    /**
     * 跳转上门就诊界面
     * @return
     */
    @GetMapping("toVisitHome")
    public String toPatientVisitHome(){
        return "patient/patientVisitHome";
    }

    /**
     * 跳转病情分析界面
     * @return
     */
    @GetMapping("toDiseaseAnalysis")
    public String toPatientDiseaseAnalysis(){
        return "patient/patientDiseaseAnalysis";
    }
}
