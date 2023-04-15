package cdu.jhb.inventory.database;

import cdu.jhb.domain.inventory.InventoryOutInfo;
import cdu.jhb.inventory.database.dataobject.InventoryOutDO;
import cdu.jhb.inventory.dto.data.InventoryOutInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryOutListQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:29
* @version 1.0
*/
@Mapper
public interface InventoryOutMapper extends BaseMapper<InventoryOutDO> {

    /**
     * 获取出库单列表
     * @param query
     * @return
     */
    List<InventoryOutInfo> getInventoryOutList(@Param("param") InventoryOutListQuery query);

}
