package cdu.jhb.manage.service;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.manage.api.ManageServiceI;
import cdu.jhb.manage.command.ManageModExe;
import cdu.jhb.manage.command.ManageQryExe;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.dto.DiagnosticChargeDTO;
import cdu.jhb.manage.data.dto.EquipmentDTO;
import cdu.jhb.manage.data.request.DepartmentInfoRequest;
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
     * 获取科室列表
     * @param name
     * @return
     */
    @Override
    public List<DepartmentDTO> getDepartmentList(String name) {
        return manageQryExe.getDepartmentList(name);
    }

    /**
     * 保存或修改科室信息
     * @param infoRequest
     * @return
     */
    @Override
    public Boolean saveDepartment(DepartmentInfoRequest infoRequest) {
        return manageModExe.saveDepartment(infoRequest);
    }

    /**
     * 获取该科室下的成员列表
     * @param did
     * @return
     */
    @Override
    public List<EmployeeDTO> getDepartmentEmployeeList(Long did) {
        return manageQryExe.getDepartmentEmployeeList(did);
    }

    /**
     * 删除科室
     * @param did
     * @return
     */
    @Override
    public Boolean deleteDepartmentById(Long did) {
        return manageModExe.deleteDepartmentById(did);
    }

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

    /**
     * 获取设备列表
     * @param name
     * @return
     */
    @Override
    public List<EquipmentDTO> getEquipmentList(String name) {
        return manageQryExe.getEquipmentList(name);
    }

    /**
     * 保存或修改设备信息
     * @param equipmentDTO
     * @return
     */
    @Override
    public Boolean saveEquipment(EquipmentDTO equipmentDTO) {
        return manageModExe.saveEquipment(equipmentDTO);
    }

    /**
     * 删除设备信息
     * @param eid
     * @return
     */
    @Override
    public Boolean deleteEquipmentById(Long eid) {
        return manageModExe.deleteEquipmentById(eid);
    }

    /**
     * 保存挂号费设置
     * @param diagnosticChargeDTOList
     * @return
     */
    @Override
    public Boolean saveDiagnosticCharge(List<DiagnosticChargeDTO> diagnosticChargeDTOList) {
        return manageModExe.saveDiagnosticCharge(diagnosticChargeDTOList);
    }

    /**
     * 获取挂号费设置
     * @return
     */
    @Override
    public List<DiagnosticChargeDTO> getDiagnosticChargeList() {
        return manageQryExe.getDiagnosticChargeList();
    }
}
