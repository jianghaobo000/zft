package cdu.jhb.commodity.command;

import cdu.jhb.commodity.database.CommodityMapper;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.domain.commodity.gateway.CommodityGateway;
import cdu.jhb.util.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
}
