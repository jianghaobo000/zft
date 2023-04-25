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
    private Long chargeDetailId;

    /**
     * 所属收费单ID
     */
    private Long chargeId;

    /**
     * 收费单商品ID
     */
    private Long chargeCommodityId;

    /**
     * 收费单商品数量（大）
     */
    private Integer chargeCommodityLarge;

    /**
     * 收费单商品数量（小）
     */
    private Integer chargeCommoditySmall;
}
