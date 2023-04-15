package cdu.jhb.domain.account;

import cdu.jhb.account.dto.data.AccountDTO;
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
    private Long account_id;
    /**
     * 账户名
     */
    private String account_name;
    /**
     * 账户密码
     */
    private String account_password;
    /**
     * 账户所属租户
     */
    private Long account_tenant_id;

    /**
     * 业务判断
     */
    public boolean isOk(String password, String code) throws Exception {
        Jedis jedis = new Jedis();
        if(this.account_id==null){
            throw new Exception(DictException.ACCOUNT_NOT_EXIST);
        }
        if(this.getAccount_password().equals(password)){
            if(!jedis.get(Constant.VALID_CODE).equals(code)){
                throw new Exception(DictException.VALID_CODE_ERROR);
            }
        }else{
            throw new Exception(DictException.ACCOUNT_PASSWORD_ERROR);
        }
        jedis.set(Constant.ACCOUNT_NAME,this.account_name);
        jedis.set(Constant.TENANT_ID,this.account_tenant_id.toString());
        return true;
    }

}
