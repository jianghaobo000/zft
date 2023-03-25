package cdu.jhb.web.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 管理Controller
* @author jhb
* @date 2023/3/10 13:41
* @version 1.0
*/
@Controller
@RequestMapping("manage")
public class ManageController {

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
     * 跳转员工管理界面
     * @return
     */
    @GetMapping("toStaff")
    public String toStaff(){
        return "manage/manageStaff";
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

    /**
     * 跳转定价设置界面
     * @return
     */
    @GetMapping("toBid")
    public String toBid(){
        return "manage/manageBid";
    }

    /**
     * 跳转医保限价界面
     * @return
     */
    @GetMapping("toLimit")
    public String toLimit(){
        return "manage/manageLimit";
    }
}
