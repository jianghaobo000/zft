package cdu.jhb.account.command;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.account.database.AccountMapper;
import cdu.jhb.account.data.dto.AccountDTO;
import cdu.jhb.account.database.EmployeeMapper;
import cdu.jhb.account.database.PracticeMapper;
import cdu.jhb.account.database.dataobject.EmployeeDO;
import cdu.jhb.common.Constant;
import cdu.jhb.domain.account.Account;
import cdu.jhb.domain.account.Employee;
import cdu.jhb.domain.account.gateway.AccountGateway;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:05
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class AccountQryExe {

    private final AccountGateway accountGateway;

    private final AccountMapper accountMapper;

    private final PracticeMapper practiceMapper;

    private final EmployeeMapper employeeMapper;

    /**
     * 通过名字查询账号
     * @param name
     * @param countryCode
     * @return
     */
    public Boolean findAccountByName(String name, String password, String code, String countryCode, HttpServletRequest request) {
        Account account = accountGateway.findAccountByName(name,countryCode,request);
        HttpSession session = request.getSession();
        session.setAttribute(Constant.ROLE_ID,account.getAccountRole());
        return account.isOk(password);
    }

    /**
     * 验证国家码是否存在
     * @param countryCode
     * @return
     * @throws Exception
     */
    public Boolean findCountryCode(String countryCode) {
        return accountGateway.findCountryCode(countryCode);
    }

    /**
     * 获取账号列表
     * @return
     */
    public List<AccountDTO> getAccountList(){
        return accountMapper.getAccountList(RedisUtil.getLocalTenantId());
    }

    /**
     * 获取员工列表
     * @return
     */
    public List<EmployeeDTO> getEmployeeList() {
        return employeeMapper.getEmployeeList(RedisUtil.getLocalTenantId());
    }

    /**
     * 获取库存模块员工列表
     */
    public List<EmployeeDTO> getInventoryEmployeeList(){
        return employeeMapper.getInventoryEmployeeList(RedisUtil.getLocalTenantId());
    }

    /**
     * 获取没有分配科室的员工列表
     * @return
     */
    public List<EmployeeDTO> getNoDepartEmployeeList() {
        return employeeMapper.getNoDepartEmployeeList(RedisUtil.getLocalTenantId());
    }
}
