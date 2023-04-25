package cdu.jhb.domain.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 科室实体
* @author jhb
* @date 2023/2/21 11:23
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
     * 科室ID
     */
    private Long departmentId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室类别
     */
    private String departmentCategory;

    /**
     * 科室评级
     */
    private Integer departmentRate;

    /**
     * 科室介绍
     */
    private String departmentIntroduce;
    /**
     * 科室人数
     */
    private Integer departmentEmployeeNum;
    /**
     * 科室所属诊所
     */
    private Integer departmentTenantId;
}
