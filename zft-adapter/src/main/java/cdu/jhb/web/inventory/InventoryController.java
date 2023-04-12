package cdu.jhb.web.inventory;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.inventory.InventoryCheck;
import cdu.jhb.domain.inventory.Supplier;
import cdu.jhb.inventory.api.InventoryCheckServiceI;
import cdu.jhb.inventory.api.InventoryInServiceI;
import cdu.jhb.inventory.api.InventoryOutServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.dto.data.*;
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

    private final InventoryInServiceI inventoryInService;

    private final InventoryOutServiceI inventoryOutService;

    private final InventoryCheckServiceI inventoryCheckService;

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
    public String toInventoryIn(Model model){
        List<InventoryInInfoDTO> inventoryInDTOList = inventoryInService.getInventoryInList(new InventoryInListQuery());
        model.addAttribute("inventoryInInfo",new InventoryInInfoDTO());
        model.addAttribute("infoInDTOList",inventoryInDTOList);
        return "inventory/inventoryIn";
    }

    /**
     * 跳转库存入库界面
     * @return
     */
    @PostMapping("toInventoryInByQuery")
    public String toInventoryInByQuery(Model model,InventoryInListQuery query){
        List<InventoryInInfoDTO> inventoryInDTOList = inventoryInService.getInventoryInList(query);
        model.addAttribute("inventoryInInfo",new InventoryInInfoDTO());
        model.addAttribute("infoInDTOList",inventoryInDTOList);
        return "inventory/inventoryIn :: inInfoList";
    }

    /**
     * 跳转库存出库界面
     * @return
     */
    @GetMapping("toInventoryOut")
    public String toInventoryOut(Model model){
        List<InventoryOutInfoDTO> inventoryOutDTOList = inventoryOutService.getInventoryOutList(new InventoryOutListQuery());
        model.addAttribute("infoOutDTOList",inventoryOutDTOList);
        return "inventory/inventoryOut";
    }

    @PostMapping("toInventoryOutByQuery")
    public String toInventoryOutByQuery(Model model,InventoryOutListQuery query){
        List<InventoryOutInfoDTO> inventoryOutDTOList = inventoryOutService.getInventoryOutList(query);
        model.addAttribute("infoOutDTOList",inventoryOutDTOList);
        return "inventory/inventoryOut :: outInfoList";
    }

    /**
     * 跳转库存盘点界面
     * @return
     */
    @GetMapping("toInventoryCheck")
    public String toInventoryCheck(Model model){
        List<InventoryCheckInfoDTO> InventoryCheckDTOList = inventoryCheckService.getInventoryCheckList(new InventoryCheckListQuery());
        model.addAttribute("infoCheckDTOList",InventoryCheckDTOList);
        return "inventory/inventoryCheck";
    }

    /**
     * 跳转库存盘点界面
     * @return
     */
    @PostMapping("toInventoryCheckByQuery")
    public String toInventoryCheckByQuery(Model model,InventoryCheckListQuery query){
        List<InventoryCheckInfoDTO> InventoryCheckDTOList = inventoryCheckService.getInventoryCheckList(query);
        model.addAttribute("infoCheckDTOList",InventoryCheckDTOList);
        return "inventory/inventoryCheck :: checkInfoList";
    }

    /**
     * 打开入库单详情页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("selectInDetailById")
    public String selectInDetailById(Model model,@Param("id") Long id){
        InventoryInInfoDTO inventoryInInfoDTO = inventoryInService.selectInDetailById(id);
        model.addAttribute("inventoryInInfo",inventoryInInfoDTO);
        return "inventory/inventoryIn :: inventoryInInfo";
    }

    /**
     * 获取供应商列表
     */
    @GetMapping("supplierList")
    public ResponseEntity<?> getSupplierList(){
        List<SupplierDTO> supplierList = inventoryService.getSupplierList();
        return ResponseEntity.ok(supplierList);
    }
}


