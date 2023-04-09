package cdu.jhb.inventory.database;

import cdu.jhb.inventory.database.dataobject.InventoryCheckDO;
import cdu.jhb.inventory.database.dataobject.InventoryCheckDetailDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:21
* @version 1.0
*/
@Mapper
public interface InventoryCheckDetailMapper extends BaseMapper<InventoryCheckDetailDO> {


}
