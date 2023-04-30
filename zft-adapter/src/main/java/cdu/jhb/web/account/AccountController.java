package cdu.jhb.web.account;

import cdu.jhb.account.api.AccountServiceI;
import cdu.jhb.account.data.dto.AccountDTO;
import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.data.request.LoginData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public void getImg(HttpServletResponse response){
        accountService.getMsg(response);
    }

    /**
     * 进入首页
     * @return
     */
    @GetMapping(path = "login")
    public String loginBef(){
        return "login";
    }

    /**
     * 登录验证
     * loginDTO 登录请求参数
     * @return
     */
    @PostMapping(path = "login")
    public ResponseEntity<?> login(@RequestBody LoginData loginData) {
        if(accountService.verification(loginData.getAccountName(),loginData.getAccountPassword(),loginData.getCode(),loginData.getCountryCode())){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        // 状态码401
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 获取账号列表
     * @return
     */
    @GetMapping(path = "getAccountList")
    public ResponseEntity<?> getAccountList(){
        List<AccountDTO> accountDTOList = accountService.getAccountList();
        return ResponseEntity.ok(accountDTOList);
    }

    /**
     * 获取员工列表
     * @return
     */
    @GetMapping(path = "getEmployeeList")
    public ResponseEntity<?> getEmployeeList(){
        List<EmployeeDTO> employeeDTOList = accountService.getEmployeeList();
        return ResponseEntity.ok(employeeDTOList);
    }

    /**
     * 获取没有分配科室的员工列表
     * @return
     */
    @GetMapping(path = "getNoDepartEmployeeList")
    public ResponseEntity<?> getNoDepartEmployeeList(){
        List<EmployeeDTO> employeeDTOList = accountService.getNoDepartEmployeeList();
        return ResponseEntity.ok(employeeDTOList);
    }

}
