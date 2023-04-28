package cdu.jhb.domain.account;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 员工DTO
* @author jhb
* @date 2023/2/20 21:00
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    /**
     * 员工ID
     */
    private Long employeeId;

    /**
     * 员工账号详情ID
     */
    private Long employeeAccountId;

    /**
     * 员工执业详情ID
     */
    private Long employeePracticeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 员工姓名拼音全拼简拼
     */
    private String employeePinYin;

    /**
     * 员工生日
     */
    private String employeeBirthday;

    /**
     * 员工民族
     */
    private String employeeNation;

    /**
     * 员工姓别
     */
    private String employeeSex;

    /**
     * 员工电话
     */
    private String employeePhone;

    /**
     * 是否为医护技
     */
    private Integer employeeMedicalNursingSkills;

    /**
     * 员工所属诊所
     */
    private Long employeeTenantId;
}
