package cdu.jhb.charge.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
* @description: 支付字典DTO
* @author jhb
* @date 2023/2/20 22:02
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDictDTO {
    /**
     * 支付方式ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long payId;

    /**
     * 支付名称
     */
    private String payName;

    /**
     * 支付方式状态（0、未启用 1、启用）
     */
    private Integer payStatus;

    /**
     * 支付方式所属租户
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long payTenantId;
}
