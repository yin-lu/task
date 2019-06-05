package com.yl.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception err)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object obj, ModelAndView mav) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
//    获取request的cookie
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            System.out.println("没有cookie==============");
        } else {
//      遍历cookie如果找到登录状态则返回true执行原来controller的方法
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {

                    return true;
                }
            }
        }
//    没有找到登录状态则重定向到登录页，返回false，不执行原来controller的方法
        response.sendRedirect("/login");
        return false;
    }
}

