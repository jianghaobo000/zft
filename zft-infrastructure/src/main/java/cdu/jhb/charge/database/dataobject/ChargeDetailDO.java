package cdu.jhb.charge.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: 收费单明细DO
* @author jhb
* @date 2023/3/1 20:15
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("charge_detail_table")
public class ChargeDetailDO {
    /**
     * 收费单明细ID
     */
    private Long chargeDetailId;

    /**
     * 所属收费单ID
     */
    private Long chargeId;

    /**
     * 收费单商品ID
     */
    private Long chargeDetailCommodityId;

    /**
     * 收费单商品名
     */
    private String chargeDetailCommodityName;

    /**
     * 收费单药品是否拆零销售
     */
    private Integer chargeDetailSplitSaleStatus;

    /**
     * 收费单药品大小单位转换比
     */
    private Integer chargeDetailDosageForm;

    /**
     * 收费单明细药品大单位价格
     */
    private BigDecimal chargeDetailLargePrice;

    /**
     * 收费单明细药品小单位价格
     */
    private BigDecimal chargeDetailSmallPrice;

    /**
     * 收费单药品数量（大单位）
     */
    private Integer chargeDetailLargeNum;

    /**
     * 收费单药品数量（小单位）
     */
    private Integer chargeDetailSmallNum;

    /**
     * 收费单药品大单位
     */
    private String chargeDetailLargeUnit;

    /**
     * 收费单药品小单位
     */
    private String chargeDetailSmallUnit;
}
