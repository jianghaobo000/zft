package cdu.jhb.tenant.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:19
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tenant_table")
public class TenantDO {
    /**
     * 诊所ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long tenantId;

    /**
     * 诊所名称
     */
    private String tenantName;

    /**
     * 诊所国家码
     */
    private String tenantCountryCode;

    /**
     * 诊所所在地区（省级）
     */
    private String tenantAreaProvince;

    /**
     * 诊所所在地区（市级）
     */
    private String tenantAreaUrban;

    /**
     * 诊所所在地区（县级）
     */
    private String tenantAreaCounty;

    /**
     * 诊所等级
     */
    private String tenantRate;

    /**
     * 诊所开设时间
     */
    private String tenantBeginTime;

    /**
     * 诊所介绍
     */
    private String tenantIntroduce;
}
