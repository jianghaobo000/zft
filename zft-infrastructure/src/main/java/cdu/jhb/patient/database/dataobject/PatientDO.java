package cdu.jhb.patient.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 患者实体
* @author jhb
* @date 2023/2/21 11:24
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("patient_table")
public class PatientDO {
    /**
     * 患者ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long patientId;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 患者性别
     */
    private String patientSex;

    /**
     * 患者生日
     */
    private String patientBirthday;

    /**
     * 患者身份证号
     */
    private Integer patientIdNumber;

    /**
     * 患者所属诊所
     */
    private Long patientTenantId;
}
