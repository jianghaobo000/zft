package cdu.jhb.account.command.query;

import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.dto.data.AccountDTO;
import cdu.jhb.domain.account.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:05
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class AccountQryExe {

    @Resource
    private AccountGateway accountGateway;

    public AccountDTO findAccountByName(String name,String countryCode) {
        return accountGateway.findAccountByName(name,countryCode);
    }

    public Boolean findCountryCode(String countryCode) throws Exception {
        return accountGateway.findCountryCode(countryCode);
    }
}
