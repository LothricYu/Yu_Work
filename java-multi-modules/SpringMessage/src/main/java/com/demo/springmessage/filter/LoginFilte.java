package com.demo.springmessage.filter;

import com.demo.springmessage.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter
public class LoginFilte implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (servletPath.equals("/login") || servletPath.equals("/checklogin")){
            chain.doFilter(request,response);
        }else {
            if (user != null){
                chain.doFilter(request,response);
            }else {
                response.getWriter().print("请先登录");
                request.getRequestDispatcher("/login").forward(request,response);
            }
        }
    }

    public void destroy() {

    }
}
