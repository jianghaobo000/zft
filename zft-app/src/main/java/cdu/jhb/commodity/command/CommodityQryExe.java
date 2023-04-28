package cdu.jhb.commodity.command;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import cdu.jhb.util.Convert;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/04/01 21:59
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class CommodityQryExe {

    private final CommodityMapper commodityMapper;

    private final CommodityGateway commodityGateway;

    /**
     * 搜索药品
     * @param name
     * @return
     */
    public List<CommodityDTO> selectCommodity(String name) {
        List<Commodity> commodityList = commodityGateway.selectCommodity(name);
        return Convert.listConvert(commodityList,CommodityDTO.class);
    }

    /**
     * 通过ID搜索商品
     * @param id
     * @return
     */
    public CommodityDTO selectCommodityById(Long id) {
        Commodity commodity = commodityGateway.selectCommodityById(id);
        return Convert.entityConvert(commodity,CommodityDTO.class);
    }

    /**
     * 设置商品启用状态
     * @param id
     * @param enable
     * @return
     */
    public Boolean enableOrDeactivate(Long id, Integer enable) {
        return commodityGateway.enableOrDeactivate(id,enable);
    }
}
