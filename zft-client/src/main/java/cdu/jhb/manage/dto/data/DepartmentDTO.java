package cdu.jhb.manage.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 科室DTO
* @author jhb
* @date 2023/2/20 21:09
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    /**
     * 科室ID
     */
    private Long department_id;

    /**
     * 科室名称
     */
    private String department_name;

    /**
     * 科室类别
     */
    private String department_category;

    /**
     * 科室评级
     */
    private Integer department_rate;

    /**
     * 科室介绍
     */
    private String department_introduce;
    /**
     * 科室人数
     */
    private Integer department_employee_num;
    /**
     * 科室所属诊所
     */
    private Integer department_tenant_id;
}
