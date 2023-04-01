package cdu.jhb.inventory.database;

import cdu.jhb.inventory.database.dataobject.InventoryInDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:28
* @version 1.0
*/
@Mapper
public interface InventoryInMapper extends BaseMapper<InventoryInDO> {
}
