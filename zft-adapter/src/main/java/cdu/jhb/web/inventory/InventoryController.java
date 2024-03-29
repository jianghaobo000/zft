package cdu.jhb.web.inventory;

import cdu.jhb.commodity.data.dto.CommodityDTO;
import cdu.jhb.inventory.api.InventoryCheckServiceI;
import cdu.jhb.inventory.api.InventoryInServiceI;
import cdu.jhb.inventory.api.InventoryOutServiceI;
import cdu.jhb.inventory.api.InventoryServiceI;
import cdu.jhb.inventory.data.dto.*;
import cdu.jhb.inventory.data.request.InventoryCheckListQuery;
import cdu.jhb.inventory.data.request.InventoryInListQuery;
import cdu.jhb.inventory.data.request.InventoryListQuery;
import cdu.jhb.inventory.data.request.InventoryOutListQuery;
import cdu.jhb.inventory.data.response.InventoryCheckListResponse;
import cdu.jhb.inventory.data.response.InventoryInListResponse;
import cdu.jhb.inventory.data.response.InventoryListResponse;
import cdu.jhb.inventory.data.response.InventoryOutListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String toInventory(){
        return "inventory/inventory";
    }

    /**
     * 条件查询药品物资列表分页
     * @return
     */
    @PostMapping("toInventoryByQuery")
    public ResponseEntity<?> toInventoryByPage(@RequestBody InventoryListQuery query){
        InventoryListResponse listResponse =  inventoryService.getInventoryListByPage(query);
        return ResponseEntity.ok(listResponse);
    }

    /**
     * 通过名称查询药品物资列表
     * @return
     */
    @GetMapping("selectInventoryByName")
    public ResponseEntity<?> toInventory(@RequestParam("name")String name,@RequestParam("status")Integer status){
        List<InventoryInfoDTO> infoDTOList = inventoryService.getInventoryList(new InventoryListQuery(name,null,null,status,0,null));
        return ResponseEntity.ok(infoDTOList);
    }

    /**
     * 按ID查询商品信息
     * @return
     */
    @GetMapping("selectById")
    public ResponseEntity<?> selectById(@RequestParam("id") Long id){
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
     * 查询库存入库列表
     * @return
     */
    @PostMapping("toInventoryInByQuery")
    public ResponseEntity<?> toInventoryInByQuery(@RequestBody InventoryInListQuery query){
        InventoryInListResponse response = inventoryInService.getInventoryInList(query);
        return ResponseEntity.ok(response);
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
     * 保存入库单
     * @param inventoryInDTO
     * @return
     */
    @PostMapping("saveInventoryIn")
    public ResponseEntity<?> saveInventoryIn(@RequestBody InventoryInDTO inventoryInDTO){
        if(inventoryInService.saveInventoryIn(inventoryInDTO)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 待入库发起入库
     * @param id
     * @return
     */
    @GetMapping("waitToSaveIn")
    public ResponseEntity<?> waitToSaveIn(@RequestParam("id") Long id){
        if(inventoryInService.waitToSaveIn(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
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
     * 条件查询跳转库存出库列表界面
     * @param query
     * @return
     */
    @PostMapping("toInventoryOutByQuery")
    public ResponseEntity<?> toInventoryOutByQuery(@RequestBody InventoryOutListQuery query){
        InventoryOutListResponse response = inventoryOutService.getInventoryOutList(query);
        return ResponseEntity.ok(response);
    }

    /**
     * 打开出库单详情页面
     * @param id
     * @return
     */
    @GetMapping("selectOutDetailById")
    public ResponseEntity<?> selectOutDetailById(@RequestParam("id") Long id){
        InventoryOutInfoDTO inventoryOutInfoDTO = inventoryOutService.selectOutDetailById(id);
        return ResponseEntity.ok(inventoryOutInfoDTO);
    }

    /**
     * 保存出库单
     * @param inventoryOutDTO
     * @return
     */
    @PostMapping("saveInventoryOut")
    public ResponseEntity<?> saveInventoryOut(@RequestBody InventoryOutDTO inventoryOutDTO){
        if(inventoryOutService.saveInventoryOut(inventoryOutDTO)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 待出库发起出库
     * @param id
     * @return
     */
    @GetMapping("waitToSaveOut")
    public ResponseEntity<?> waitToSaveOut(@RequestParam("id") Long id){
        if(inventoryOutService.waitToSaveOut(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 跳转库存盘点界面
     * @return
     */
    @GetMapping("toInventoryCheck")
    public String toInventoryCheck(){
        return "inventory/inventoryCheck";
    }

    /**
     * 查询库存盘点一览
     * @return
     */
    @PostMapping("toInventoryCheckByQuery")
    public ResponseEntity<?> toInventoryCheckByQuery(@RequestBody InventoryCheckListQuery query){
        InventoryCheckListResponse response = inventoryCheckService.getInventoryCheckList(query);
        return ResponseEntity.ok(response);
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
     * 保存盘点单
     * @param inventoryCheckDTO
     * @return
     */
    @PostMapping("saveInventoryCheck")
    public ResponseEntity<?> saveInventoryOut(@RequestBody InventoryCheckDTO inventoryCheckDTO){
        if(inventoryCheckService.saveInventoryCheck(inventoryCheckDTO)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 待盘点发起盘点
     * @param id
     * @return
     */
    @GetMapping("waitToSaveCheck")
    public ResponseEntity<?> waitToSaveCheck(@RequestParam("id") Long id){
        if(inventoryCheckService.waitToSaveCheck(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
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


