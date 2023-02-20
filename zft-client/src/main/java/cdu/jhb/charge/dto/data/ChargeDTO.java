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
    private Long charge_id;

    /**
     * 收费单患者ID
     */
    private Long charge_patient_id;

    /**
     * 收费单总金额
     */
    private Integer charge_money;

    /**
     * 收费单所属诊所
     */
    private Long charge_tenant_id;

    /**
     * 收费时间
     */
    private String charge_time;
}
