package cdu.jhb.domain.inventory;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* @description: 入库单实体
* @author jhb
* @date 2023/2/21 11:19
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryIn {
    /**
     * 入库单ID
     */
    private Long inventoryInId;

    /**
     * 入库单状态
     */
    private String inventoryInStatus;

    /**
     * 入库单供应商ID
     */
    private Long inventoryInSupplierId;

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
    private Long inventoryInOperatorId;

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
     * 入库单所属诊所
     */
    private Long inventoryInTenantId;

    /**
     * 入库单明细列表
     */
    private List<InventoryInDetail> inventoryInDetails;
}
