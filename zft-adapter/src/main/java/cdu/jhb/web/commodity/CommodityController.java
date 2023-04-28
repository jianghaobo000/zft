package cdu.jhb.web.commodity;

import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.common.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("addCommodity")
    public ResponseEntity<?> addCommodity(@RequestBody CommodityDTO commodityDTO){
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
        if(!Constant.NULL_STRING.equals(name)){
            commodityDTOList = commodityService.selectCommodity(name);
        }
        return ResponseEntity.ok(commodityDTOList);
    }

    /**
     * 按照ID搜索商品信息
     * @param id
     * @return
     */
    @GetMapping("selectCommodityById")
    public ResponseEntity<?> selectCommodityById(@RequestParam("id") Long id){
        CommodityDTO commodityDTO = commodityService.selectCommodityById(id);
        return ResponseEntity.ok(commodityDTO);
    }

    /**
     * 设置商品启用状态
     * @return
     */
    @GetMapping("enableOrDeactivate")
    public ResponseEntity<?> enableOrDeactivate(@RequestParam("id")Long id,@RequestParam("enable") Integer enable){
        if(commodityService.enableOrDeactivate(id,enable)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
