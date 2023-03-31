package cdu.jhb.web.tenant;

import cdu.jhb.tenant.api.TenantServiceI;
import cdu.jhb.tenant.dto.data.TenantDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @description: 租户Controller
* @author jhb
* @date 2023/03/31 18:33
* @version 1.0
*/
@RequestMapping("tenant")
public class TenantController {

    @Resource
    private TenantServiceI tenantService;

    /**
     * 根据ID获取租户信息
     * @return
     */
    @GetMapping("getTenant")
    public TenantDTO getTenant(Long tenantId){
        return tenantService.getTenant(tenantId);
    }
}
