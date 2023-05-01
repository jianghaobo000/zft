package cdu.jhb.manage.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 设备DTO
* @author jhb
* @date 2023/05/01 12:44
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    /**
     * 设备HIS码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long equipmentId;

    /**
     * 所属科室ID
     */
    private Long equipmentDepartmentId;

    /**
     * 设备名称
     */
    private String equipmentName;

    /**
     * 设备拼音码
     */
    private String equipmentPinYin;

    /**
     * 设备品牌
     */
    private String equipmentBrand;

    /**
     * 设备型号
     */
    private String equipmentModel;

    /**
     * 设备产地
     */
    private String equipmentAddress;

    /**
     * 购买日期
     */
    private String equipmentPurchaseDate;

    /**
     * 使用年限
     */
    private Integer equipmentUseLife;

    /**
     * 产品介绍
     */
    private String equipmentIntroduce;

    /**
     * 产品所属诊所
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long equipmentTenantId;
}
