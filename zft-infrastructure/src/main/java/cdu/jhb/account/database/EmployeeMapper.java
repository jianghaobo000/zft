package cdu.jhb.account.database;

import cdu.jhb.account.database.dataobject.EmployeeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:20
* @version 1.0
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeDO> {
}
