package cdu.jhb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @description: 网页拦截器
 * @author jhb
 * @date 2023/05/05 01:44
 * @version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //防止图片被拦截
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**");
    }

    //添加网页拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns是添加拦截路径 excludePathPatterns是排除拦截路径
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/account/login", "/account/getImg" , "/bootstrap/**","/css/**", "/js/**", "/img/**","/layui/**");
    }

}

