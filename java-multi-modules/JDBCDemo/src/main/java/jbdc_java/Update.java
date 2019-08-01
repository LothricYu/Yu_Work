package jbdc_java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String name= (String) session.getAttribute("user");
        System.out.println(name);
        int up_id= (int) session.getAttribute("up_id");
        String m_title=request.getParameter("up_title");
        String m_detail=request.getParameter("up_detail");
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true","root","1244497807");
            String sql="update internship.message set m_title=?,m_detail=?,edittime=?" +
                    "where m_id='"+up_id+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,m_title);
            ps.setString(2,m_detail);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Timestamp edittime= Timestamp.valueOf(df.format(new Date()));
            ps.setTimestamp(3,edittime);
            ps.executeUpdate();
            ps.close();
            con.close();
            session.setAttribute("user",name);
            response.sendRedirect("Show.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
