package cdu.jhb.charge.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.ID_WORKER)
    private Long payId;

    /**
     * 支付名称
     */
    private String payName;

    /**
     * 支付方式状态（0、未启用 1、启用）
     */
    private Integer payStatus;

    /**
     * 支付方式所属租户
     */
    private Long payTenantId;
}
