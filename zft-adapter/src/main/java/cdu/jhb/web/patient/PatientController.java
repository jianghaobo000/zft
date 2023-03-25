package cdu.jhb.web.patient;

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
@RequestMapping("patient")
public class PatientController {

    /**
     * 跳转患者界面
     * @return
     */
    @GetMapping("toPatient")
    public String toPatient(){
        return "patient/patient";
    }
}
