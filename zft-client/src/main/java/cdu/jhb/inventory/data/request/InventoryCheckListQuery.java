package cdu.jhb.inventory.data.request;

import cdu.jhb.common.PageCommon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 品相信息查询条件
* @author jhb
* @date 2023/04/01 16:14
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryCheckListQuery extends PageCommon {
    /**
     * 盘点单状态
     */
    private String InventoryCheckStatus;

    /**
     * 盘点单类型 1:创建时间 2:出库时间
     */
    private Integer InventoryCheckDateCategory;

    /**
     * 盘点单开始时间
     */
    private String InventoryCheckBeginTime;

    /**
     * 盘点单结束时间
     */
    private String InventoryCheckEndTime;

    /**
     * 盘点人ID
     */
    private Long InventoryCheckOperatorId;

    /**
     * 盘点单所属诊所
     */
    private Long InventoryCheckTenantId;
}
