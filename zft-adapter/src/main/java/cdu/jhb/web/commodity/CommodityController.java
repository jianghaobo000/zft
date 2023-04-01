package cdu.jhb.web.commodity;

import cdu.jhb.commodity.api.CommodityServiceI;
import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.inventory.dto.data.InventoryDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        int rows = commodityService.addCommodity(commodityDTO);
        if(rows == 1){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
