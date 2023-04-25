package cdu.jhb.charge.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long chargeId;

    /**
     * 收费单患者ID
     */
    private Long chargePatientId;

    /**
     * 收费单总金额
     */
    private Integer chargeMoney;

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
    private Long chargeTenantId;
}
