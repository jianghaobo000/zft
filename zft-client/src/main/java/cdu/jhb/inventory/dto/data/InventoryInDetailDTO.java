package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 入库单明细DTO
* @author jhb
* @date 2023/2/20 22:16
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInDetailDTO {
    /**
     * 入库单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_in_detail_id;

    /**
     * 入库单主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_in_id;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_in_commodity_id;

    /**
     * 商品名称
     */
    private String inventory_in_commodity_name;

    /**
     * 商品库存单位（大）
     */
    private String inventory_in_large_unit;

    /**
     * 商品库存单位（小）
     */
    private String inventory_in_small_unit;

    /**
     * 商品入库前数量（大）
     */
    private Integer inventory_in_before_large_num;

    /**
     * 商品入库前数量（小）
     */
    private Integer inventory_in_before_small_num;

    /**
     * 商品入库后数量（大）
     */
    private Integer inventory_in_after_large_num;

    /**
     * 商品入库后数量（小）
     */
    private Integer inventory_in_after_small_num;

    /**
     * 商品入库数量（大）
     */
    private Integer inventory_in_large_num;

    /**
     * 商品入库数量（小）
     */
    private Integer inventory_in_small_num;
}
