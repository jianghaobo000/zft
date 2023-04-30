package cdu.jhb.manage.database;

import cdu.jhb.manage.database.dataobject.DepartmentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/04/30 20:49
* @version 1.0
*/
@Mapper
public interface DepartmentMapper extends BaseMapper<DepartmentDO> {
}
