package springmessage.filter;

import springmessage.pojo.Permission;
import springmessage.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class deleteFilter implements Filter {
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
        int userid= Integer.parseInt(request.getParameter("userid"));
        Permission permission= (Permission) request1.getSession().getAttribute("permission");
        int p=permission.getDelete_m_person();
        int p1=permission.getDelete_m_all();
        if(p1==1 || (p==1 && userid==id)){
            chain.doFilter(request,response);
        }
        else{
            response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
        }
    }
    public void destroy() {
    }
}
