package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:20
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_table")
public class InventoryDO {
    /**
     * 库存ID
     */
    private Long inventory_id;

    /**
     * 商品ID
     */
    private Long inventory_commodity_id;

    /**
     * 商品名称
     */
    private String inventory_commodity_name;

    /**
     * 商品库存数量（大）
     */
    private Integer inventory_large_num;

    /**
     * 商品库存单位（大）
     */
    private String inventory_large_unit;

    /**
     * 商品库存数量（小）
     */
    private Integer inventory_small_num;

    /**
     * 商品库存单位（小）
     */
    private String inventory_small_unit;

    /**
     * 商品所属诊所
     */
    private Long inventory_tenant_id;
}
