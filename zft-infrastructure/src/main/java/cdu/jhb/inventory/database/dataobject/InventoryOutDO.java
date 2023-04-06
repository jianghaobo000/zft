package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:23
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_out_table")
public class InventoryOutDO {
    /**
     * 出库单ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventory_out_id;

    /**
     * 出库时间
     */
    private String inventory_out_time;

    /**
     * 出库人
     */
    private Long inventory_out_operator_id;

    /**
     * 出库品种数
     */
    private Integer inventory_out_variety;

    /**
     * 出库单所属诊所
     */
    private Long inventory_out_tenant_id;
}
