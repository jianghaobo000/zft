package cdu.jhb.account.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 账户DTO
* @author jhb
* @date 2023/2/19 13:07
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

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
}
