package cdu.jhb.domain.tenant.gateway;

import cdu.jhb.domain.tenant.Tenant;
import cdu.jhb.tenant.data.dto.TenantDTO;

/**
* @description: 租户网关层
* @author jhb
* @date 2023/03/31 18:41
* @version 1.0
*/
public interface TenantGateway {

    Boolean saveTenant(Tenant tenant);
}
