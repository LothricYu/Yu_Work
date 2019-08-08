package com.demo.springmessage.filter;

import com.demo.springmessage.pojo.Permission;
import com.demo.springmessage.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/useredit")
public class editpersonfilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest request1=(HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String servletPath=request1.getServletPath();
        User user = (User) request1.getSession().getAttribute("user");
        int id=user.getId();
        System.out.println(id);
        Permission permission= (Permission) request1.getSession().getAttribute("permission");
        int p=permission.getUpdate_user_person();
        if(p==1){
            chain.doFilter(request,response);
        }
        else{
            response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
        }
    }
    public void destroy() {
    }
}
