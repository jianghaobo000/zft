package cdu.jhb.manage.command;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.EmployeeMapper;
import cdu.jhb.account.database.PracticeMapper;
import cdu.jhb.common.DictException;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.Practice;
import cdu.jhb.domain.charge.PayDict;
import cdu.jhb.domain.manage.Department;
import cdu.jhb.domain.manage.DiagnosticCharge;
import cdu.jhb.domain.manage.Equipment;
import cdu.jhb.domain.manage.PaySet;
import cdu.jhb.domain.manage.gateway.ManageGateway;
import cdu.jhb.manage.data.dto.DiagnosticChargeDTO;
import cdu.jhb.manage.data.dto.EquipmentDTO;
import cdu.jhb.manage.data.request.DepartmentInfoRequest;
import cdu.jhb.manage.data.request.PaySetInfoRequest;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.database.DiagnosticChargeMapper;
import cdu.jhb.manage.database.EquipmentMapper;
import cdu.jhb.util.Convert;
import cdu.jhb.util.PinYinConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:11
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class ManageModExe {

    private final ManageGateway manageGateway;

    private final AccountMapper accountMapper;

    private final PracticeMapper practiceMapper;

    private final EmployeeMapper employeeMapper;

    private final EquipmentMapper equipmentMapper;

    private final DiagnosticChargeMapper diagnosticChargeMapper;


    /**
     * 保存或修改科室信息
     * @param infoRequest
     * @return
     */
    public Boolean saveDepartment(DepartmentInfoRequest infoRequest) {
        // 转换拼音码
        infoRequest.getDepartmentAdd().setDepartmentPinYin(PinYinConvert.getAllPinYinAndHeadChar(infoRequest.getDepartmentAdd().getDepartmentName()));
        // 分离请求参数
        Department department = Convert.entityConvert(infoRequest.getDepartmentAdd(),Department.class);
        List<Employee> employeeList = Convert.listConvert(infoRequest.getDepartmentEmployeeList(),Employee.class);
        return manageGateway.saveDepartment(department,employeeList);
    }

    /**
     * 删除科室
     * @param did
     * @return
     */
    public Boolean deleteDepartmentById(Long did) {
        return manageGateway.deleteDepartmentById(did);
    }

    /**
     * 保存或修改员工信息
     * @param staffInfoRequest
     * @return
     */
    public Boolean saveStaff(StaffInfoRequest staffInfoRequest) {
        // 转换拼音
        staffInfoRequest.getEmployeeDTO().setEmployeePinYin(PinYinConvert.getAllPinYinAndHeadChar(staffInfoRequest.getEmployeeDTO().getEmployeeName()));
        // 转化内部为实体
        Employee employee = Convert.entityConvert(staffInfoRequest.getEmployeeDTO(), Employee.class);
        Account account = Convert.entityConvert(staffInfoRequest.getAccountDTO(),Account.class);
        Practice practice = Convert.entityConvert(staffInfoRequest.getPracticeDTO(),Practice.class);
        return manageGateway.saveStaff(employee,account,practice);
    }

    /**
     * 删除员工(添加事务，因为是关联数据，一旦失败全部回滚)
     * @param eid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteStaff(Long eid,Long aid,Long pid) {
        if(employeeMapper.deleteById(eid)!=1){
            throw new RuntimeException(DictException.DELETE_EMPLOYEE_FAILED);
        }
        if(accountMapper.deleteById(aid)!=1){
            throw new RuntimeException(DictException.DELETE_ACCOUNT_FAILED);
        }
        if(practiceMapper.deleteById(pid)!=1){
            throw new RuntimeException(DictException.DELETE_PRACTICE_FAILED);
        }
        if(!manageGateway.deleteDiagnosticChargeByEid(eid)){
            throw new RuntimeException(DictException.DELETE_DIAGNOSTIC_CHARGE_FAILED);
        }
        return true;
    }

    /**
     * 保存或修改设备信息
     * @param equipmentDTO
     * @return
     */
    public Boolean saveEquipment(EquipmentDTO equipmentDTO) {
        // 添加拼音码
        equipmentDTO.setEquipmentPinYin(PinYinConvert.getAllPinYinAndHeadChar(equipmentDTO.getEquipmentName()));
        // 转化实体
        Equipment equipment = Convert.entityConvert(equipmentDTO,Equipment.class);
        return manageGateway.saveEquipment(equipment);
    }


    /**
     * 删除设备信息
     * @param eid
     * @return
     */
    public Boolean deleteEquipmentById(Long eid) {
        if(equipmentMapper.deleteById(eid)!=1){
            throw new RuntimeException(DictException.DELETE_EQUIPMENT_FAILED);
        }
        return true;
    }

    /**
     * 保存挂号费设置
     * @param diagnosticChargeDTOList
     * @return
     */
    public Boolean saveDiagnosticCharge(List<DiagnosticChargeDTO> diagnosticChargeDTOList) {
        List<DiagnosticCharge> diagnosticChargeList = Convert.listConvert(diagnosticChargeDTOList,DiagnosticCharge.class);
        return manageGateway.saveDiagnosticCharge(diagnosticChargeList);
    }

    /**
     * 保存支付设置
     * @return
     */
    public Boolean savePaySet(PaySetInfoRequest request){
        PaySet paySet = Convert.entityConvert(request.getPaySetDTO(),PaySet.class);
        List<PayDict> payDictList = Convert.listConvert(request.getPayDictDTOList(),PayDict.class);
        return manageGateway.savePaySet(paySet,payDictList);
    }
}
