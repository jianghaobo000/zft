package cdu.jhb.manage.database.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 科室DO
* @author jhb
* @date 2023/04/28 20:36
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDO {
    /**
     * 科室ID
     */
    private Long departmentId;

    /**
     * 科室代码
     */
    private Long departmentCode;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室类别
     */
    private String departmentCategory;

    /**
     * 科室批准床位数
     */
    private Integer departmentBedNum;

    /**
     * 科室负责人
     */
    private String departmentHeader;

    /**
     * 科室联系电话
     */
    private String departmentTel;

    /**
     * 科室介绍
     */
    private String departmentIntroduce;

    /**
     * 科室所属诊所
     */
    private Integer departmentTenantId;
}
