package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @TableId(type = IdType.ID_WORKER)
    private Long inventoryId;

    /**
     * 商品ID
     */
    private Long inventoryCommodityId;

    /**
     * 商品名称
     */
    private String inventoryCommodityName;

    /**
     * 商品库存数量（大）
     */
    private Integer inventoryLargeNum;

    /**
     * 商品库存单位（大）
     */
    private String inventoryLargeUnit;

    /**
     * 商品库存数量（小）
     */
    private Integer inventorySmallNum;

    /**
     * 商品库存单位（小）
     */
    private String inventorySmallUnit;

    /**
     * 商品所属诊所
     */
    private Long inventoryTenantId;
}
