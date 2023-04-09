package cdu.jhb.inventory.service;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.inventory.Supplier;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.InventoryQryExe;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import cdu.jhb.inventory.dto.data.SupplierDTO;
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
     * 通过ID获取商品信息
     * @param id
     * @return
     */
    @Override
    public CommodityDTO selectById(Long id) {
        Commodity commodity = inventoryQryExe.selectById(id);
        return DozerBeanMapperBuilder.buildDefault().map(commodity,CommodityDTO.class);
    }

    @Override
    public List<SupplierDTO> getSupplierList() {
        return inventoryQryExe.getSupplierList();
    }
}
