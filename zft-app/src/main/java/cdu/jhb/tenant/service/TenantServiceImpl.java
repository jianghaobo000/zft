package cdu.jhb.tenant.service;

import cdu.jhb.domain.tenant.Tenant;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import cdu.jhb.tenant.api.TenantServiceI;
import cdu.jhb.tenant.command.TenantModExe;
import cdu.jhb.tenant.command.TenantQryExe;
import cdu.jhb.tenant.data.dto.TenantDTO;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @description: 租户服务层
* @author jhb
* @date 2023/03/31 18:34
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantServiceI {

    private final TenantGateway tenantGateway;

    private final TenantQryExe tenantQryExe;

    private final TenantModExe tenantModExe;

    /**
     * 获取租户ID
     * @return
     */
    @Override
    public TenantDTO getTenant(Long tenantId) {
        Tenant tenant = tenantQryExe.getTenant(tenantId);
        return Convert.entityConvert(tenant,TenantDTO.class);
    }

    /**
     * 保存租户
     * @param tenantDTO
     * @return
     */
    @Override
    public Boolean saveTenant(TenantDTO tenantDTO) {
        return tenantModExe.saveTenant(tenantDTO);
    }
}
