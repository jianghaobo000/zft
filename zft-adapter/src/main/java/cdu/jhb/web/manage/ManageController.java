package cdu.jhb.web.manage;

import cdu.jhb.account.data.dto.EmployeeDTO;
import cdu.jhb.manage.data.dto.DepartmentDTO;
import cdu.jhb.manage.data.request.DepartmentInfoRequest;
import cdu.jhb.manage.data.request.StaffInfoRequest;
import cdu.jhb.manage.data.response.StaffInfoResponse;
import cdu.jhb.manage.api.ManageServiceI;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @description: 管理Controller
* @author jhb
* @date 2023/3/10 13:41
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("manage")
public class ManageController {

    private final ManageServiceI manageService;

    /**
     * 跳转诊所管理界面
     * @return
     */
    @GetMapping("toClinic")
    public String toClinic(){
        return "manage/manageClinic";
    }

    /**
     * 跳转科室管理界面
     * @return
     */
    @GetMapping("toOffices")
    public String toOffices(){
        return "manage/manageOffices";
    }

    /**
     * 获取科室列表
     * @param name
     * @return
     */
    @GetMapping("getDepartmentList")
    public ResponseEntity<?> getDepartmentList(@RequestParam("name")String name){
        List<DepartmentDTO> departmentDTOList = manageService.getDepartmentList(name);
        return ResponseEntity.ok(departmentDTOList);
    }

    /**
     * 保存或修改科室信息
     * @return
     */
    @PostMapping("saveDepartment")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentInfoRequest infoRequest){
        if(manageService.saveDepartment(infoRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 获取该科室的科室成员列表
     */
    @GetMapping("getDepartmentEmployeeList")
    public ResponseEntity<?> getDepartmentEmployeeList(@RequestParam("did")Long did){
        List<EmployeeDTO> employeeDTOList = manageService.getDepartmentEmployeeList(did);
        return ResponseEntity.ok(employeeDTOList);
    }

    /**
     * 删除科室信息
     */
    @GetMapping("deleteDepartmentById")
    public ResponseEntity<?> deleteDepartmentById(@RequestParam("did")Long did){
        if(manageService.deleteDepartmentById(did)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 跳转员工管理界面
     * @return
     */
    @GetMapping("toStaff")
    public String toStaff(){
        return "manage/manageStaff";
    }

    /**
     * 获取员工列表
     * @param name
     * @return
     */
    @GetMapping("getStaffList")
    public ResponseEntity<?> getStaffList(String name){
        List<EmployeeDTO> employeeDTOList = manageService.getStaffList(name);
        return ResponseEntity.ok(employeeDTOList);
    }

    /**
     * 保存或修改员工信息
     */
    @PostMapping("saveStaff")
    public ResponseEntity<?> saveStaff(@RequestBody StaffInfoRequest staffInfoRequest){
        if(manageService.saveStaff(staffInfoRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 删除用户
     * @param eid 员工ID
     * @return
     */
    @GetMapping("deleteStaff")
    public ResponseEntity<?> deleteStaff(@RequestParam("eid") Long eid,@RequestParam("aid") Long aid,@RequestParam("pid") Long pid){
        if(manageService.deleteStaff(eid,aid,pid)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 通过ID获取员工详情
     * @return
     */
    @GetMapping("getStaffInfo")
    public ResponseEntity<?> getStaffInfo(@RequestParam("id") Long id){
        StaffInfoResponse staffInfoResponse = manageService.getStaffInfo(id);
        return ResponseEntity.ok(staffInfoResponse);
    }

    /**
     * 跳转设备管理界面
     * @return
     */
    @GetMapping("toEquipment")
    public String toEquipment(){
        return "manage/manageEquipment";
    }

    /**
     * 跳转挂号费界面
     * @return
     */
    @GetMapping("toRegistration")
    public String toRegistration(){
        return "manage/manageRegistration";
    }

    /**
     * 跳转检查检验界面
     * @return
     */
    @GetMapping("toInspection")
    public String toInspection(){
        return "manage/manageInspection";
    }

    /**
     * 跳转治疗理疗界面
     * @return
     */
    @GetMapping("toTreat")
    public String toTreat(){
        return "manage/manageTreat";
    }

    /**
     * 跳转其他服务界面
     * @return
     */
    @GetMapping("toOther")
    public String toOther(){
        return "manage/manageOther";
    }

    /**
     * 跳转支付设置界面
     * @return
     */
    @GetMapping("toPay")
    public String toPay(){
        return "manage/managePay";
    }
}
