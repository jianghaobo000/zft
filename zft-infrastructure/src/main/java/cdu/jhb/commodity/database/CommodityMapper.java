package cdu.jhb.commodity.database;

import cdu.jhb.commodity.database.dataobject.CommodityDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: 商品Mapper
* @author jhb
* @date 2023/03/31 18:24
* @version 1.0
*/
@Mapper
public interface CommodityMapper extends BaseMapper<CommodityDO> {
}
