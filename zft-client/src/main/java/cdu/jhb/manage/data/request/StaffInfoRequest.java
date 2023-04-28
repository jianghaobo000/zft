package cdu.jhb.manage.data.request;

import cdu.jhb.account.data.dto.AccountDTO;
import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.data.dto.PracticeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 员工管理请求参数
* @author jhb
* @date 2023/04/28 21:27
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInfoRequest {
    /**
     * 账号详情
     */
    private AccountDTO accountDTO;

    /**
     * 员工详情
     */
    private EmployeeDTO employeeDTO;

    /**
     * 执业详情
     */
    private PracticeDTO practiceDTO;
}
