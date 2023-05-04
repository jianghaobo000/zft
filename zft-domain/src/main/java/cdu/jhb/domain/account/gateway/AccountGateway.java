package cdu.jhb.domain.account.gateway;

import cdu.jhb.domain.account.Account;

import javax.servlet.http.HttpServletRequest;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:07
* @version 1.0
*/
public interface AccountGateway {
    Account findAccountByName(String name, String countryCode, HttpServletRequest request);

    Boolean findCountryCode(String countryCode);
}
