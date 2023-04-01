package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:22
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_in_table")
public class InventoryInDO {
    /**
     * 入库单ID
     */
    private Long inventory_in_id;

    /**
     * 入库时间
     */
    private String inventory_in_time;

    /**
     * 入库人
     */
    private Long inventory_in_operator_id;

    /**
     * 入库品种数
     */
    private Integer inventory_in_variety;

    /**
     * 入库单所属诊所
     */
    private Long inventory_in_tenant_id;
}
