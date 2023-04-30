package cdu.jhb.manage.api;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.request.DepartmentInfoRequest;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;

import java.util.List;

/**
* @description: 管理服务层接口
* @author jhb
* @date 2023/04/28 23:09
* @version 1.0
*/
public interface ManageServiceI {

    /**
     * 获取科室列表
     * @param name
     * @return
     */
    List<DepartmentDTO> getDepartmentList(String name);

    /**
     * 保存或修改科室信息
     * @param departmentInfoRequest
     * @return
     */
    Boolean saveDepartment(DepartmentInfoRequest departmentInfoRequest);

    /**
     * 获取该科室的成员列表
     * @return
     */
    List<EmployeeDTO> getDepartmentEmployeeList(Long did);

    /**
     * 删除科室
     * @param did
     * @return
     */
    Boolean deleteDepartmentById(Long did);

    /**
     * 获取员工列表
     * @param name
     * @return
     */
    List<EmployeeDTO> getStaffList(String name);

    /**
     * 保存或修改员工信息
     * @param staffInfoRequest
     * @return
     */
    Boolean saveStaff(StaffInfoRequest staffInfoRequest);

    /**
     * 删除员工信息
     * @param eid
     * @return
     */
    Boolean deleteStaff(Long eid,Long aid,Long pid);

    /**
     * 通过ID获取员工信息
     * @param id
     * @return
     */
    StaffInfoResponse getStaffInfo(Long id);
}
