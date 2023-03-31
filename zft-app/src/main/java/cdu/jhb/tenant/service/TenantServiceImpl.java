package cdu.jhb.tenant.service;

import cdu.jhb.domain.tenant.Tenant;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import cdu.jhb.tenant.api.TenantServiceI;
import cdu.jhb.tenant.command.query.TenantQryExe;
import cdu.jhb.tenant.dto.data.TenantDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @description: 租户服务层
* @author jhb
* @date 2023/03/31 18:34
* @version 1.0
*/
@Service
public class TenantServiceImpl implements TenantServiceI {

    @Resource
    private TenantGateway tenantGateway;
    @Resource
    private TenantQryExe tenantQryExe;

    /**
     * 获取租户ID
     * @return
     */
    @Override
    public TenantDTO getTenant(Long tenantId) {
        Tenant tenant = tenantQryExe.getTenant(tenantId);
        return DozerBeanMapperBuilder.buildDefault().map(tenant,TenantDTO.class);
    }
}
