package cdu.jhb.web.tenant;

import cdu.jhb.tenant.api.TenantServiceI;
import cdu.jhb.tenant.data.dto.TenantDTO;
import cdu.jhb.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 租户Controller
* @author jhb
* @date 2023/03/31 18:33
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("tenant")
public class TenantController {

    private final TenantServiceI tenantService;

    /**
     * 根据ID获取租户信息
     * @return
     */
    @GetMapping("getTenant")
    public TenantDTO getTenant(Long tenantId){
        return tenantService.getTenant(tenantId);
    }

    /**
     * 保存诊所信息
     * @return
     */
    @PostMapping("saveTenant")
    public ResponseEntity<?> saveTenant(@RequestBody TenantDTO tenantDTO){
        if(tenantService.saveTenant(tenantDTO)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * 获取当前诊所信息
     * @return
     */
    @GetMapping("getTenantInfo")
    public ResponseEntity<?> getTenantInfo(){
        TenantDTO tenantDTO = tenantService.getTenant(RedisUtil.getLocalTenantId());
        return ResponseEntity.ok(tenantDTO);
    }
}
