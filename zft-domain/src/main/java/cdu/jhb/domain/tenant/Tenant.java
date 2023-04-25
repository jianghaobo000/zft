package cdu.jhb.domain.tenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 诊所实体
* @author jhb
* @date 2023/2/21 11:29
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {
    /**
     * 诊所ID
     */
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
