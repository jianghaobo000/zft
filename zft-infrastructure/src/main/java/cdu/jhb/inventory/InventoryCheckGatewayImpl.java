package cdu.jhb.inventory;

import cdu.jhb.domain.inventory.InventoryCheckDetail;
import cdu.jhb.domain.inventory.InventoryCheckInfo;
import cdu.jhb.domain.inventory.InventoryOutDetail;
import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.database.InventoryCheckDetailMapper;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.database.dataobject.InventoryCheckDetailDO;
import cdu.jhb.inventory.database.dataobject.InventoryOutDetailDO;
import cdu.jhb.inventory.dto.data.InventoryCheckInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryCheckListQuery;
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
public class InventoryCheckGatewayImpl implements InventoryCheckGateway {

    private final InventoryCheckMapper inventoryCheckMapper;

    private final InventoryCheckDetailMapper inventoryCheckDetailMapper;

    /**
     * 获取盘点单列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryCheckInfo> getInventoryCheckList(InventoryCheckListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryCheckTenantId(RedisUtil.getLocalTenantId());
        return inventoryCheckMapper.getInventoryCheckList(query);
    }

    /**
     * 查询盘点单主表
     * @param id
     * @return
     */
    @Override
    public InventoryCheckInfo selectCheckInfo(Long id) {
        return inventoryCheckMapper.getInventoryCheckInfo(id,RedisUtil.getLocalTenantId());
    }

    /**
     * 查询盘点单明细列表
     * @param id
     * @return
     */
    @Override
    public List<InventoryCheckDetail> selectCheckDetail(Long id) {
        QueryWrapper<InventoryCheckDetailDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(InventoryCheckDetailDO::getInventoryCheckId,id);
        List<InventoryCheckDetailDO> checkDetailDOList = inventoryCheckDetailMapper.selectList(queryWrapper);
        return Convert.listConvert(checkDetailDOList, InventoryCheckDetail.class);
    }
}
