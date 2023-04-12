package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.inventory.database.InventoryInDetailMapper;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import cdu.jhb.inventory.database.dataobject.InventoryInDetailDO;
import cdu.jhb.inventory.dto.data.*;
import cdu.jhb.util.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:20
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryInGatewayImpl implements InventoryInGateway {

    private final InventoryInMapper inventoryInMapper;

    private final InventoryInDetailMapper inventoryInDetailMapper;

    @Override
    public List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query) {
        Jedis jedis = new Jedis();
        query.setInventory_in_tenant_id(Long.valueOf(jedis.get("tenantId")));
        return inventoryInMapper.getInventoryInList(query);
    }

    @Override
    public InventoryInInfoDTO selectInDetail(Long id) {
        InventoryInInfoDTO inventoryInInfoDTO = inventoryInMapper.getInventoryInInfo(id,Long.valueOf(new Jedis().get("tenantId")));
        QueryWrapper<InventoryInDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryInDetailDO::getInventory_in_id,id);
        List<InventoryInDetailDO> inDetailDOList = inventoryInDetailMapper.selectList(queryWrapper);
        List<InventoryInDetailDTO> inDetailDTOList = Convert.listConvert(inDetailDOList,InventoryInDetailDTO.class);
        inventoryInInfoDTO.setInDetailDTOList(inDetailDTOList);
        return inventoryInInfoDTO;
    }
}
