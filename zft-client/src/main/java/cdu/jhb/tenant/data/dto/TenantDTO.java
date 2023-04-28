package cdu.jhb.tenant.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 诊所DTO
* @author jhb
* @date 2023/2/19 13:09
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantDTO {
    /**
     * 诊所ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tenantId;

    /**
     * 诊所名称
     */
    private String tenantName;

    /**
     * 内部简称
     */
    private String tenantAbbreviation;

    /**
     * 联系电话
     */
    private String tenantTel;

    /**
     * 营业面积（平方米）
     */
    private String tenantSize;

    /**
     * 诊所地址
     */
    private String tenantAddress;

    /**
     * 诊所开设时间
     */
    private String tenantBeginTime;

    /**
     * 诊所介绍
     */
    private String tenantIntroduce;

    /**
     * 诊所评级
     */
    private BigDecimal tenantRate;

    /**
     * 法定代表人姓名
     */
    private String tenantLegalName;

    /**
     * 法定代表人身份证号
     */
    private String tenantLegalNumber;

    /**
     * 执业许可证号
     */
    private String tenantLicenseKey;

    /**
     * 统一社会信用代码
     */
    private String tenantCreditCode;

    /**
     * 诊所国家码
     */
    private String tenantCountryCode;

    /**
     * 诊所备注
     */
    private String tenantRemarks;
}
