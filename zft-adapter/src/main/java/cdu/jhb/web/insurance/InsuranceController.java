package cdu.jhb.web.insurance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 医保Controller
* @author jhb
* @date 2023/3/10 13:42
* @version 1.0
*/
@Controller
@RequestMapping("Insurance")
public class InsuranceController {

    /**
     * 跳转库存界面
     * @return
     */
    @GetMapping("toInsurance")
    public String toInsurance(){
        return "insurance/insurance";
    }

}
