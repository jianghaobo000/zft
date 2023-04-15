package cdu.jhb.inventory.dto.data;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
* @description: 入库单信息DTO
* @author jhb
* @date 2023/04/07 22:17
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheckInfoDTO {
    /**
     * 盘点单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_check_id;

    /**
     * 盘点单状态
     */
    private String inventory_check_status;

    /**
     * 盘点单盈亏数量
     */
    private String inventory_check_num;

    /**
     * 盘点时间
     */
    private String inventory_check_time;

    /**
     * 盘点单创建时间
     */
    private String inventory_check_create_time;

    /**
     * 盘点单盈亏金额-进价
     */
    private BigDecimal inventory_check_bid_money;

    /**
     * 盘点单盈亏金额-售价
     */
    private BigDecimal inventory_check_sale_money;

    /**
     * 盘点人
     */
    private String inventory_check_operator;

    /**
     * 盘点品种数
     */
    private Integer inventory_check_variety;

    /**
     * 盘点单备注
     */
    private String inventory_check_remarks;

    /**
     * 盘点单明细列表
     */
    private List<InventoryCheckDetailDTO> inventory_check_detail_list;
}
