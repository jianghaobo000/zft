package cdu.jhb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* @description: TODO
* @author jhb
* @date 2023/2/20 16:18
* @version 1.0
*/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 跨域配置
     *       前后端分离必须配置，出现跨域之后前端无法访问后端接口
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问资源定义： /rest/ 所有资源
        registry.addMapping("/**")
                //放行哪些原始域
                .allowedOrigins("*")
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"});
    }
}

