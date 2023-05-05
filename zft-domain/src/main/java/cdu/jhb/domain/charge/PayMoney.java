package cdu.jhb.domain.charge;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 支付金额实体
* @author jhb
* @date 2023/05/05 14:24
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMoney {

    /**
     * 支付金额ID
     */
    private Long payMoneyId;

    /**
     * 支付金额所属收费单
     */
    private Long payMoneyChargeId;

    /**
     * 支付金额类型
     */
    private String payMoneyCategory;

    /**
     * 支付金额
     */
    private BigDecimal payMoneyNum;

    /**
     * 支付金额所属租户
     */
    private Long payMoneyTenantId;
}
