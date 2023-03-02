package cdu.jhb.domain.account.gateway;

import cdu.jhb.account.dto.data.AccountDTO;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:07
* @version 1.0
*/
public interface AccountGateway {
    AccountDTO findAccountByName(String name,String countryCode);

    Boolean findCountryCode(String countryCode) throws Exception;
}
