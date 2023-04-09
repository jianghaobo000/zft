package cdu.jhb.inventory.dto.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 供应商DTO
* @author jhb
* @date 2023/04/09 15:33
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    /**
     * 供应商ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long supplier_id;

    /**
     * 供应商名称
     */
    private String supplier_name;

    /**
     * 供应商启用状态
     */
    private Integer supplier_status;

    /**
     * 供应商所属诊所
     */
    private Long supplier_tenant_id;
}
