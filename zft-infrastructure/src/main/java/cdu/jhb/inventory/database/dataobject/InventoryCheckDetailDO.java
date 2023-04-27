package cdu.jhb.inventory.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:24
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("inventory_check_detail_table")
public class InventoryCheckDetailDO {
    /**
     * 盘点单明细ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long inventoryCheckDetailId;

    /**
     * 盘点单主表ID
     */
    private Long inventoryCheckId;

    /**
     * 商品ID
     */
    private Long inventoryCheckCommodityId;

    /**
     * 商品名称
     */
    private String inventoryCheckCommodityName;

    /**
     * 商品国家码
     */
    private String inventoryCheckCountryCode;

    /**
     * 商品规格
     */
    private String inventoryCheckCommoditySpecification;

    /**
     * 商品是否拆零销售
     */
    private Integer inventoryCheckSplitSaleStatus;

    /**
     * 商品库存单位（大）
     */
    private String inventoryCheckLargeUnit;

    /**
     * 商品库存单位（小）
     */
    private String inventoryCheckSmallUnit;

    /**
     * 商品大小单位转换比
     */
    private Integer inventoryCheckDosageForm;

    /**
     * 商品盘点前数量（大）
     */
    private Integer inventoryCheckBeforeLargeNum;

    /**
     * 商品盘点前数量（小）
     */
    private Integer inventoryCheckBeforeSmallNum;

    /**
     * 商品盘点后数量（大）
     */
    private Integer inventoryCheckAfterLargeNum;

    /**
     * 商品盘点后数量（小）
     */
    private Integer inventoryCheckAfterSmallNum;

    /**
     * 商品盘点状态（盘盈、盘平、盘亏）
     */
    private String inventoryCheckStatus;

    /**
     * 商品盘点数量（大）
     */
    private Integer inventoryCheckLargeNum;

    /**
     * 商品盘点数量（小）
     */
    private Integer inventoryCheckSmallNum;
}
