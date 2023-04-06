package cdu.jhb.commodity.command;

import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:50
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class CommodityModExe {

    private final CommodityGateway commodityGateway;
    /**
     *
     * @param commodity
     * @return
     */
    public Boolean addCommodity(Commodity commodity){
        return commodityGateway.addCommodity(commodity);
    }
}
