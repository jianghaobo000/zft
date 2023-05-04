//package cdu.jhb.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
//* @description: Security配置类
//* @author jhb
//* @date 2023/05/04 12:32
//* @version 1.0
//*/
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        //请求规则(放行URL路径)
////        http.authorizeRequests()
////                .antMatchers("/account/getImg").permitAll()
////                .antMatchers(HttpMethod.GET,"/account/login").permitAll()
////                .antMatchers(HttpMethod.POST,"/account/login").permitAll();
////
////        //没有权限就进入登录界面，定制登录页
////        http.formLogin()
////                //自定义登录页面（需要URL路径）
////                .loginPage("/account/login")
////                .loginProcessingUrl("/account/login")
////                .defaultSuccessUrl("/clinic/toClinic",true)
////                .failureUrl("/account/login")
////                .permitAll()
////                .and().authorizeRequests().anyRequest().authenticated()
////                .and().headers().frameOptions().sameOrigin()
////                .and().csrf().disable();
////        //注销
////        http.logout().logoutUrl("/account/logout");
////    }
////
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        // 配置拦截忽略文件夹
////        web.ignoring().antMatchers("/bootstrap/**", "/js/**","/css/**","/js/**","/fonts/**","/layui/**","login.html");
////    }
////
////    //配置采用哪种密码加密算法
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        //不使用密码加密
////        //return NoOpPasswordEncoder.getInstance();
////
////        //使用默认的BCryptPasswordEncoder加密方案
////        return new BCryptPasswordEncoder();
////
////        //strength=10，即密钥的迭代次数(strength取值在4~31之间，默认为10)
////        //return new BCryptPasswordEncoder(10);
////
////        //利用工厂类PasswordEncoderFactories实现,工厂类内部采用的是委派密码编码方案.
////        //return PasswordEncoderFactories.createDelegatingPasswordEncoder();
////
////    }
//
//
//}
