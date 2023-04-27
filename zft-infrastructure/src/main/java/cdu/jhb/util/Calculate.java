package cdu.jhb.util;

import cdu.jhb.common.Constant;
import org.mockito.internal.stubbing.answers.ThrowsException;

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
        if(smallNum < dosageFrom && smallNum >= 0){
            map.put(Constant.LARGE_NUM,largeNum);
            map.put(Constant.SMALL_NUM,smallNum);
        }else{
            if(smallNum >=dosageFrom){
                map.put(Constant.LARGE_NUM,largeNum + smallNum/dosageFrom);
                map.put(Constant.SMALL_NUM,smallNum%dosageFrom);
            }
            if(smallNum < 0 ){
                map.put(Constant.LARGE_NUM,largeNum + smallNum/dosageFrom - 1);
                map.put(Constant.SMALL_NUM,smallNum + (smallNum/dosageFrom - 1) * dosageFrom * (-1));
            }
        }
        return map;
    }

    /**
     * 计算分页数据
     * @param pageIndex
     * @param pageSize
     * @param listSize
     * @return
     */
    public static Map<String,Integer> assemblyPagination(Integer pageIndex,Integer pageSize,Integer listSize){
        int startIndex = (pageIndex - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, listSize);
        Map<String,Integer> pageMap = new HashMap<>();
        pageMap.put(Constant.START_INDEX,startIndex);
        pageMap.put(Constant.END_INDEX,endIndex);
        return pageMap;
    }

}
