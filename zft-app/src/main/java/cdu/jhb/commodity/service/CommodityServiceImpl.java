package cdu.jhb.commodity.service;

import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.command.CommodityModExe;
import cdu.jhb.commodity.command.CommodityQryExe;
import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.domain.commodity.Commodity;
import cdu.jhb.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final CommodityQryExe commodityQryExe;

    /**
     * 新增品项
     * @param commodityDTO
     * @return
     */
    @Override
    public Boolean addCommodity(CommodityDTO commodityDTO) {
        return commodityModExe.addCommodity(commodityDTO);
    }

    /**
     * 搜索药品
     * @param name
     * @return
     */
    @Override
    public List<CommodityDTO> selectCommodity(String name) {
        return commodityQryExe.selectCommodity(name);
    }

    /**
     * 通过ID搜索商品
     * @param id
     * @return
     */
    @Override
    public CommodityDTO selectCommodityById(Long id) {
        return commodityQryExe.selectCommodityById(id);
    }

    /**
     * 设置商品启用状态
     * @param id
     * @param enable
     * @return
     */
    @Override
    public Boolean enableOrDeactivate(Long id, Integer enable) {
        return commodityQryExe.enableOrDeactivate(id,enable);
    }
}
