package cdu.jhb.web.clinic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 门诊Controller
* @author jhb
* @date 2023/3/2 15:11
* @version 1.0
*/
@Controller
@RequestMapping("clinic")
public class ClinicController {

    /**
     * 跳转门诊界面
     * @return
     */
    @GetMapping("toClinic")
    public String toClinic(){
        return "clinic/clinic";
    }
}
