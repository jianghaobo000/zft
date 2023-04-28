package cdu.jhb.account.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
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
     * 账号权限（1、老板 2、医生 3、药师 4、库管员）
     */
    private Integer accountRole;

    /**
     * 账户所属租户
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long accountTenantId;
}
