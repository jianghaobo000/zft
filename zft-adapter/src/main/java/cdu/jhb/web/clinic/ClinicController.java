package cdu.jhb.web.clinic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        // todo
        return null;

    }
}
