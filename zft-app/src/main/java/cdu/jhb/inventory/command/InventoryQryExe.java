package cdu.jhb.inventory.command;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.database.dataobject.CommodityDO;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.InventoryGatewayImpl;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @description: 库存查询器
* @author jhb
* @date 2023/04/01 21:18
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryQryExe {

    private final InventoryGateway inventoryGateway;

    private final CommodityMapper commodityMapper;

    /**
     * 通过条件获取商品列表
     * @param query
     * @return
     */
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query){
        return inventoryGateway.getInventoryList(query);
    }

    /**
     * 通过Id查询商品
     * @param id
     * @return
     */
    public Commodity selectById(Long id){
        CommodityDO commodityDO = commodityMapper.selectById(id);
        return DozerBeanMapperBuilder.buildDefault().map(commodityDO,Commodity.class);
    }
}
