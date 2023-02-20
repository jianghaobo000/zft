package cdu.jhb.charge.dto.data;

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
    private Long pay_id;

    /**
     * 支付名称
     */
    private String pay_name;
}
