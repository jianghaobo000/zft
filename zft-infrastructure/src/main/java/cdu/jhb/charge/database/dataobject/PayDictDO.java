package cdu.jhb.charge.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:15
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pay_dict_table")
public class PayDictDO {
    /**
     * 支付方式ID
     */
    private Long pay_id;

    /**
     * 支付名称
     */
    private String pay_name;
}
