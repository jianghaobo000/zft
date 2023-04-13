package cdu.jhb.inventory.dto.data;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 盘点单明细DTO
* @author jhb
* @date 2023/2/20 22:26
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheckDetailDTO extends CommodityDTO {
    /**
     * 盘点单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_check_detail_id;

    /**
     * 盘点单主表ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_check_id;

    /**
     * 商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_check_commodity_id;

    /**
     * 商品名称
     */
    private String inventory_check_commodity_name;

    /**
     * 商品库存单位（大）
     */
    private String inventory_check_large_unit;

    /**
     * 商品库存单位（小）
     */
    private String inventory_check_small_unit;

    /**
     * 商品盘点前数量（大）
     */
    private Integer inventory_check_before_large_num;

    /**
     * 商品盘点前数量（小）
     */
    private Integer inventory_check_before_small_num;

    /**
     * 商品盘点后数量（大）
     */
    private Integer inventory_check_after_large_num;

    /**
     * 商品盘点后数量（小）
     */
    private Integer inventory_check_after_small_num;

    /**
     * 商品盘点数量（大）
     */
    private Integer inventory_check_large_num;

    /**
     * 商品盘点数量（小）
     */
    private Integer inventory_check_small_num;
}
