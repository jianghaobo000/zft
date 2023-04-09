package cdu.jhb.inventory.database;

import cdu.jhb.inventory.database.dataobject.InventoryCheckDO;
import cdu.jhb.inventory.database.dataobject.InventoryDO;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import cdu.jhb.inventory.dto.data.SupplierDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:21
* @version 1.0
*/
@Mapper
public interface InventoryCheckMapper extends BaseMapper<InventoryCheckDO> {


}
