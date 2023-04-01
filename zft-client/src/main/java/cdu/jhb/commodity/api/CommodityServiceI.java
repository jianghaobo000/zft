package cdu.jhb.commodity.api;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;

import java.util.List;

/**
* @description: 商品服务层接口
* @author jhb
* @date 2023/03/31 18:10
* @version 1.0
*/
public interface CommodityServiceI {

    /**
     * 新增品项
     * @param commodityDTO
     * @return
     */
    int addCommodity(CommodityDTO commodityDTO);

}
