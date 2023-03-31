package cdu.jhb.commodity;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.database.dataobject.CommodityDO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import cdu.jhb.domain.tenant.gateway.TenantGateway;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
* @description: 商品网关层
* @author jhb
* @date 2023/03/31 18:19
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class CommodityGatewayImpl implements CommodityGateway {

    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private TenantGateway tenantGateway;

    /**
     * 新增品项
     * @param commodity
     * @return
     */
    @Override
    public Boolean addCommodity(Commodity commodity) {
        CommodityDO commodityDO = DozerBeanMapperBuilder.buildDefault().map(commodity,CommodityDO.class);
        // 从redis缓存中获取当前登录租户国家码
        Jedis jedis = new Jedis();
        commodityDO.setCommodity_tenant_id(Long.valueOf(jedis.get("countryCode")));
        return commodityMapper.insert(commodityDO) == 1;
    }
}
