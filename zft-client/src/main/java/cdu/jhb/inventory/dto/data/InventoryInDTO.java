package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
* @description: 入库单主表DTO
* @author jhb
* @date 2023/2/20 22:14
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryInDTO {
    /**
     * 入库单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_in_id;

    /**
     * 入库单状态
     */
    private String inventory_in_status;

    /**
     * 入库单供应商ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_in_supplier_id;

    /**
     * 随货单号
     */
    private String inventory_in_delivery;

    /**
     * 入库时间
     */
    private String inventory_in_time;

    /**
     * 入库单创建时间
     */
    private String inventory_in_create_time;

    /**
     * 入库人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_in_operator_id;

    /**
     * 入库品种数
     */
    private Integer inventory_in_variety;

    /**
     * 入库单备注
     */
    private String inventory_remarks;

    /**
     * 入库单金额
     */
    private BigDecimal inventory_in_money;

    /**
     * 入库单所属诊所
     */
    private Long inventory_in_tenant_id;

    /**
     * 入库单明细
     */
    private List<InventoryInDetailDTO> inDetailList;
}
