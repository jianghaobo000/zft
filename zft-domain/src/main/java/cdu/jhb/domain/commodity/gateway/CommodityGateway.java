package cdu.jhb.domain.commodity.gateway;

import cdu.jhb.domain.commodity.Commodity;

/**
* @description: 商品网关层接口
* @author jhb
* @date 2023/03/31 18:14
* @version 1.0
*/
public interface CommodityGateway {
    /**
     * 新增品项
     * @param commodity
     * @return
     */
    Boolean addCommodity(Commodity commodity);
}
