package cdu.jhb.domain.account;

import cdu.jhb.common.Constant;
import cdu.jhb.common.DictException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * 账号权限（1、管理员 2、医生 3、药师 4、库管员）
     */
    private Integer accountRole;

    /**
     * 账户所属租户
     */
    private Long accountTenantId;

    /**
     * 业务判断
     */
    public boolean isOk(String password) {
        Jedis jedis = new Jedis();
        if(!this.getAccountPassword().equals(password)){
            throw new RuntimeException(DictException.ACCOUNT_PASSWORD_ERROR);
        }
        jedis.set(Constant.ACCOUNT_NAME,this.accountName);
        jedis.set(Constant.TENANT_ID,this.accountTenantId.toString());
        return true;
    }

    public static boolean isCode(String code){
        Jedis jedis = new Jedis();
        if(!jedis.get(Constant.VALID_CODE).equals(code)){
            throw new RuntimeException(DictException.VALID_CODE_ERROR);
        }
        return true;
    }

}
