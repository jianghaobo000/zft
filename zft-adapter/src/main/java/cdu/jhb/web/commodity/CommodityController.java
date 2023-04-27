package cdu.jhb.web.commodity;

import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.common.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
* @description: 商品Controller
* @author jhb
* @date 2023/03/31 18:06
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("commodity")
public class CommodityController {

    private final CommodityServiceI commodityService;

    /**
     * 新增品项
     * @return
     */
    @PostMapping("add")
    public ResponseEntity<?> addCommodity(CommodityDTO commodityDTO){
        if(commodityService.addCommodity(commodityDTO)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询药品
     * @return
     */
    @GetMapping("selectCommodity")
    public ResponseEntity<?> selectCommodity(@RequestParam("name") String name){
        List<CommodityDTO> commodityDTOList = new ArrayList<>();
        if(!name.equals(Constant.NULL_STRING)){
            commodityDTOList = commodityService.selectCommodity(name);
        }
        return ResponseEntity.ok(commodityDTOList);
    }

    public ResponseEntity<?> selectCommodityById(@RequestParam("id") long id){
        return null;
    }
}
