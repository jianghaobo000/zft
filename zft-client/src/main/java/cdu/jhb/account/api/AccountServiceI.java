package cdu.jhb.account.api;

import cdu.jhb.account.data.dto.AccountDTO;
import cdu.jhb.account.data.dto.EmployeeDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* @description: 账户服务层
* @author jhb
* @date 2023/3/1 13:15
* @version 1.0
*/
public interface AccountServiceI {

    void getMsg(HttpServletResponse response);

    Boolean verification(String name, String password, String code, String countryCode, HttpServletRequest request);

    List<AccountDTO> getAccountList();

    List<EmployeeDTO> getEmployeeList();

    List<EmployeeDTO> getInventoryEmployeeList();

    List<EmployeeDTO> getNoDepartEmployeeList();

}
