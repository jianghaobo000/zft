package cdu.jhb.account.database;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.database.dataobject.EmployeeDO;
import cdu.jhb.domain.account.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:20
* @version 1.0
*/
@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeDO> {

    /**
     * 获取科室下的成员列表
     * @param did
     * @return
     */
    List<EmployeeDO> getDepartmentEmployeeList(@Param("did") Long did,@Param("tenantId")Long tenantId);

    /**
     * 获取成员列表
     * @param tenantId
     * @return
     */
    List<EmployeeDTO> getEmployeeList(@Param("tenantId")Long tenantId);

    /**
     * 获取库存模块成员列表
     * @param tenantId
     * @return
     */
    List<EmployeeDTO> getInventoryEmployeeList(@Param("tenantId")Long tenantId);

    /**
     * 获取没有分配科室的成员列表
     * @param tenantId
     * @return
     */
    List<EmployeeDTO> getNoDepartEmployeeList(@Param("tenantId")Long tenantId);

    /**
     * 设置成员的科室ID
     * @return
     */
    Boolean setDepartmentId(@Param("eids") List<Long> eids,@Param("did") Long did,@Param("tenantId")Long tenantId);

    /**
     * 设置成员的科室ID为空
     * @return
     */
    Boolean setDepartmentIdNull(@Param("eids") List<Long> eids,@Param("tenantId")Long tenantId);
}
