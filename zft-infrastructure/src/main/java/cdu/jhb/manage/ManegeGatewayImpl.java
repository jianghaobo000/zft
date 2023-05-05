package cdu.jhb.manage;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.database.EmployeeMapper;
import cdu.jhb.account.database.PracticeMapper;
import cdu.jhb.account.database.dataobject.AccountDO;
import cdu.jhb.account.database.dataobject.EmployeeDO;
import cdu.jhb.account.database.dataobject.PracticeDO;
import cdu.jhb.charge.database.PayDictMapper;
import cdu.jhb.charge.database.dataobject.PayDictDO;
import cdu.jhb.common.Constant;
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
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.dto.DiagnosticChargeDTO;
import cdu.jhb.manage.data.dto.EquipmentDTO;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import cdu.jhb.manage.database.DepartmentMapper;
import cdu.jhb.manage.database.DiagnosticChargeMapper;
import cdu.jhb.manage.database.EquipmentMapper;
import cdu.jhb.manage.database.PaySetMapper;
import cdu.jhb.manage.database.dataobject.DepartmentDO;
import cdu.jhb.manage.database.dataobject.DiagnosticChargeDO;
import cdu.jhb.manage.database.dataobject.EquipmentDO;
import cdu.jhb.manage.database.dataobject.PaySetDO;
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

    private final EquipmentMapper equipmentMapper;

    private final DiagnosticChargeMapper diagnosticChargeMapper;

    private final PaySetMapper paySetMapper;

    private final PayDictMapper payDictMapper;

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
        if(employeeDOList.size()>0){
            employeeMapper.setDepartmentIdNull(employeeDOList.stream().map(EmployeeDO::getEmployeeId).collect(Collectors.toList()),RedisUtil.getLocalTenantId());
        }
        // 删除科室信息
        if(departmentMapper.deleteById(did)!=1){
            throw new RuntimeException(DictException.DELETE_DEPARTMENT_FAILED);
        }
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

            // 新增挂号费
            // 获取统一挂号费
            QueryWrapper<DiagnosticChargeDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(DiagnosticChargeDO::getDiagnosticChargeStatus,0)
                    .eq(DiagnosticChargeDO::getDiagnosticChargeTenantId,RedisUtil.getLocalTenantId());
            DiagnosticChargeDO diagnosticChargeDO = diagnosticChargeMapper.selectOne(queryWrapper);
            diagnosticChargeDO.setDiagnosticChargeId(null);
            // 设置员工ID
            diagnosticChargeDO.setDiagnosticChargeEmployeeId(employeeDO.getEmployeeId());
            diagnosticChargeDO.setDiagnosticChargeEmployeeName(employeeDO.getEmployeeName());
            // 设置状态为个人
            diagnosticChargeDO.setDiagnosticChargeStatus(1);
            diagnosticChargeMapper.insert(diagnosticChargeDO);

        }else{
            // 修改
            accountMapper.updateById(accountDO);
            practiceMapper.updateById(practiceDO);
            employeeMapper.updateById(employeeDO);
        }

        return true;
    }

    /**
     * 获取设备列表
     * @param name
     * @return
     */
    @Override
    public List<Equipment> getEquipmentList(String name) {
        QueryWrapper<EquipmentDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(EquipmentDO::getEquipmentName,name)
                .or()
                .like(EquipmentDO::getEquipmentPinYin,name)
                .eq(EquipmentDO::getEquipmentTenantId,RedisUtil.getLocalTenantId())
                .orderByDesc(EquipmentDO::getEquipmentId);
        List<EquipmentDO> equipmentDOList = equipmentMapper.selectList(queryWrapper);
        return Convert.listConvert(equipmentDOList,Equipment.class);
    }

    /**
     * 保存或修改设备信息
     * @param equipment
     * @return
     */
    @Override
    public Boolean saveEquipment(Equipment equipment) {
        // 转化数据库表对象
        EquipmentDO equipmentDO = Convert.entityConvert(equipment,EquipmentDO.class);
        // 如果ID为空则新增，不为空则修改
        if(equipmentDO.getEquipmentId()==null){
            equipmentDO.setEquipmentTenantId(RedisUtil.getLocalTenantId());
            equipmentMapper.insert(equipmentDO);
        }else{
            equipmentMapper.updateById(equipmentDO);
        }
        return true;
    }

    /**
     * 删除诊费通过员工id
     * @param eid
     * @return
     */
    @Override
    public Boolean deleteDiagnosticChargeByEid(Long eid) {
        QueryWrapper<DiagnosticChargeDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(DiagnosticChargeDO::getDiagnosticChargeEmployeeId,eid)
                .eq(DiagnosticChargeDO::getDiagnosticChargeTenantId,RedisUtil.getLocalTenantId());
        diagnosticChargeMapper.delete(queryWrapper);
        return true;
    }

    /**
     * 保存挂号费设置
     * @param diagnosticChargeList
     * @return
     */
    @Override
    public Boolean saveDiagnosticCharge(List<DiagnosticCharge> diagnosticChargeList) {
        List<DiagnosticChargeDO> diagnosticChargeDOList = Convert.listConvert(diagnosticChargeList,DiagnosticChargeDO.class);
        diagnosticChargeDOList.forEach(diagnosticChargeMapper::updateById);
        return true;
    }

    /**
     * 获取挂号费设置
     * @return
     */
    @Override
    public List<DiagnosticCharge> getDiagnosticChargeList() {
        // 查出有医护技的员工
        QueryWrapper<EmployeeDO> employeeDOQueryWrapper = new QueryWrapper<>();
        employeeDOQueryWrapper.lambda()
                .eq(EmployeeDO::getEmployeeMedicalNursingSkills,1)
                .eq(EmployeeDO::getEmployeeTenantId,RedisUtil.getLocalTenantId());
        List<EmployeeDO> employeeDOList = employeeMapper.selectList(employeeDOQueryWrapper);
        List<Long> eids = employeeDOList.stream().map(EmployeeDO::getEmployeeId).collect(Collectors.toList());
        eids.add(RedisUtil.getLocalTenantId());

        QueryWrapper<DiagnosticChargeDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .in(DiagnosticChargeDO::getDiagnosticChargeEmployeeId,eids)
                .eq(DiagnosticChargeDO::getDiagnosticChargeTenantId,RedisUtil.getLocalTenantId());
        List<DiagnosticChargeDO> diagnosticChargeDOList = diagnosticChargeMapper.selectList(queryWrapper);
        return Convert.listConvert(diagnosticChargeDOList,DiagnosticCharge.class);
    }

    /**
     * 获取当前用户的挂号费
     * @return
     */
    @Override
    public DiagnosticCharge getDiagnosticCharge() {
        QueryWrapper<DiagnosticChargeDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(DiagnosticChargeDO::getDiagnosticChargeTenantId,RedisUtil.getLocalTenantId())
                .eq(DiagnosticChargeDO::getDiagnosticChargeEmployeeId,RedisUtil.getLong(Constant.EMPLOYEE_ID));
        DiagnosticChargeDO diagnosticChargeDO = diagnosticChargeMapper.selectOne(queryWrapper);
        return Convert.entityConvert(diagnosticChargeDO,DiagnosticCharge.class);
    }

    /**
     * 获取支付设置
     * @return
     */
    @Override
    public PaySet getPaySet() {
        QueryWrapper<PaySetDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PaySetDO::getPaySetTenantId,RedisUtil.getLocalTenantId());
        PaySetDO paySetDO = paySetMapper.selectOne(queryWrapper);
        return Convert.entityConvert(paySetDO,PaySet.class);
    }

    /**
     * 获取支付字典列表
     * @return
     */
    @Override
    public List<PayDict> getPayDict() {
        QueryWrapper<PayDictDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PayDictDO::getPayTenantId,RedisUtil.getLocalTenantId());
        List<PayDictDO> payDictDOList = payDictMapper.selectList(queryWrapper);
        return Convert.listConvert(payDictDOList,PayDict.class);
    }

    /**
     * 保存支付设置
     * @param paySet
     * @param payDictList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean savePaySet(PaySet paySet, List<PayDict> payDictList) {
        PaySetDO paySetDO = Convert.entityConvert(paySet,PaySetDO.class);
        List<PayDictDO> payDictDOList = Convert.listConvert(payDictList,PayDictDO.class);

        // 更新支付设置信息
        paySetMapper.updateById(paySetDO);
        // 更新支付方式
        payDictDOList.forEach(payDictMapper::updateById);
        return true;
    }


}
