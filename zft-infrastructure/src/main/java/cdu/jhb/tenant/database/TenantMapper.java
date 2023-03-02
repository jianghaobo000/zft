package cdu.jhb.tenant.database;

import cdu.jhb.tenant.database.dataobject.TenantDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/3/1 20:21
* @version 1.0
*/
@Mapper
public interface TenantMapper extends BaseMapper<TenantDO> {
}
