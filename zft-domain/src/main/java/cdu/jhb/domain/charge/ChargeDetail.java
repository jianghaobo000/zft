package cdu.jhb.domain.charge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 收费单明细实体
* @author jhb
* @date 2023/2/21 10:56
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeDetail {
    /**
     * 收费单明细ID
     */
    private Long charge_detail_id;

    /**
     * 所属收费单ID
     */
    private Long charge_id;

    /**
     * 收费单商品ID
     */
    private Long charge_commodity_id;

    /**
     * 收费单商品数量（大）
     */
    private Integer charge_commodity_large;

    /**
     * 收费单商品数量（小）
     */
    private Integer charge_commodity_small;
}
