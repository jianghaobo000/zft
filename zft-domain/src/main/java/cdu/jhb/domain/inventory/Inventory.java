package cdu.jhb.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 库存实体
* @author jhb
* @date 2023/2/21 11:18
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    /**
     * 库存ID
     */
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
     * 商品拼音码
     */
    private String InventoryCommodityPinyin;

    /**
     * 商品大小单位转换比
     */
    private Integer inventoryDosageForm;

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
