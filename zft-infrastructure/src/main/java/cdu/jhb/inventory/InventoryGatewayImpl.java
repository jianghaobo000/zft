package cdu.jhb.inventory;

import cdu.jhb.common.Constant;
import cdu.jhb.domain.inventory.InventoryInfo;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.inventory.data.dto.InventoryInfoDTO;
import cdu.jhb.inventory.data.response.InventoryListResponse;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.data.request.InventoryListQuery;
import cdu.jhb.util.Calculate;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:20
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class InventoryGatewayImpl implements InventoryGateway {

    private final InventoryMapper inventoryMapper;

    /**
     * 获取药品物资列表
     * @param query
     * @return
     */
    @Override
    public List<InventoryInfo> getInventoryList(InventoryListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryTenantId(RedisUtil.getLocalTenantId());
        return inventoryMapper.getInventoryList(query);
    }

    /**
     * 获取药品物资列表分页
     * @param query
     * @return
     */
    @Override
    public InventoryListResponse getInventoryListByPage(InventoryListQuery query) {
        // 从redis中取出当前登录用户的租户ID
        query.setInventoryTenantId(RedisUtil.getLocalTenantId());
        List<InventoryInfo> inventoryInfoList = inventoryMapper.getInventoryList(query);
        // 分页
        Map<String,Integer> pageMap = Calculate.assemblyPagination(query.getPageIndex(),query.getPageSize(),inventoryInfoList.size());
        InventoryListResponse inventoryListResponse = new InventoryListResponse();
        inventoryListResponse.setTotal(inventoryInfoList.size());
        inventoryListResponse.setMaxPage(inventoryInfoList.size()/query.getPageSize() + 1);
        inventoryInfoList = inventoryInfoList.subList(pageMap.get(Constant.START_INDEX),pageMap.get(Constant.END_INDEX));
        inventoryListResponse.setInfoDTOList(Convert.listConvert(inventoryInfoList, InventoryInfoDTO.class));
        return inventoryListResponse;
    }
}
