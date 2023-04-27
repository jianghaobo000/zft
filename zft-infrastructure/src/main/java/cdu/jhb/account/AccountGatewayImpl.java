package cdu.jhb.account;

import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.dataobject.AccountDO;
import cdu.jhb.common.Constant;
import cdu.jhb.common.DictException;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.gateway.AccountGateway;
import cdu.jhb.tenant.database.TenantMapper;
import cdu.jhb.tenant.database.dataobject.TenantDO;
import cdu.jhb.util.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:11
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class AccountGatewayImpl implements AccountGateway {

    private final AccountMapper accountMapper;
    private final TenantMapper tenantMapper;

    /**
     * 通过账号名查找账号
     * @param name
     * @return
     */
    @Override
    public Account findAccountByName(String name, String countryCode) {
        AccountDO accountDO = accountMapper.selectAccount(name,countryCode);
        if(accountDO == null){
            throw new RuntimeException(DictException.ACCOUNT_NOT_EXIST);
        }
        return Convert.entityConvert(accountDO,Account.class);
    }

    /**
     * 查询国家码是否存在
     * @param countryCode
     * @return
     */
    @Override
    public Boolean findCountryCode(String countryCode) {
        QueryWrapper<TenantDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TenantDO::getTenantCountryCode,countryCode);
        TenantDO tenantDO = tenantMapper.selectOne(queryWrapper);
        if(tenantDO==null){
            throw new RuntimeException(DictException.COUNTRY_CODE_NOT_EXIST);
        }
        return true;
    }
}
