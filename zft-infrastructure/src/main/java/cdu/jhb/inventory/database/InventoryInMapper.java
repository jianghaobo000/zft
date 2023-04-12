package cdu.jhb.inventory.database;

import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import cdu.jhb.inventory.database.dataobject.InventoryInDetailDO;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:28
* @version 1.0
*/
@Mapper
public interface InventoryInMapper extends BaseMapper<InventoryInDO> {

    /**
     * 获取入库单列表
     * @param query
     * @return
     */
    List<InventoryInInfoDTO> getInventoryInList(@Param("param") InventoryInListQuery query);

    /**
     * 获取入库单
     * @param id
     * @param tenantId
     * @return
     */
    InventoryInInfoDTO getInventoryInInfo(@Param("id")Long id,@Param("tenantId")Long tenantId);
}
