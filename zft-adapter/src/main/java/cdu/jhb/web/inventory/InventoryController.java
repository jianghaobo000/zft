package cdu.jhb.web.inventory;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
* @description: 库存Controller
* @author jhb
* @date 2023/3/10 13:38
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("inventory")
public class InventoryController {

    private final InventoryServiceI inventoryService;

    /**
     * 跳转库存药品物资界面
     * @return
     */
    @GetMapping("toInventory")
    public String toInventory(Model model){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(new InventoryListQuery());
        model.addAttribute("infoDTOList",infoDTOList);
        return "inventory/inventory";
    }

    /**
     * 条件查询药品物资列表
     * @return
     */
    @PostMapping("toInventoryByQuery")
    public String toInventory(InventoryListQuery query, Model model){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(query);
        model.addAttribute("infoDTOList",infoDTOList);
        return "inventory/inventory :: infoList";
    }
//    @PostMapping("toInventoryByQuery")
//    public ResponseEntity<?> toInventory(InventoryListQuery query){
//        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(query);
//        return ResponseEntity.ok(infoDTOList);
//    }

    /**
     * 按ID查询商品信息
     * @return
     */
    @GetMapping("selectById")
    public ResponseEntity<?> selectById(Long id){
        CommodityDTO commodityDTO = inventoryService.selectById(id);
        return ResponseEntity.ok(commodityDTO);
    }

    /**
     * 跳转库存入库界面
     * @return
     */
    @GetMapping("toInventoryIn")
    public String toInventoryIn(){
        return "inventory/inventoryIn";
    }

    /**
     * 跳转库存出库界面
     * @return
     */
    @GetMapping("toInventoryOut")
    public String toInventoryOut(){
        return "inventory/inventoryOut";
    }

    /**
     * 跳转库存盘点界面
     * @return
     */
    @GetMapping("toInventoryCheck")
    public String toInventoryCheck(){
        return "inventory/inventoryCheck";
    }
}
