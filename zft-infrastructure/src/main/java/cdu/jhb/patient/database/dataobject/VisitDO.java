package cdu.jhb.patient.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 就诊实体
* @author jhb
* @date 2023/2/21 11:26
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("visit_table")
public class VisitDO {
    /**
     * 就诊ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long visitId;

    /**
     * 就诊记录所属病历单ID
     */
    private Long visitAdviceId;

    /**
     * 就诊患者ID
     */
    private Long visitPatientId;

    /**
     * 就诊患者姓名
     */
    private String visitPatientName;

    /**
     * 就诊时间
     */
    private String visitTime;

    /**
     * 就诊症状
     */
    private String visitSymptom;

    /**
     * 就诊医生ID
     */
    private Long visitDoctorId;

    /**
     * 就诊医生名称
     */
    private String visitDoctorName;

    /**
     * 就诊所属诊所
     */
    private Long visitTenantId;
}
