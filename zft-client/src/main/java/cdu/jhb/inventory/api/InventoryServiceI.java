package cdu.jhb.inventory.api;

import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.inventory.data.dto.InventoryInfoDTO;
import cdu.jhb.inventory.data.request.InventoryListQuery;
import cdu.jhb.inventory.data.dto.SupplierDTO;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:17
* @version 1.0
*/
public interface InventoryServiceI {
    /**
     * 获取库存商品列表
     * @param query
     * @return
     */
    List<InventoryInfoDTO> getInventoryList(InventoryListQuery query);

    /**
     * 通过ID获取商品信息
     * @param id
     * @return
     */
    CommodityDTO selectById(Long id);

    /**
     * 获取供应商列表
     * @return
     */
    List<SupplierDTO> getSupplierList();
}
