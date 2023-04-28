package cdu.jhb.tenant.command;

import cdu.jhb.domain.tenant.Tenant;
import cdu.jhb.tenant.database.TenantMapper;
import cdu.jhb.tenant.database.dataobject.TenantDO;
import cdu.jhb.util.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
* @description: 租户查询器
* @author jhb
* @date 2023/03/31 18:49
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class TenantQryExe {

    private final TenantMapper tenantMapper;

    public Tenant getTenant(Long tenantId){
        QueryWrapper<TenantDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TenantDO::getTenantId,tenantId);
        TenantDO tenantDO = tenantMapper.selectOne(queryWrapper);
        return Convert.entityConvert(tenantDO,Tenant.class);
    }
}
