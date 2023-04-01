package cdu.jhb.web.inventory;

import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.dto.data.InventoryInfoDTO;
import cdu.jhb.inventory.dto.data.InventoryListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String toInventory(InventoryListQuery query, Model model){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(query);
        model.addAttribute("infoDTOList",infoDTOList);
        return "inventory/inventory";
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
