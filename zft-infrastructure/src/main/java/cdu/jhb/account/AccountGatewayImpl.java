package cdu.jhb.account;

import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.dataobject.AccountDO;
import cdu.jhb.account.dto.data.AccountDTO;
import cdu.jhb.domain.account.gateway.AccountGateway;
import cdu.jhb.tenant.database.TenantMapper;
import cdu.jhb.tenant.database.dataobject.TenantDO;
import cdu.jhb.tenant.dto.data.TenantDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
    public AccountDTO findAccountByName(String name,String countryCode) {
        AccountDO accountDO = accountMapper.selectAccount(name,countryCode);
        return DozerBeanMapperBuilder.buildDefault().map(accountDO,AccountDTO.class);
    }

    /**
     * 查询国家码是否存在
     * @param countryCode
     * @return
     * @throws Exception
     */
    @Override
    public Boolean findCountryCode(String countryCode) throws Exception {
        QueryWrapper<TenantDO> queryWrapper = new QueryWrapper<TenantDO>()
                .eq("tenant_country_code",countryCode);
        TenantDO tenantDO = tenantMapper.selectOne(queryWrapper);
        if(tenantDO==null){
            throw new Exception("当前国家码不存在！");
        }
        return true;
    }
}
