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
