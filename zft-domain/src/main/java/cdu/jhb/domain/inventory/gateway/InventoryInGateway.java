package cdu.jhb.domain.inventory.gateway;

import cdu.jhb.domain.inventory.InventoryInDetail;
import cdu.jhb.domain.inventory.InventoryInInfo;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:19
* @version 1.0
*/
public interface InventoryInGateway {

    /**
     * 获取入库单信息列表
     * @param query
     * @return
     */
    List<InventoryInInfo> getInventoryInList(InventoryInListQuery query);

    /**
     * 获取入库单主表信息
     * @param id
     * @return
     */
    InventoryInInfo selectInInfo(Long id);

    /**
     * 根据主表ID获取入库单明细表列表
     * @param id
     * @return
     */
    List<InventoryInDetail> selectInDetail(Long id);
}
