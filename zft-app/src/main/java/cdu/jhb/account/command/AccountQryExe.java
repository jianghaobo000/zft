package cdu.jhb.account.command;

import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.dto.data.AccountDTO;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.gateway.AccountGateway;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:05
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class AccountQryExe {

    private final AccountGateway accountGateway;

    private final AccountMapper accountMapper;

    /**
     * 通过名字查询账号
     * @param name
     * @param countryCode
     * @return
     */
    public Boolean findAccountByName(String name,String password,String code,String countryCode) throws Exception {
        Account account = accountGateway.findAccountByName(name,countryCode);
        return account.isOk(password, code);
    }

    /**
     * 验证国家码是否存在
     * @param countryCode
     * @return
     * @throws Exception
     */
    public Boolean findCountryCode(String countryCode) throws Exception {
        return accountGateway.findCountryCode(countryCode);
    }

    /**
     * 获取账号列表
     * @return
     */
    public List<AccountDTO> getAccountList(){
        Jedis jedis = new Jedis();
        Long tenantId = Long.valueOf(jedis.get("tenantId"));
        return accountMapper.getAccountList(tenantId);
    }
}
