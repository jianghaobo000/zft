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
    private Long employee_id;

    /**
     * 员工姓名
     */
    private String employee_name;

    /**
     * 员工生日
     */
    private String employee_birthday;

    /**
     * 员工姓名
     */
    private String employee_sex;

    /**
     * 员工电话
     */
    private String employee_phone;

    /**
     * 员工职位
     */
    private String employee_position;

    /**
     * 员工账号ID
     */
    private Long employee_account_id;

    /**
     * 员工头像
     */
    private String employee_picture;

    /**
     * 员工身份证号
     */
    private Integer employee_id_number;

    /**
     * 员工所属科室ID
     */
    private Long employee_department_id;

    /**
     * 员工所属科室名字
     */
    private String employee_department_name;
    /**
     * 员工介绍
     */
    private String employee_introduce;
    /**
     * 员工所属诊所
     */
    private Long employee_tenant_id;
}
