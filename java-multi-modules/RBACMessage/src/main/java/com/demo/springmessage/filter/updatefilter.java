package com.demo.springmessage.filter;

import com.demo.springmessage.pojo.Permission;
import com.demo.springmessage.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/message_edit")
public class updatefilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest request1=(HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String servletPath=request1.getServletPath();
        User user = (User) request1.getSession().getAttribute("user");
        Permission permission= (Permission) request1.getSession().getAttribute("permission");
        int user_groupid= user.getGroupid();
        int m_groupid= Integer.parseInt(request.getParameter("m_groupid"));
        int p=permission.getUpdate_m_all();
        int p1=permission.getUpdate_m_group();
        if(user_groupid==3 || (user_groupid==m_groupid && p1==1 )|| p==1){
            chain.doFilter(request,response);
        }
        else{
            response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
        }

    }
    public void destroy() {

    }
}
