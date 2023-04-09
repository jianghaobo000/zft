package cdu.jhb.account.api;

import cdu.jhb.account.dto.data.AccountDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.List;

/**
* @description: 账户服务层
* @author jhb
* @date 2023/3/1 13:15
* @version 1.0
*/
public interface AccountServiceI {

    void getMsg(HttpServletResponse response,HttpServletRequest request);

//    AccountDTO findAccountByName(String name,String countryCode);

    Boolean verification(String name,String password,String code,String countryCode) throws Exception;

    List<AccountDTO> getAccountList();

}
