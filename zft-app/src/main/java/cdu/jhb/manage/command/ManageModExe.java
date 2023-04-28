package cdu.jhb.manage.command;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.EmployeeMapper;
import cdu.jhb.account.database.PracticeMapper;
import cdu.jhb.common.DictException;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.Practice;
import cdu.jhb.domain.manage.gateway.ManageGateway;
import cdu.jhb.manage.data.request.StaffInfoRequest;
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

    /**
     * 保存或修改员工信息
     * @param staffInfoRequest
     * @return
     */
    public Boolean saveStaff(StaffInfoRequest staffInfoRequest) {
        // 转换拼音
        staffInfoRequest.getEmployeeDTO().setEmployeePinYin(PinYinConvert.getAllPinYinAndHeadChar(staffInfoRequest.getEmployeeDTO().getEmployeeName()));
        // 转化内部为实体
        Employee employee = Convert.entityConvert(staffInfoRequest.getAccountDTO(), Employee.class);
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
        return true;
    }
}
