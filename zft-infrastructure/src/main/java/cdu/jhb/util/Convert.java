package cdu.jhb.util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;

import java.util.List;
import java.util.stream.Collectors;

/**
* @description: 自定义类型转换工具类
* @author jhb
* @date 2023/04/12 23:34
* @version 1.0
*/
public class Convert {

    /**
     * 实体类型转换器
     * @param source 转换对象
     * @param targetClass 转换类型
     * @return
     */
    public static <S, T> T entityConvert(S source, Class<T> targetClass) {
        return DozerBeanMapperBuilder.buildDefault().map(source, targetClass);
    }

    /**
     * 列表类型转换器
     * @param sourceList 转换对象
     * @param targetClass 转换类型
     * @return
     */
    public static <S, T> List<T> listConvert(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(source -> DozerBeanMapperBuilder.buildDefault().map(source, targetClass)).collect(Collectors.toList());
    }
}
