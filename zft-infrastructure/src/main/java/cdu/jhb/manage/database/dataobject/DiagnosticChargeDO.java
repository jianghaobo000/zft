package cdu.jhb.manage.database.dataobject;

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
* @description: 挂号费DO
* @author jhb
* @date 2023/05/01 17:21
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("diagnostic_charge_table")
public class DiagnosticChargeDO {

    /**
     * 诊费ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long diagnosticChargeId;

    /**
     * 诊费所属员工ID
     */
    private Long diagnosticChargeEmployeeId;

    /**
     * 诊费所属员工名字
     */
    private String diagnosticChargeEmployeeName;

    /**
     * 诊费状态（0、统一，1、医护技，2、非医护技）
     */
    private Integer diagnosticChargeStatus;

    /**
     * 初诊费
     */
    private BigDecimal diagnosticChargeFirst;

    /**
     * 复诊费
     */
    private BigDecimal diagnosticChargeRepeat;

    /**
     * 诊费所属租户
     */
    private Long diagnosticChargeTenantId;

}
