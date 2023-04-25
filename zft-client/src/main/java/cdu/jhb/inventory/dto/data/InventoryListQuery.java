package cdu.jhb.inventory.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 品相信息查询条件
* @author jhb
* @date 2023/04/01 16:14
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryListQuery {
    /**
     * 商品名字
     */
    private String inventoryCommodityName;

    /**
     * 商品生产厂家
     */
    private String inventoryManufacturer;

    /**
     * 商品类型
     */
    private String inventoryCategory;

    /**
     * 商品属诊所
     */
    private Long inventoryTenantId;
}
