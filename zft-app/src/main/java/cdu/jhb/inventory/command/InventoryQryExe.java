package cdu.jhb.inventory.command;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.database.dataobject.CommodityDO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.inventory.*;
import cdu.jhb.domain.inventory.gateway.InventoryCheckGateway;
import cdu.jhb.domain.inventory.gateway.InventoryGateway;
import cdu.jhb.domain.inventory.gateway.InventoryInGateway;
import cdu.jhb.domain.inventory.gateway.InventoryOutGateway;
import cdu.jhb.inventory.database.InventoryCheckMapper;
import cdu.jhb.inventory.database.InventoryInMapper;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.InventoryOutMapper;
import cdu.jhb.inventory.database.dataobject.SupplierDO;
import cdu.jhb.inventory.dto.data.*;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

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

    private final InventoryInGateway inventoryInGateway;

    private final InventoryOutGateway inventoryOutGateway;

    private final InventoryCheckGateway inventoryCheckGateway;

    private final InventoryInMapper inventoryInMapper;

    private final InventoryOutMapper inventoryOutMapper;

    private final InventoryCheckMapper inventoryCheckMapper;

    private final InventoryMapper inventoryMapper;

    private final CommodityMapper commodityMapper;

    /**
     * 通过条件获取商品列表
     * @param query
     * @return
     */
    public List<InventoryInfoDTO> getInventoryList(InventoryListQuery query){
        List<InventoryInfo> inventoryInfoList = inventoryGateway.getInventoryList(query);
        return Convert.listConvert(inventoryInfoList,InventoryInfoDTO.class);
    }

    /**
     * 通过Id查询商品
     * @param id
     * @return
     */
    public Commodity selectById(Long id){
        CommodityDO commodityDO = commodityMapper.selectById(id);
        return Convert.entityConvert(commodityDO,Commodity.class);
    }

    /**
     * 查询入库单列表
     * @return
     */
    public List<InventoryInInfoDTO> getInventoryInList(InventoryInListQuery query){
        List<InventoryInInfo> inventoryInInfoList = inventoryInGateway.getInventoryInList(query);
        return Convert.listConvert(inventoryInInfoList,InventoryInInfoDTO.class);
    }

    /**
     * 查询入库单明细
     * @param id
     * @return
     */
    public InventoryInInfoDTO selectInDetailById(Long id) {
        // 查询入库单主表实体
        InventoryInInfo inventoryInInfo = inventoryInGateway.selectInInfo(id);
        // 转化DTO数据传输对象
        InventoryInInfoDTO inventoryInInfoDTO = Convert.entityConvert(inventoryInInfo,InventoryInInfoDTO.class);
        // 查询入库单明细表实体
        List<InventoryInDetail> inDetailList = inventoryInGateway.selectInDetail(id);
        // 转化DTO数据传输对象
        List<InventoryInDetailDTO> inDetailDTOList = Convert.listConvert(inDetailList,InventoryInDetailDTO.class);
        // 组装返回数据
        inventoryInInfoDTO.setInventory_in_detail_list(inDetailDTOList);
        return inventoryInInfoDTO;
    }

    /**
     * 查询出库单列表
     * @return
     */
    public List<InventoryOutInfoDTO> getInventoryOutList(InventoryOutListQuery query){
        List<InventoryOutInfo> inventoryOutInfoList = inventoryOutGateway.getInventoryOutList(query);
        return Convert.listConvert(inventoryOutInfoList,InventoryOutInfoDTO.class);
    }

    /**
     * 查询盘点单列表
     * @return
     */
    public List<InventoryCheckInfoDTO> getInventoryCheckList(InventoryCheckListQuery query){
        List<InventoryCheckInfo> inventoryCheckInfoList = inventoryCheckGateway.getInventoryCheckList(query);
        return Convert.listConvert(inventoryCheckInfoList,InventoryCheckInfoDTO.class);
    }

    /**
     * 查询供应商列表
     * @return
     */
    public List<SupplierDTO> getSupplierList(){
        Jedis jedis = new Jedis();
        Long tenantId = Long.valueOf(jedis.get("tenantId"));
        List<SupplierDO> supplierList = inventoryMapper.getSupplierList(tenantId);
        return Convert.listConvert(supplierList,SupplierDTO.class);
    }
}
