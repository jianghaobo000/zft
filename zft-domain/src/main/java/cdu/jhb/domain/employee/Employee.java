package cdu.jhb.domain.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 员工实体
* @author jhb
* @date 2023/2/21 11:17
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
     * 员工姓名
     */
    private String employeeName;

    /**
     * 员工生日
     */
    private String employeeBirthday;

    /**
     * 员工姓名
     */
    private String employeeSex;

    /**
     * 员工电话
     */
    private String employeePhone;

    /**
     * 员工职位
     */
    private String employeePosition;

    /**
     * 员工账号ID
     */
    private Long employeeAccountId;

    /**
     * 员工头像
     */
    private String employeePicture;

    /**
     * 员工身份证号
     */
    private Integer employeeIdNumber;

    /**
     * 员工所属科室ID
     */
    private Long employeeDepartmentId;

    /**
     * 员工所属科室名字
     */
    private String employeeDepartmentName;
    /**
     * 员工介绍
     */
    private String employeeIntroduce;
    /**
     * 员工所属诊所
     */
    private Long employeeTenantId;
}
