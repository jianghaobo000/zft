package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 库存DTO
* @author jhb
* @date 2023/2/20 22:11
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    /**
     * 库存ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long InventoryId;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long InventoryCommodityId;

    /**
     * 商品名称
     */
    private String InventoryCommodityName;

    /**
     * 商品库存数量（大）
     */
    private Integer InventoryLargeNum;

    /**
     * 商品库存单位（大）
     */
    private String InventoryLargeUnit;

    /**
     * 商品库存数量（小）
     */
    private Integer InventorySmallNum;

    /**
     * 商品库存单位（小）
     */
    private String InventorySmallUnit;

    /**
     * 商品所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long InventoryTenantId;
}
