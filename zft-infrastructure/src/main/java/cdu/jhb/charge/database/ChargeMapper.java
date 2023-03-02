package cdu.jhb.charge.database;

import cdu.jhb.charge.database.dataobject.ChargeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:16
* @version 1.0
*/
@Mapper
public interface ChargeMapper extends BaseMapper<ChargeDO> {
}
