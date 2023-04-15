package cdu.jhb.commodity.command;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import cdu.jhb.util.Convert;
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
     * @param commodityDTO
     * @return
     */
    public Boolean addCommodity(CommodityDTO commodityDTO){
        // 将数据传输对象DTO转换为实体
        Commodity commodity = Convert.entityConvert(commodityDTO,Commodity.class);
        return commodityGateway.addCommodity(commodity);
    }
}
