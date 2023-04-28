package cdu.jhb.commodity.api;

import cdu.jhb.commodity.data.dto.CommodityDTO;

import java.util.List;

/**
* @description: 商品服务层接口
* @author jhb
* @date 2023/03/31 18:10
* @version 1.0
*/
public interface CommodityServiceI {

    /**
     * 新增品项
     * @param commodityDTO
     * @return
     */
    Boolean addCommodity(CommodityDTO commodityDTO);

    /**
     * 搜索药品
     * @param name
     * @return
     */
    List<CommodityDTO> selectCommodity(String name);

    /**
     * 通过ID搜索商品
     * @param id
     * @return
     */
    CommodityDTO selectCommodityById(Long id);

    /**
     * 设置商品启用状态
     * @param id
     * @param enable
     * @return
     */
    Boolean enableOrDeactivate(Long id,Integer enable);

}
