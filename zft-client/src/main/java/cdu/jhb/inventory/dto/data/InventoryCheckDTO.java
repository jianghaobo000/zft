package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long inventory_check_id;

    /**
     * 盘点时间
     */
    private String inventory_check_time;

    /**
     * 盘点人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inventory_check_operator_id;

    /**
     * 盘点品种数
     */
    private Integer inventory_check_variety;

    /**
     * 盘点单所属诊所
     */
    private Long inventory_check_tenant_id;
}
