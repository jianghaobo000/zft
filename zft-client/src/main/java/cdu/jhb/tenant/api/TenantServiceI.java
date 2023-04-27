package cdu.jhb.tenant.api;

import cdu.jhb.tenant.data.dto.TenantDTO;

/**
* @description: 租户服务层
* @author jhb
* @date 2023/03/31 18:35
* @version 1.0
*/
public interface TenantServiceI {
    /**
     * 根据ID获取租户
     * @return
     */
    TenantDTO getTenant(Long tenantId);
}
