package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.List;

/**
* @description: 出库单主表DTO
* @author jhb
* @date 2023/2/20 22:20
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryOutDTO {
    /**
     * 出库单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_out_id;

    /**
     * 出库单状态
     */
    private String inventory_out_status;

    /**
     * 出库时间
     */
    private String inventory_out_time;

    /**
     * 出库单状态
     */
    private String inventory_out_create_time;

    /**
     * 出库单类型
     */
    private String inventory_out_category;

    /**
     * 出库人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_out_operator_id;

    /**
     * 出库品种数
     */
    private Integer inventory_out_variety;

    /**
     * 出库单备注
     */
    private String inventory_out_remarks;

    /**
     * 出库单金额
     */
    private BigDecimal inventory_out_money;

    /**
     * 出库单所属诊所
     */
    private Long inventory_out_tenant_id;

    /**
     * 出库单明细列表
     */
    private List<InventoryOutDetailDTO> inventory_out_detail_list;
}
