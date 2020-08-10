package com.HotelManagement.interceptor;

import com.HotelManagement.pojo.User;
import com.HotelManagement.tools.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SysInterceptor extends HandlerInterceptorAdapter {
    // 提前处理器方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        //对url进行拦截，身份验证
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(Constants.USER_SESSION);

        if (loginUser != null) {
            return true;
        } else {
            request.getRequestDispatcher("/401.jsp").forward(request, response);
            return false;
        }
    }
}
