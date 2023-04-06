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
* @date 2023/04/01 21:24
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_check_table")
public class InventoryCheckDO {
    /**
     * 盘点单ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventory_check_id;

    /**
     * 盘点时间
     */
    private String inventory_check_time;

    /**
     * 盘点人
     */
    private Long inventory_check_operator_id;

    /**
     * 盘点品种数
     */
    private Integer inventory_check_variety;

    /**
     * 盘点单所属诊所
     */
    private Long inventory_check_tenant_id;
}
