package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.InventoryInDetail;
import cdu.jhb.domain.inventory.InventoryInInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.inventory.database.InventoryInDetailMapper;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import cdu.jhb.inventory.database.dataobject.InventoryInDetailDO;
import cdu.jhb.inventory.dto.data.*;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
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

    /**
     * 获取入库单信息列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryInInfo> getInventoryInList(InventoryInListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryInTenantId(RedisUtil.getLocalTenantId());
        return inventoryInMapper.getInventoryInList(query);
    }

    /**
     * 获取入库单主表信息
     * @param id
     * @return
     */
    @Override
    public InventoryInInfo selectInInfo(Long id) {
        return inventoryInMapper.getInventoryInInfo(id,RedisUtil.getLocalTenantId());
    }

    /**
     * 根据主表ID获取入库单明细表列表
     * @param id
     * @return
     */
    @Override
    public List<InventoryInDetail> selectInDetail(Long id) {
        QueryWrapper<InventoryInDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryInDetailDO::getInventoryInId,id);
        List<InventoryInDetailDO> inDetailDOList = inventoryInDetailMapper.selectList(queryWrapper);
        return Convert.listConvert(inDetailDOList,InventoryInDetail.class);
    }

}
