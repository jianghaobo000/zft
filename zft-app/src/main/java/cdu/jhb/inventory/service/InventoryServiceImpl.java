package cdu.jhb.inventory.service;

import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.data.dto.InventoryInfoDTO;
import cdu.jhb.inventory.data.request.InventoryListQuery;
import cdu.jhb.inventory.data.dto.SupplierDTO;
import cdu.jhb.inventory.data.response.InventoryListResponse;
import cdu.jhb.util.Convert;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 库存服务层
* @author jhb
* @date 2023/04/01 21:16
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryServiceI {

    private final InventoryModExe inventoryModExe;

    private final InventoryQryExe inventoryQryExe;

    /**
     * 获取商品列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query) {
        return inventoryQryExe.getInventoryList(query);
    }

    /**
     * 分页获取商品列表
     * @param query
     * @return
     */
    @Override
    public InventoryListResponse getInventoryListByPage(InventoryListQuery query) {
        return inventoryQryExe.getInventoryListByPage(query);
    }

    /**
     * 通过ID获取商品信息
     * @param id
     * @return
     */
    @Override
    public CommodityDTO selectById(Long id) {
        Commodity commodity = inventoryQryExe.selectById(id);
        return Convert.entityConvert(commodity,CommodityDTO.class);
    }

    @Override
    public List<SupplierDTO> getSupplierList() {
        return inventoryQryExe.getSupplierList();
    }
}
