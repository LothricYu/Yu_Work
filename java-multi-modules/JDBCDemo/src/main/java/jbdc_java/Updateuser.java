package jbdc_java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class Updateuser extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Connection con=null;
        PreparedStatement ps = null;
        HttpSession session=request.getSession();
        int id= (int) session.getAttribute("userid");
        String username=request.getParameter("up_username");
        String password=request.getParameter("up_password");
        String email=request.getParameter("up_email");
        String telphone=request.getParameter("up_telphone");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true","root","1244497807");
            String sql="update internship.user set username=?,password=?,email=?,telnumber=? where id='"+id +"'";
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,telphone);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        HttpSession session2 = request.getSession();
        session.setAttribute("user",username);
        response.sendRedirect("Usermessage.jsp");
    }
}
