package cdu.jhb.charge.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:15
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("charge_detail_table")
public class ChargeDetailDO {
    /**
     * 收费单明细ID
     */
    @TableId(type = IdType.ID_WORKER)
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
