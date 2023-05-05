package cdu.jhb.web.clinic;

import cdu.jhb.patient.data.response.VisitInfoResponse;
import cdu.jhb.prescription.api.PrescriptionServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @description: 门诊Controller
* @author jhb
* @date 2023/3/2 15:11
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("clinic")
public class ClinicController {

    private final PrescriptionServiceI prescriptionServiceI;

    /**
     * 跳转门诊界面
     * @return
     */
    @GetMapping("toClinic")
    public String toClinic(){
        return "clinic/clinic";
    }

    /**
     * 获取门诊模块的就诊信息
     * @return
     */
    public ResponseEntity<?> getClinicInfo(@RequestParam("aid")Long aid){
        VisitInfoResponse visitInfoResponse = prescriptionServiceI.getClinicInfo(aid);
        return ResponseEntity.ok(visitInfoResponse);

    }
}
