package cdu.jhb.web.account;

import cdu.jhb.account.dto.data.AccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
* @description: TODO
* @author jhb
* @date 2023/2/19 13:11
* @version 1.0
*/
@Controller
@RequestMapping("account")
public class AccountController {


    @GetMapping(path = "login")
    public String loginBef(){
        return "login";
    }

    @PostMapping(path = "login")
    public Boolean login(){
        return true;
    }

}
