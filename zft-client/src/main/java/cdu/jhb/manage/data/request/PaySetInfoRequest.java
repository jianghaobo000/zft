package cdu.jhb.manage.data.request;

import cdu.jhb.charge.data.dto.PayDictDTO;
import cdu.jhb.manage.data.dto.PaySetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @description: 支付设置请求参数
* @author jhb
* @date 2023/05/03 21:06
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaySetInfoRequest {

    /**
     * 支付设置DTO
     */
    private PaySetDTO paySetDTO;

    /**
     * 支付字典集合
     */
    private List<PayDictDTO> payDictDTOList;
}
