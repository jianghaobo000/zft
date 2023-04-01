package cdu.jhb.account.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:08
* @version 1.0
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("account_table")
public class AccountDO {
    /**
     * 账户ID
     */
    @TableId(type = IdType.ID_WORKER)
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
