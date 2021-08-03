package com.example.springboot.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author by LMGD
 * @date 2021-07-15 09:13
 * @description 拦截器
 */
public class LoginHandelInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            request.setAttribute("msg", "您没有权限,请先登入!!");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
