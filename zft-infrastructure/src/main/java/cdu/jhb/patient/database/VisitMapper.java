package cdu.jhb.patient.database;

import cdu.jhb.patient.database.dataobject.VisitDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 20:59
* @version 1.0
*/
@Mapper
public interface VisitMapper extends BaseMapper<VisitDO> {
}
