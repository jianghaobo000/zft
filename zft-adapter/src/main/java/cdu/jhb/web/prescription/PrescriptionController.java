package cdu.jhb.web.prescription;

import cdu.jhb.prescription.api.PrescriptionServiceI;
import cdu.jhb.prescription.data.request.SaveVisitInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 医嘱处方控制器
* @author jhb
* @date 2023/05/04 21:09
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("prescription")
public class PrescriptionController {

    private final PrescriptionServiceI prescriptionService;

    /**
     * 保存就诊信息
     * @return
     */
    @PostMapping("saveVisit")
    public ResponseEntity<?> saveVisit(@RequestBody SaveVisitInfoRequest request){
        if(prescriptionService.saveVisit(request)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
