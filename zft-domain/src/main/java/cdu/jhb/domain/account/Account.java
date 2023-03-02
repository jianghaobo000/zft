package cdu.jhb.domain.account;

import cdu.jhb.account.dto.data.AccountDTO;
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
        if(this.account_id==null){
            throw new Exception("账号不存在！");
        }
        if(this.getAccount_password().equals(password)){
            Jedis jedis = new Jedis();
            if(!jedis.get("code").equals(code)){
                throw new Exception("验证码错误！");
            }
        }else{
            throw new Exception("密码错误！");
        }
        return true;
    }

}
