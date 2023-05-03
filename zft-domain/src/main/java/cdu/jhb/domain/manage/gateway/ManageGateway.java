package cdu.jhb.domain.manage.gateway;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.Practice;
import cdu.jhb.domain.charge.PayDict;
import cdu.jhb.domain.manage.Department;
import cdu.jhb.domain.manage.DiagnosticCharge;
import cdu.jhb.domain.manage.Equipment;
import cdu.jhb.domain.manage.PaySet;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.dto.EquipmentDTO;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:14
* @version 1.0
*/
public interface ManageGateway {

    /**
     * 获取科室列表
     * @param name
     * @return
     */
    List<Department> getDepartmentList(String name);

    /**
     * 获取科室下的成员列表
     * @param did
     * @return
     */
    List<Employee> getDepartmentEmployeeList(Long did);

    /**
     * 保存或修改科室信息
     */
    Boolean saveDepartment(Department department,List<Employee> employeeList);

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
    List<Employee> getStaffList(String name);

    /**
     * 新增或修改员工信息
     * @param employee
     * @param account
     * @param practice
     * @return
     */
    Boolean saveStaff(Employee employee, Account account, Practice practice);

    /**
     * 获取设备列表
     * @param name
     * @return
     */
    List<Equipment> getEquipmentList(String name);

    /**
     * 保存或修改设备信息
     * @return
     */
    Boolean saveEquipment(Equipment equipment);

    /**
     * 删除诊费通过员工ID
     * @param eid
     * @return
     */
    Boolean deleteDiagnosticChargeByEid(Long eid);

    /**
     * 保存挂号费设置
     * @param diagnosticChargeList
     * @return
     */
    Boolean saveDiagnosticCharge(List<DiagnosticCharge> diagnosticChargeList);

    /**
     * 获取挂号费设置
     * @return
     */
    List<DiagnosticCharge> getDiagnosticChargeList();

    /**
     * 获取支付设置
     * @return
     */
    PaySet getPaySet();

    /**
     * 获取支付字典列表
     * @return
     */
    List<PayDict> getPayDict();

    /**
     * 保存支付设置
     * @param paySet
     * @param payDictList
     * @return
     */
    Boolean savePaySet(PaySet paySet,List<PayDict> payDictList);
}
