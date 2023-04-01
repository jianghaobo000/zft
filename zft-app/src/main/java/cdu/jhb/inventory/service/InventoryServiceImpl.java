package cdu.jhb.inventory.service;

import cdu.jhb.domain.inventory.Inventory;
import cdu.jhb.domain.inventory.InventoryInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.command.InventoryModExe;
import cdu.jhb.inventory.command.query.InventoryQryExe;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query) {
        return inventoryQryExe.getInventoryList(query);
    }
}
