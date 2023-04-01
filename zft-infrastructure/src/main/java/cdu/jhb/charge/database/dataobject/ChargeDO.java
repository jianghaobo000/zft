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
     * 收费单状态
     */
    private String charge_status;

    /**
     * 收费单所属诊所
     */
    private Long charge_tenant_id;

    /**
     * 收费时间
     */
    private String charge_time;
}
