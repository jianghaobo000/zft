package cdu.jhb.util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;

import java.util.List;
import java.util.stream.Collectors;

/**
* @description: 自定义类型转换器
* @author jhb
* @date 2023/04/12 23:34
* @version 1.0
*/
public class Convert {

    public static <S, T> T entityConvert(S source, Class<T> targetClass) {
        return DozerBeanMapperBuilder.buildDefault().map(source, targetClass);
    }

    public static <S, T> List<T> listConvert(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(source -> DozerBeanMapperBuilder.buildDefault().map(source, targetClass)).collect(Collectors.toList());
    }
}
