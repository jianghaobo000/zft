package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.InventoryInDetail;
import cdu.jhb.domain.inventory.InventoryOutDetail;
import cdu.jhb.domain.inventory.InventoryOutInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryOutGateway;
import cdu.jhb.inventory.database.InventoryOutDetailMapper;
import cdu.jhb.inventory.database.InventoryOutMapper;
import cdu.jhb.inventory.database.dataobject.InventoryInDetailDO;
import cdu.jhb.inventory.database.dataobject.InventoryOutDetailDO;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class InventoryOutGatewayImpl implements InventoryOutGateway {

    private final InventoryOutMapper inventoryOutMapper;

    private final InventoryOutDetailMapper inventoryOutDetailMapper;

    /**
     * 获取出库单列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryOutInfo> getInventoryOutList(InventoryOutListQuery query) {
        query.setInventory_out_tenant_id(RedisUtil.getLocalTenantId());
        return inventoryOutMapper.getInventoryOutList(query);
    }

    /**
     * 获取出库单主表信息
     * @param id
     * @return
     */
    @Override
    public InventoryOutInfo selectOutInfo(Long id) {
        return inventoryOutMapper.getInventoryOutInfo(id,RedisUtil.getLocalTenantId());
    }

    /**
     * 获取出库单明细列表
     * @param id
     * @return
     */
    @Override
    public List<InventoryOutDetail> selectOutDetail(Long id) {
        QueryWrapper<InventoryOutDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryOutDetailDO::getInventory_out_id,id);
        List<InventoryOutDetailDO> outDetailDOList = inventoryOutDetailMapper.selectList(queryWrapper);
        return Convert.listConvert(outDetailDOList, InventoryOutDetail.class);
    }
}
