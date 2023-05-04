package cdu.jhb.prescription.database;

import cdu.jhb.prescription.database.dataobject.PrescriptionDetailDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:00
* @version 1.0
*/
@Mapper
public interface PrescriptionDetailMapper extends BaseMapper<PrescriptionDetailDO> {
}
