package cdu.jhb.account.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 员工执业详情DTO
* @author jhb
* @date 2023/04/28 20:48
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticeDTO {
    /**
     * 医护技HIS码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long practiceId;

    /**
     * 有效证件类型
     */
    private String practiceValidIdType;

    /**
     * 有效证件号码
     */
    private String practiceValidIdNumber;

    /**
     * 执业证书编号
     */
    private String practiceCertificateNumber;

    /**
     * 执业资格证书编号
     */
    private String practiceQualificationCertificateNumber;

    /**
     * 执业注册地
     */
    private String practiceAddress;

    /**
     * 科室ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long practiceDepartmentId;

    /**
     * 人员国家码
     */
    private String practicePersonnelCountryCode;

    /**
     * 职称
     */
    private String practiceTitle;

    /**
     * 个人开始执业时间
     */
    private String practicePersonBeginTime;

    /**
     * 个人结束执业时间
     */
    private String practicePersonEndTime;

    /**
     * 在诊所开始执业时间
     */
    private String practiceClinicBeginTime;

    /**
     * 在诊所结束执业时间
     */
    private String practiceClinicEndTime;

    /**
     * 执业详情所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long practiceTenantId;
}
