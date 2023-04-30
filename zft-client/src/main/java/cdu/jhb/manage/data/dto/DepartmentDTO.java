package cdu.jhb.manage.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departmentTenantId;
}
