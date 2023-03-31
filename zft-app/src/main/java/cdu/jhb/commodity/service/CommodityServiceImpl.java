package cdu.jhb.commodity.service;

import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @description: 商品
* @author jhb
* @date 2023/03/31 18:09
* @version 1.0
*/
@Service
public class CommodityServiceImpl implements CommodityServiceI {

    @Resource
    private CommodityGateway commodityGateway;

    /**
     * 新增品项
     * @param commodityDTO
     * @return
     */
    @Override
    public Boolean addCommodity(CommodityDTO commodityDTO) {
        Commodity commodity = DozerBeanMapperBuilder.buildDefault().map(commodityDTO,Commodity.class);
        return commodityGateway.addCommodity(commodity);
    }
}
