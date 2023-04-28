package cdu.jhb.domain.manage.gateway;

import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.Practice;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/28 23:14
* @version 1.0
*/
public interface ManageGateway {

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


}
