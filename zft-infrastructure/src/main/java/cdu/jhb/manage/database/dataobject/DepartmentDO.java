package cdu.jhb.manage.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
* @description: 科室DO
* @author jhb
* @date 2023/04/28 20:36
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("department_table")
public class DepartmentDO {
    /**
     * 科室ID
     */
    @TableId(type = IdType.ID_WORKER)
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
