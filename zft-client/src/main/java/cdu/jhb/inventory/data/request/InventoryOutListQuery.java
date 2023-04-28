package cdu.jhb.inventory.data.request;

import cdu.jhb.common.PageCommon;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class InventoryOutListQuery extends PageCommon {
    /**
     * 出库单状态
     */
    private String inventoryOutStatus;

    /**
     * 出库单类型 1:创建时间 2:出库时间
     */
    private Integer inventoryOutDateCategory;

    /**
     * 出库单开始时间
     */
    private String inventoryOutBeginTime;

    /**
     * 出库单结束时间
     */
    private String inventoryOutEndTime;

    /**
     * 出库单类型 领料出库、报损出库
     */
    private String inventoryOutCategory;

    /**
     * 出库人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryOutOperatorId;

    /**
     * 出库单所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventoryOutTenantId;
}
