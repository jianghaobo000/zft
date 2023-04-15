package cdu.jhb.commodity.service;

import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.command.CommodityModExe;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @description: 商品
* @author jhb
* @date 2023/03/31 18:09
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class CommodityServiceImpl implements CommodityServiceI {

    private final CommodityModExe commodityModExe;


    /**
     * 新增品项
     * @param commodityDTO
     * @return
     */
    @Override
    public Boolean addCommodity(CommodityDTO commodityDTO) {
        return commodityModExe.addCommodity(commodityDTO);
    }
}
