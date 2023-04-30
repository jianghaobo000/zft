package cdu.jhb.manage;

import cdu.jhb.account.data.dto.EmployeeDTO;
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
import cdu.jhb.domain.manage.Department;
import cdu.jhb.domain.manage.gateway.ManageGateway;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import cdu.jhb.manage.database.DepartmentMapper;
import cdu.jhb.manage.database.dataobject.DepartmentDO;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    private final DepartmentMapper departmentMapper;

    /**
     * 获取科室列表
     * @param name
     * @return
     */
    @Override
    public List<Department> getDepartmentList(String name) {
        QueryWrapper<DepartmentDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(DepartmentDO::getDepartmentName,name)
                .or()
                .like(DepartmentDO::getDepartmentPinYin,name)
                .eq(DepartmentDO::getDepartmentTenantId,RedisUtil.getLocalTenantId())
                .orderByDesc(DepartmentDO::getDepartmentId);
        List<DepartmentDO> departmentDOList = departmentMapper.selectList(queryWrapper);
        return Convert.listConvert(departmentDOList, Department.class);
    }

    /**
     * 获取科室下的成员列表
     * @param did
     * @return
     */
    @Override
    public List<Employee> getDepartmentEmployeeList(Long did) {
        List<EmployeeDO> employeeDOList = employeeMapper.getDepartmentEmployeeList(did,RedisUtil.getLocalTenantId());
        return Convert.listConvert(employeeDOList,Employee.class);
    }

    /**
     * 保存或修改科室信息
     * @param department
     * @param employeeList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveDepartment(Department department, List<Employee> employeeList) {
        // 转换数据库表对象
        DepartmentDO departmentDO = Convert.entityConvert(department,DepartmentDO.class);
        List<EmployeeDO> employeeDOList = Convert.listConvert(employeeList,EmployeeDO.class);

        // id为空为新增，不为空为修改
        if(departmentDO.getDepartmentId()==null){
            // 新增科室信息
            departmentDO.setDepartmentTenantId(RedisUtil.getLocalTenantId());
            departmentMapper.insert(departmentDO);
        }else{
            departmentMapper.updateById(departmentDO);
        }

        // 先搜索出该科室的科室成员
        List<EmployeeDO> existEmployeeDOList = employeeMapper.getDepartmentEmployeeList(departmentDO.getDepartmentId(),RedisUtil.getLocalTenantId());
        // 过滤出已经存在的ID集合
        List<Long> existIds = existEmployeeDOList.stream().map(EmployeeDO::getEmployeeId).collect(Collectors.toList());
        // 过滤出需要加入的ID集合
        List<Long> ids = employeeDOList.stream().map(EmployeeDO::getEmployeeId).collect(Collectors.toList());
        // 跟传过来的做比较，筛选出新增的和删除的
        // employeeDOList不存在于existIds中的即为新增科室的集合
        List<Long> addIds = ids.stream().filter(id -> !existIds.contains(id)).collect(Collectors.toList());
        // existEmployeeDOList不存在于ids中的即为删除科室的集合
        List<Long> delIds = existIds.stream().filter(existId -> !ids.contains(existId)).collect(Collectors.toList());

        if(addIds.size()>0){
            // 将科室ID赋值上去
            employeeMapper.setDepartmentId(addIds,departmentDO.getDepartmentId(),RedisUtil.getLocalTenantId());
        }
        if(delIds.size()>0){
            // 将科室ID置为空
            employeeMapper.setDepartmentIdNull(delIds,RedisUtil.getLocalTenantId());
        }

        return true;
    }

    /**
     * 删除科室
     * @param did
     * @return
     */
    @Override
    public Boolean deleteDepartmentById(Long did) {
        // 先将该科室的员工的科室ID置为空
        List<EmployeeDO> employeeDOList = employeeMapper.getDepartmentEmployeeList(did,RedisUtil.getLocalTenantId());
        employeeMapper.setDepartmentIdNull(employeeDOList.stream().map(EmployeeDO::getEmployeeId).collect(Collectors.toList()),RedisUtil.getLocalTenantId());
        // 删除科室信息
        departmentMapper.deleteById(did);
        return true;
    }

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
                .eq(EmployeeDO::getEmployeeTenantId, RedisUtil.getLocalTenantId())
                .orderByDesc(EmployeeDO::getEmployeeId);
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
