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

public class AddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true","root","1244497807");
            HttpSession session=request.getSession();
            String n= (String) session.getAttribute("user");

            String sql2 = "SELECT id FROM internship.user,internship.message WHERE username='"+n+"'";
            PreparedStatement ps2=con.prepareStatement(sql2);
            ResultSet rs=ps2.executeQuery();
            int userid=0;
            while (rs.next()) {
                userid = rs.getInt("id");
            }

            String sql = "insert into internship.message(m_title,m_detail,starttime,edittime,userid) values(?,?,?,?,?)";
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            String m_title= request.getParameter("m_title");
            String m_detail= request.getParameter("m_detail");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp starttime= Timestamp.valueOf(df.format(new Date()));
            Timestamp edittime=starttime;
            ps.setString(1,m_title);
            ps.setString(2,m_detail);
            ps.setTimestamp(3,starttime);
            ps.setTimestamp(4,edittime);
            ps.setInt(5,userid);
            int result = ps.executeUpdate();
            ps.close();
            con.close();
        }catch(Exception ignored){
        }
        response.sendRedirect("Show.jsp");

    }
}
