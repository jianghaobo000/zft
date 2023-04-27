package cdu.jhb.domain.account;

import cdu.jhb.common.Constant;
import cdu.jhb.common.DictException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;

/**
* @description: TODO
* @author jhb
* @date 2023/2/21 10:55
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    /**
     * 账户ID
     */
    private Long accountId;
    /**
     * 账户名
     */
    private String accountName;
    /**
     * 账户密码
     */
    private String accountPassword;
    /**
     * 账户所属租户
     */
    private Long accountTenantId;

    /**
     * 业务判断
     */
    public boolean isOk(String password, String code) {
        Jedis jedis = new Jedis();
        if(this.getAccountPassword().equals(password)){
            if(!jedis.get(Constant.VALID_CODE).equals(code)){
                throw new RuntimeException(DictException.VALID_CODE_ERROR);
            }
        }else{
            throw new RuntimeException(DictException.ACCOUNT_PASSWORD_ERROR);
        }
        jedis.set(Constant.ACCOUNT_NAME,this.accountName);
        jedis.set(Constant.TENANT_ID,this.accountTenantId.toString());
        return true;
    }

}
