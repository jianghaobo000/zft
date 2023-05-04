package cdu.jhb.config;

import cdu.jhb.common.Constant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 登录验证拦截
 * @author jhb
 * @date 2023/05/05 01:44
 * @version 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //拦截未登录的用户
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute(Constant.EMPLOYEE);
        if (loginUser == null) {
            request.getRequestDispatcher("/account/login").forward(request, response);
            return false;
        }
        else {
            return true;
        }
    }
}
