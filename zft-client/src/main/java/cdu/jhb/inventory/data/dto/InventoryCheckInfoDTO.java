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
public class InventoryCheckInfoDTO {
    /**
     * 盘点单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckId;

    /**
     * 盘点单状态
     */
    private String inventoryCheckStatus;

    /**
     * 盘点时间
     */
    private String inventoryCheckTime;

    /**
     * 盘点单创建时间
     */
    private String inventoryCheckCreateTime;

    /**
     * 盘点人
     */
    private String inventoryCheckOperator;

    /**
     * 盘点品种数
     */
    private Integer inventoryCheckVariety;

    /**
     * 盘点单备注
     */
    private String inventoryCheckRemarks;

    /**
     * 盘点单明细列表
     */
    private List<InventoryCheckDetailDTO> inventoryCheckDetailList;
}
