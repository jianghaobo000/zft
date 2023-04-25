package cdu.jhb.domain.charge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 收费单实体
* @author jhb
* @date 2023/2/21 10:55
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Charge {
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
     * 收费单所属诊所
     */
    private Long chargeTenantId;

    /**
     * 收费时间
     */
    private String chargeTime;
}
