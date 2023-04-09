package cdu.jhb.inventory.database;

import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import cdu.jhb.inventory.dto.data.InventoryInDTO;
import cdu.jhb.inventory.dto.data.InventoryInInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryInListQuery;
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

    List<InventoryInInfoDTO> getInventoryInList(@Param("param") InventoryInListQuery query);
}
