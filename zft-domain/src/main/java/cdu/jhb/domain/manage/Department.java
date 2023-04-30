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
     * 科室代码
     */
    private String departmentCode;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室拼音码
     */
    private String departmentPinYin;

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
    private Long departmentTenantId;
}
