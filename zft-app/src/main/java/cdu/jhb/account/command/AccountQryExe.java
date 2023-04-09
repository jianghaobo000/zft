package cdu.jhb.account.command;

import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.dto.data.AccountDTO;
import cdu.jhb.domain.account.gateway.AccountGateway;
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
    public AccountDTO findAccountByName(String name,String countryCode) {
        return accountGateway.findAccountByName(name,countryCode);
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
