package cdu.jhb.tenant.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:19
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tenant_table")
public class TenantDO {
    /**
     * 诊所ID
     */
    private Long tenant_id;

    /**
     * 诊所名称
     */
    private String tenant_name;

    /**
     * 诊所所在地区（省级）
     */
    private String tenant_area_province;

    /**
     * 诊所所在地区（市级）
     */
    private String tenant_area_urban;

    /**
     * 诊所所在地区（县级）
     */
    private String tenant_area_county;

    /**
     * 诊所等级
     */
    private String tenant_rate;

    /**
     * 诊所开设时间
     */
    private String tenant_begin_time;

    /**
     * 诊所介绍
     */
    private String tenant_introduce;
}
