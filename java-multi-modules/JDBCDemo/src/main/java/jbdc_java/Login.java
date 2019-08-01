package jbdc_java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("user");
        if(name.equals("")){
            response.getWriter().write("<script>alert('用户名为空！');window.location.href='Deng.jsp';</script>");
        }
        if(!(name.equals("you")||name.equals("robot1")||name.equals("robot2"))){
            response.getWriter().write("<script>alert('登录失败！');window.location.href='Deng.jsp';</script>");
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("user",name);
            response.sendRedirect("Show.jsp");
        }
    }
}
