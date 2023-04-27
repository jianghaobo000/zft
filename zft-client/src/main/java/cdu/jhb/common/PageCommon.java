package cdu.jhb.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @description: 分页参数
* @author jhb
* @date 2023/04/27 10:59
* @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCommon {
    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 页数下标
     */
    private Integer pageIndex;
}
