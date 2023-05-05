package cdu.jhb.charge.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author jhb
* @date 2023/2/20 21:53
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeDTO {
    /**
     * 收费单主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargeId;

    /**
     * 收费单所属处方ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargePrescriptionId;

    /**
     * 收费单患者ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargePatientId;

    /**
     * 收费单患者名字
     */
    private String chargePatientName;

    /**
     * 收费单总金额
     */
    private BigDecimal chargeMoney;

    /**
     * 收费单优惠金额
     */
    private BigDecimal chargePreferentialMoney;

    /**
     * 收费单实际支付金额
     */
    private BigDecimal chargePayMoney;

    /**
     * 收费单状态
     */
    private String chargeStatus;

    /**
     * 收费时间
     */
    private String chargeTime;

    /**
     * 收费单所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargeTenantId;
}
