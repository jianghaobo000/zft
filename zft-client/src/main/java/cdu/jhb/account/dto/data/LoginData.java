package cdu.jhb.account.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 登录请求参数
* @author jhb
* @date 2023/04/25 14:32
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    /**
     * 账号
     */
    private String accountName;

    /**
     * 密码
     */
    private String accountPassword;

    /**
     * 国家码
     */
    private String countryCode;

    /**
     * 验证码
     */
    private String code;
}
