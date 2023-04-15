package cdu.jhb.domain.account.gateway;

import cdu.jhb.account.dto.data.AccountDTO;
import cdu.jhb.domain.account.Account;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:07
* @version 1.0
*/
public interface AccountGateway {
    Account findAccountByName(String name, String countryCode);

    Boolean findCountryCode(String countryCode) throws Exception;
}
