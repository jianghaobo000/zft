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
