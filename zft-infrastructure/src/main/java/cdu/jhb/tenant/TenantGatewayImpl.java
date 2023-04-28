package cdu.jhb.tenant;

import cdu.jhb.common.DictException;
import cdu.jhb.domain.tenant.Tenant;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import cdu.jhb.tenant.database.TenantMapper;
import cdu.jhb.tenant.database.dataobject.TenantDO;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
* @description: TODO
* @author jhb
* @date 2023/03/31 18:42
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class TenantGatewayImpl implements TenantGateway {

    private final TenantMapper tenantMapper;

    /**
     * 保存诊所
     * @param tenant
     * @return
     */
    @Override
    public Boolean saveTenant(Tenant tenant) {
        TenantDO tenantDO = Convert.entityConvert(tenant,TenantDO.class);
        // 不为空则修改
        if(tenantDO.getTenantId()!=null){
            if(tenantMapper.updateById(tenantDO)!=1){
                throw new RuntimeException(DictException.UPDATE_TENANT_FAILED);
            }
        }else {
            if(tenantMapper.insert(tenantDO)!=1){
                throw new RuntimeException(DictException.INSERT_TENANT_FAILED);
            }
        }
        return true;
    }
}
