package cdu.jhb.inventory.data.request;

import cdu.jhb.common.PageCommon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 入库单查询对象
* @author jhb
* @date 2023/04/07 21:33
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryInListQuery extends PageCommon {
    /**
     * 入库单状态
     */
    private String inventoryInStatus;

    /**
     * 入库单类型 1:创建时间 2:入库时间
     */
    private Integer inventoryInDateCategory;

    /**
     * 入库单开始时间
     */
    private String inventoryInBeginTime;

    /**
     * 入库单结束时间
     */
    private String inventoryInEndTime;

    /**
     * 入库单供应商ID
     */
    private Long inventoryInSupplierId;

    /**
     * 入库人ID
     */
    private Long inventoryInOperatorId;

    /**
     * 入库单所属诊所
     */
    private Long inventoryInTenantId;
}
