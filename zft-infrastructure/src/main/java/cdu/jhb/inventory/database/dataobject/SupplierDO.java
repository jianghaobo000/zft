package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 供应商DO
* @author jhb
* @date 2023/04/09 15:33
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDO {

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商启用状态
     */
    private Integer supplierStatus;

    /**
     * 供应商所属诊所
     */
    private Long supplierTenantId;
}
