package cdu.jhb.manage.service;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.manage.api.ManageServiceI;
import cdu.jhb.manage.command.ManageModExe;
import cdu.jhb.manage.command.ManageQryExe;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 管理服务层实现
* @author jhb
* @date 2023/04/28 23:10
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class ManageServiceImpl implements ManageServiceI {

    private final ManageModExe manageModExe;

    private final ManageQryExe manageQryExe;

    /**
     * 获取员工列表
     * @param name
     * @return
     */
    @Override
    public List<EmployeeDTO> getStaffList(String name) {
        return manageQryExe.getStaffList(name);
    }

    /**
     * 保存或修改员工信息
     * @param staffInfoRequest
     * @return
     */
    @Override
    public Boolean saveStaff(StaffInfoRequest staffInfoRequest) {
        return manageModExe.saveStaff(staffInfoRequest);
    }

    /**
     * 删除员工
     * @param eid
     * @return
     */
    @Override
    public Boolean deleteStaff(Long eid,Long aid,Long pid) {
        return manageModExe.deleteStaff(eid,aid,pid);
    }


    /**
     * 通过ID获取员工信息
     * @param id
     * @return
     */
    @Override
    public StaffInfoResponse getStaffInfo(Long id) {
        return manageQryExe.getStaffInfo(id);
    }
}
