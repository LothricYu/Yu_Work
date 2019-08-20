package com.demo.springmessage.filter;

import com.demo.springmessage.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilte implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取传来的url
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //判断是否是登录页，登录页不过滤
        //不是登录页进行验证，若未登录则跳转至登录页
        if (servletPath.equals("/login") || servletPath.equals("/checklogin")){
            chain.doFilter(request,response);
        }else {
            if (user != null){
                chain.doFilter(request,response);
            }else {
                response.getWriter().write("<script>alert('请先登录！');window.location.href='Login';</script>");
            }
        }
    }

    public void destroy() {

    }
}
