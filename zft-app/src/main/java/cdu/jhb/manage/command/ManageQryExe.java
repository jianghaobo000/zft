package cdu.jhb.manage.command;

import cdu.jhb.account.data.dto.AccountDTO;
import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.data.dto.PracticeDTO;
import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.EmployeeMapper;
import cdu.jhb.account.database.PracticeMapper;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.Practice;
import cdu.jhb.domain.manage.Department;
import cdu.jhb.domain.manage.Equipment;
import cdu.jhb.domain.manage.gateway.ManageGateway;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.dto.EquipmentDTO;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import cdu.jhb.manage.database.EquipmentMapper;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:11
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class ManageQryExe {

    private final ManageGateway manageGateway;

    private final EmployeeMapper employeeMapper;

    private final AccountMapper accountMapper;

    private final PracticeMapper practiceMapper;

    private final EquipmentMapper equipmentMapper;

    /**
     * 获取科室列表
     * @param name
     * @return
     */
    public List<DepartmentDTO> getDepartmentList(String name) {
        List<Department> departmentList = manageGateway.getDepartmentList(name);
        return Convert.listConvert(departmentList,DepartmentDTO.class);
    }

    /**
     * 获取科室下的成员列表
     * @param did
     * @return
     */
    public List<EmployeeDTO> getDepartmentEmployeeList(Long did) {
        List<Employee> employeeList = manageGateway.getDepartmentEmployeeList(did);
        return Convert.listConvert(employeeList,EmployeeDTO.class);
    }

    /**
     * 获取员工列表
     * @param name
     * @return
     */
    public List<EmployeeDTO> getStaffList(String name) {
        List<Employee> employeeList = manageGateway.getStaffList(name);
        return Convert.listConvert(employeeList,EmployeeDTO.class);
    }

    /**
     * 通过ID获取员工信息
     * @param id
     * @return
     */
    public StaffInfoResponse getStaffInfo(Long id) {
        Employee employee = Convert.entityConvert(employeeMapper.selectById(id),Employee.class);
        Account account = Convert.entityConvert(accountMapper.selectById(employee.getEmployeeAccountId()),Account.class);
        Practice practice = Convert.entityConvert(practiceMapper.selectById(employee.getEmployeePracticeId()),Practice.class);
        return new StaffInfoResponse(
                Convert.entityConvert(employee,EmployeeDTO.class),
                Convert.entityConvert(account, AccountDTO.class),
                Convert.entityConvert(practice, PracticeDTO.class)
        );
    }

    /**
     * 获取设备列表
     * @param name
     * @return
     */
    public List<EquipmentDTO> getEquipmentList(String name) {
        List<Equipment> equipment = manageGateway.getEquipmentList(name);
        return Convert.listConvert(equipment,EquipmentDTO.class);
    }
}
