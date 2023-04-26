package cdu.jhb.util;

import cdu.jhb.common.Constant;

import java.util.HashMap;
import java.util.Map;

/**
* @description: 计算
* @author jhb
* @date 2023/04/26 16:26
* @version 1.0
*/
public class Calculate {

    /**
     * 通过大小单位转换比计算库存数
     * @param largeNum 大单位数量
     * @param smallNum 小单位数量
     * @param dosageFrom 大小单位转换比
     * @return
     */
    public static Map<String,Integer> inventoryQuantity(Integer largeNum, Integer smallNum, Integer dosageFrom){
        Map<String,Integer> map = new HashMap<>();
        if(smallNum < dosageFrom){
            map.put(Constant.LARGE_NUM,largeNum);
            map.put(Constant.SMALL_NUM,smallNum);
        }else{
            map.put(Constant.LARGE_NUM,largeNum + smallNum/dosageFrom);
            map.put(Constant.SMALL_NUM,smallNum%dosageFrom);
        }
        return map;
    }

}
