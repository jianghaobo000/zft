package cdu.jhb.web.commodity;

import cdu.jhb.account.api.AccountServiceI;
import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @description: 商品Controller
* @author jhb
* @date 2023/03/31 18:06
* @version 1.0
*/
@Controller
@RequestMapping("commodity")
public class CommodityController {

    @Resource
    private CommodityServiceI commodityServiceI;

    /**
     * 新增品项
     * @return
     */
    @PostMapping("add")
    public Boolean addCommodity(@RequestBody CommodityDTO commodityDTO){
        return commodityServiceI.addCommodity(commodityDTO);
    }
}
