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
import cdu.jhb.domain.manage.gateway.ManageGateway;
import cdu.jhb.manage.data.response.StaffInfoResponse;
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
}
