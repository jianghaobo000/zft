package cdu.jhb.inventory.data.dto;

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
public class InventoryInInfoDTO {
    /**
     * 入库单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryInId;

    /**
     * 入库单状态
     */
    private String inventoryInStatus;

    /**
     * 入库单供应商
     */
    private String inventoryInSupplierName;

    /**
     * 入库时间
     */
    private String inventoryInTime;

    /**
     * 入库单创建时间
     */
    private String inventoryInCreateTime;

    /**
     * 入库人
     */
    private String inventoryInOperator;

    /**
     * 入库品种数
     */
    private Integer inventoryInVariety;

    /**
     * 入库单备注
     */
    private String inventoryInRemarks;

    /**
     * 入库单金额
     */
    private BigDecimal inventoryInMoney;

    /**
     * 入库单明细列表
     */
    private List<InventoryInDetailDTO> inventoryInDetailList;
}
