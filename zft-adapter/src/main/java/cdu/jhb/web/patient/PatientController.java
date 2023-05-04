package cdu.jhb.web.patient;

import cdu.jhb.patient.api.PatientServiceI;
import cdu.jhb.patient.data.response.VisitListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    private final PatientServiceI patientService;

    /**
     * 获取所选日期就诊列表
     * @param date
     * @return
     */
    @GetMapping("getVisitList")
    public ResponseEntity<?> getVisitList(@RequestParam("date")String date){
        List<VisitListResponse> visitListResponseList = patientService.getVisitList(date);
        return ResponseEntity.ok(visitListResponseList);
    }

    /**
     * 获取该患者历史就诊记录
     * @return
     */
    @GetMapping("getPatientVisitHistory")
    public ResponseEntity<?> getPatientVisitHistory(@RequestParam("patientId")Long patientId){
        List<VisitListResponse> visitListResponseList = patientService.getPatientVisitHistory(patientId);
        return ResponseEntity.ok(visitListResponseList);
    }

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
