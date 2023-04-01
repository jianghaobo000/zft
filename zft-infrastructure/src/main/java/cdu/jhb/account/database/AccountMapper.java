package cdu.jhb.account.database;


import cdu.jhb.account.database.dataobject.AccountDO;
import cdu.jhb.account.dto.data.AccountDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @description: 账户Mapper
* @author jhb
* @date 2023/2/21 20:56
* @version 1.0
*/
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {

    AccountDO selectAccount(@Param("name") String name,@Param("countryCode") String countryCode);

}
