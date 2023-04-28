package cdu.jhb.tenant.command;

import cdu.jhb.domain.tenant.Tenant;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import cdu.jhb.tenant.data.dto.TenantDTO;
import cdu.jhb.tenant.database.TenantMapper;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* @description: 租户命令器
* @author jhb
* @date 2023/04/28 19:43
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class TenantModExe {

    private final TenantGateway tenantGateway;

    private final TenantMapper tenantMapper;

    /**
     * 保存诊所
     * @param tenantDTO
     * @return
     */
    public Boolean saveTenant(TenantDTO tenantDTO) {
        Tenant tenant = Convert.entityConvert(tenantDTO,Tenant.class);
        return tenantGateway.saveTenant(tenant);
    }
}
