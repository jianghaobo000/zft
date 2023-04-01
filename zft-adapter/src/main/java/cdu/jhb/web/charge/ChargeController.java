package cdu.jhb.web.charge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 收费发药Controller
* @author jhb
* @date 2023/3/10 13:36
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("charge")
public class ChargeController {
    /**
     * 跳转收费发药界面
     * @return
     */
    @GetMapping("toCharge")
    public String toCharge(){
        return "charge/charge";
    }
}
