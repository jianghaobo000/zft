package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 盘点单主表DTO
 * @author jhb
 * @date 2023/2/20 22:23
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryCheckDTO {
    /**
     * 盘点单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckId;

    /**
     * 盘点时间
     */
    private String inventoryCheckTime;

    /**
     * 盘点单创建时间
     */
    private String inventoryCheckCreateTime;

    /**
     * 盘点单盈亏数量
     */
    private BigDecimal inventoryCheckNum;

    /**
     * 盘点单盈亏金额-进价
     */
    private BigDecimal inventoryCheckBidMoney;

    /**
     * 盘点单盈亏金额-售价
     */
    private BigDecimal inventoryCheckSaleMoney;

    /**
     * 盘点人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckOperatorId;

    /**
     * 盘点品种数
     */
    private Integer inventoryCheckVariety;

    /**
     * 盘点单备注
     */
    private String inventoryCheckRemarks;

    /**
     * 盘点单所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryCheckTenantId;

    /**
     * 盘点单明细列表
     */
    private List<InventoryCheckDetailDTO> inventoryCheckDetailList;
}
