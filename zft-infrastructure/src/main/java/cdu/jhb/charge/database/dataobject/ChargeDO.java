package cdu.jhb.charge.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:14
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("charge_table")
public class ChargeDO {
    /**
     * 收费单主表ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long chargeId;

    /**
     * 收费单所属处方ID
     */
    private Long chargePrescriptionId;

    /**
     * 收费单患者ID
     */
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
     * 收费单所属诊所
     */
    private Long chargeTenantId;

    /**
     * 收费时间
     */
    private String chargeTime;
}
