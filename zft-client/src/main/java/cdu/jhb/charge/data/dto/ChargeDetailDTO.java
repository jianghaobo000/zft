package cdu.jhb.charge.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 收费单明细DTO
* @author jhb
* @date 2023/2/20 21:57
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargeDetailDTO {
    /**
     * 收费单明细ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
     private Long chargeDetailId;

    /**
     * 所属收费单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
     private Long chargeId;

    /**
     * 收费单商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
     private Long chargeCommodityId;

    /**
     * 收费单商品数量（大）
     */
     private Integer chargeCommodityLarge;

    /**
     * 收费单商品数量（小）
     */
     private Integer chargeCommoditySmall;
}
