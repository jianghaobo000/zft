package cdu.jhb.web.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @description: 统计
* @author jhb
* @date 2023/03/26 00:02
* @version 1.0
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("statistics")
public class StatisticsController {
    /**
     * 跳转统计界面
     * @return
     */
    @GetMapping("toStatistics")
    public String toPatient(){
        return "statistics/statistics";
    }
}
