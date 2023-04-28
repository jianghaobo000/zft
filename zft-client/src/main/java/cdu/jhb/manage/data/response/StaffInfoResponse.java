package cdu.jhb.manage.data.response;

import cdu.jhb.account.data.dto.AccountDTO;
import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.data.dto.PracticeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 员工管理返回响应
* @author jhb
* @date 2023/04/28 21:27
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInfoResponse {

    /**
     * 员工详情
     */
    private EmployeeDTO employeeDTO;

    /**
     * 账号详情
     */
    private AccountDTO accountDTO;

    /**
     * 执业详情
     */
    private PracticeDTO practiceDTO;
}
