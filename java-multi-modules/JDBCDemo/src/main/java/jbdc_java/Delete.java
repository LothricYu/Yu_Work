package jbdc_java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Delete extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String id=request.getParameter("d_id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true", "root", "1244497807");
            String sql2 = "DELETE FROM internship.message WHERE m_id='" +id+ "'";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            int rs = ps2.executeUpdate();
            ps2.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("Show.jsp");
    }
}
