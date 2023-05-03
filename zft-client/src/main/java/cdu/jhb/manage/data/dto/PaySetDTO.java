package cdu.jhb.manage.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/05/03 20:20
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaySetDTO {
    /**
     * 支付设置ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paySetId;

    /**
     * 支付设置零头自动处理方式 1、保持不变 2、凑角到整
     */
    private Integer paySetFractionalAmount;

    /**
     * 支付设置议价开启标志 0不允许 1允许
     */
    private Integer paySetBargainingStatus;

    /**
     * 支付设置最低议价标准
     */
    private Integer paySetLowest;

    /**
     * 支付设置所属租户
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paySetTenantId;
}
