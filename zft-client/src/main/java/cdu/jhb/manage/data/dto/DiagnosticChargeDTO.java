package cdu.jhb.manage.data.dto;

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
    private Long diagnosticChargeId;

    /**
     *
     */
    private Long diagnosticChargeEmployeeId;

    /**
     *
     */
    private Integer diagnosticChargeStatus;

    /**
     *
     */
    private BigDecimal diagnosticChargeFirst;

    /**
     *
     */
    private BigDecimal diagnosticChargeRepeat;

    /**
     *
     */
    private Long diagnosticChargeTenantId;

}
