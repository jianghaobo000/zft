package cdu.jhb.domain.charge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 支付字典实体
* @author jhb
* @date 2023/2/21 11:16
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDict {
    /**
     * 支付方式ID
     */
    private Long payId;

    /**
     * 支付名称
     */
    private String payName;
}
