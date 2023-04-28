package cdu.jhb.manage;

import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.EmployeeMapper;
import cdu.jhb.account.database.PracticeMapper;
import cdu.jhb.account.database.dataobject.AccountDO;
import cdu.jhb.account.database.dataobject.EmployeeDO;
import cdu.jhb.account.database.dataobject.PracticeDO;
import cdu.jhb.common.Constant;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.Practice;
import cdu.jhb.domain.manage.gateway.ManageGateway;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:13
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class ManegeGatewayImpl implements ManageGateway {

    private final EmployeeMapper employeeMapper;

    private final AccountMapper accountMapper;

    private final PracticeMapper practiceMapper;

    /**
     * 获取员工列表(可以通过姓名、拼音模糊查询)
     * @param name
     * @return
     */
    @Override
    public List<Employee> getStaffList(String name) {
        QueryWrapper<EmployeeDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(EmployeeDO::getEmployeeName,name)
                .or()
                .like(EmployeeDO::getEmployeePinYin,name)
                .eq(EmployeeDO::getEmployeeTenantId, RedisUtil.getLocalTenantId());
        List<EmployeeDO> employeeDOList = employeeMapper.selectList(queryWrapper);
        return Convert.listConvert(employeeDOList,Employee.class);
    }

    /**
     * 新增或修改员工信息
     * @param employee
     * @param account
     * @param practice
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveStaff(Employee employee, Account account, Practice practice) {
        // 将实体转化为表对象
        EmployeeDO employeeDO = Convert.entityConvert(employee,EmployeeDO.class);
        AccountDO accountDO = Convert.entityConvert(account,AccountDO.class);
        PracticeDO practiceDO = Convert.entityConvert(practice,PracticeDO.class);

        // 为空则新增，反之修改
        if(employeeDO.getEmployeeId()==null){
            // 新增
            // 设置租户信息
            Long tenantId = RedisUtil.getLocalTenantId();
            employeeDO.setEmployeeTenantId(tenantId);
            accountDO.setAccountTenantId(tenantId);
            practiceDO.setPracticeTenantId(tenantId);
            // 新增账号信息
            accountMapper.insert(accountDO);
            // 新增执业信息
            practiceMapper.insert(practiceDO);
            // 设置关联键
            employeeDO.setEmployeeAccountId(accountDO.getAccountId());
            employeeDO.setEmployeePracticeId(practiceDO.getPracticeId());
            employeeMapper.insert(employeeDO);
        }else{
            // 修改
            accountMapper.updateById(accountDO);
            practiceMapper.updateById(practiceDO);
            employeeMapper.updateById(employeeDO);
        }
        return true;
    }


}
