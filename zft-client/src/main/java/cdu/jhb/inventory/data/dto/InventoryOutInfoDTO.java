package cdu.jhb.inventory.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryOutId;

    /**
     * 出库单状态
     */
    private String inventoryOutStatus;

    /**
     * 出库类型
     */
    private String inventoryOutCategory;

    /**
     * 出库品种数
     */
    private int inventoryOutVariety;

    /**
     * 出库时间
     */
    private String inventoryOutTime;

    /**
     * 出库单创建时间
     */
    private String inventoryOutCreateTime;

    /**
     * 出库人
     */
    private String inventoryOutOperator;

    /**
     * 出库单金额
     */
    private BigDecimal inventoryOutMoney;

    /**
     * 出库单备注
     */
    private String inventoryOutRemarks;

    /**
     * 出库单明细列表
     */
    private List<InventoryOutDetailDTO> inventoryOutDetailList;
}
