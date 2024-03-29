package cdu.jhb.manage.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 挂号费DTO
* @author jhb
* @date 2023/05/01 17:21
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticChargeDTO {

    /**
     * 诊费ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long diagnosticChargeId;

    /**
     * 诊费所属员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long diagnosticChargeEmployeeId;

    /**
     * 诊费所属员工名字
     */
    private String diagnosticChargeEmployeeName;

    /**
     * 诊费状态（0、统一，1、个人）
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long diagnosticChargeTenantId;

}
