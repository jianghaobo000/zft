package cdu.jhb.account.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 执业详情DO
* @author jhb
* @date 2023/04/28 21:01
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("practice_table")
public class PracticeDO {
    /**
     * 医护技HIS码
     */
    @TableId(type = IdType.ID_WORKER)
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
    private Long practiceTenantId;
}
