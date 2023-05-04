package cdu.jhb.patient.database;

import cdu.jhb.patient.data.response.VisitListResponse;
import cdu.jhb.patient.database.dataobject.PatientDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 20:58
* @version 1.0
*/
@Mapper
public interface PatientMapper extends BaseMapper<PatientDO> {

    /**
     * 根据时间获取就诊列表
     * @param beginTime
     * @param endTime
     * @return
     */
    List<VisitListResponse> getVisitList(@Param("beginTime")String beginTime,@Param("endTime")String endTime);

    /**
     * 获取该患者历史就诊信息
     * @param pid
     * @return
     */
    List<VisitListResponse> getPatientVisitHistory(@Param("pid")Long pid);

}
