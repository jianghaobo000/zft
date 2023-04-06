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
    private Long inventory_id;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
