package cdu.jhb.inventory.dto.data;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
* @description: 出库单信息DTO
* @author jhb
* @date 2023/04/07 22:17
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOutInfoDTO {
    /**
     * 出库单ID
     */
    private Long inventory_out_id;

    /**
     * 出库单状态
     */
    private String inventory_out_status;

    /**
     * 出库类型
     */
    private String inventory_out_category;

    /**
     * 出库品种数
     */
    private int inventory_out_variety;

    /**
     * 出库时间
     */
    private String inventory_out_time;

    /**
     * 出库单创建时间
     */
    private String inventory_out_create_time;

    /**
     * 出库人
     */
    private String inventory_out_operator;

    /**
     * 出库单金额
     */
    private BigDecimal inventory_out_money;

    /**
     * 出库单备注
     */
    private String inventory_out_remarks;

    /**
     * 出库单明细列表
     */
    private List<InventoryOutDetailDTO> inventory_out_detail_list;
}
