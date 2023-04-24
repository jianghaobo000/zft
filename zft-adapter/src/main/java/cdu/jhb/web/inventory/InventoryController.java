package cdu.jhb.web.inventory;

import cdu.jhb.commodity.dto.data.CommodityDTO;
import cdu.jhb.domain.inventory.InventoryCheck;
import cdu.jhb.domain.inventory.InventoryOutInfo;
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
import org.springframework.web.bind.annotation.RequestParam;

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
    public ResponseEntity<?> toInventory(){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(new InventoryListQuery());
        return ResponseEntity.ok(infoDTOList);
    }

    /**
     * 条件查询药品物资列表
     * @return
     */
    @PostMapping("toInventoryByQuery")
    public ResponseEntity<?> toInventory(InventoryListQuery query){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(query);
        return ResponseEntity.ok(infoDTOList);
    }

    /**
     * 通过名称查询药品物资列表
     * @return
     */
    @GetMapping("selectInventoryByName")
    public ResponseEntity<?> toInventory(@RequestParam("name")String name){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(new InventoryListQuery(name,null,null,null));
        return ResponseEntity.ok(infoDTOList);
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
    public ResponseEntity<?> toInventoryIn(){
        List<InventoryInInfoDTO> inventoryInDTOList = inventoryInService.getInventoryInList(new InventoryInListQuery());
        return ResponseEntity.ok(inventoryInDTOList);
    }

    /**
     * 跳转库存入库界面
     * @return
     */
    @PostMapping("toInventoryInByQuery")
    public ResponseEntity<?> toInventoryInByQuery(InventoryInListQuery query){
        List<InventoryInInfoDTO> inventoryInDTOList = inventoryInService.getInventoryInList(query);
        return ResponseEntity.ok(inventoryInDTOList);
    }

    /**
     * 打开入库单详情页面
     * @param id
     * @return
     */
    @GetMapping("selectInDetailById")
    public ResponseEntity<?> selectInDetailById(@RequestParam("id") Long id){
        InventoryInInfoDTO inventoryInInfoDTO = inventoryInService.selectInDetailById(id);
        return ResponseEntity.ok(inventoryInInfoDTO);
    }

    /**
     * 跳转库存出库界面
     * @return
     */
    @GetMapping("toInventoryOut")
    public ResponseEntity<?> toInventoryOut(){
        List<InventoryOutInfoDTO> inventoryOutDTOList = inventoryOutService.getInventoryOutList(new InventoryOutListQuery());
        return ResponseEntity.ok(inventoryOutDTOList);
    }

    /**
     * 条件查询跳转库存出库列表界面
     * @param model
     * @param query
     * @return
     */
    @PostMapping("toInventoryOutByQuery")
    public ResponseEntity<?> toInventoryOutByQuery(Model model,InventoryOutListQuery query){
        List<InventoryOutInfoDTO> inventoryOutDTOList = inventoryOutService.getInventoryOutList(query);
        return ResponseEntity.ok(inventoryOutDTOList);
    }

    /**
     * 打开出库单详情页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("selectOutDetailById")
    public ResponseEntity<?> selectOutDetailById(@RequestParam("id") Long id){
        InventoryOutInfoDTO inventoryOutInfoDTO = inventoryOutService.selectOutDetailById(id);
        return ResponseEntity.ok(inventoryOutInfoDTO);
    }

    /**
     * 跳转库存盘点界面
     * @return
     */
    @GetMapping("toInventoryCheck")
    public ResponseEntity<?> toInventoryCheck(){
        List<InventoryCheckInfoDTO> inventoryCheckDTOList = inventoryCheckService.getInventoryCheckList(new InventoryCheckListQuery());
        return ResponseEntity.ok(inventoryCheckDTOList);
    }

    /**
     * 跳转库存盘点界面
     * @return
     */
    @PostMapping("toInventoryCheckByQuery")
    public ResponseEntity<?> toInventoryCheckByQuery(InventoryCheckListQuery query){
        List<InventoryCheckInfoDTO> inventoryCheckDTOList = inventoryCheckService.getInventoryCheckList(query);
        return ResponseEntity.ok(inventoryCheckDTOList);
    }

    /**
     * 打开盘点单详情页面
     * @param id
     * @return
     */
    @GetMapping("selectCheckDetailById")
    public ResponseEntity<?> selectCheckDetailById(@RequestParam("id") Long id){
        InventoryCheckInfoDTO inventoryCheckInfoDTO = inventoryCheckService.selectCheckDetailById(id);
        return ResponseEntity.ok(inventoryCheckInfoDTO);
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


