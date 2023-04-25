package cdu.jhb.account.dto.data;

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
     * 账户所属租户
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long accountTenantId;
}
