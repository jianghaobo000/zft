package cdu.jhb.web.account;

import cdu.jhb.account.api.AccountServiceI;
import cdu.jhb.account.dto.data.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
* @description: TODO
* @author jhb
* @date 2023/2/19 13:11
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("account")
public class AccountController {

    private final AccountServiceI accountService;


    /**
     * 获取验证码图片
     * @return
     */
    @GetMapping(path = "getImg")
    public void getImg(HttpServletResponse response, HttpServletRequest request){
        accountService.getMsg(response,request);
    }

    /**
     * 跳帧登录页面
     */
    @GetMapping(path = "login")
    public String loginBef(){
        return "login";
    }

    /**
     * 登录验证
     * @param account_name
     * @param account_password
     * @param req
     * @param model
     * @return
     */
    @PostMapping(path = "login")
    public String login(@Param("account_name") String account_name,@Param("account_password") String account_password,
                        @Param("code")String code,@Param("country_code")String country_code,
                        HttpServletRequest req,Model model) throws Exception {
        if(accountService.verification(account_name,account_password,code,country_code)){
            System.out.println("成功");
            return "clinic/clinic";
        }
        System.out.println("失败");
        return "login";
    }


    /**
     * 跳转注册界面
     * @return
     */
    @GetMapping(path = "register")
    public String registerBef(){
        return "";
    }

}
