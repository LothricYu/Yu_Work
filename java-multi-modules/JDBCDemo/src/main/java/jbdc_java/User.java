package jbdc_java;

import java.sql.*;

public class User {
    private String username;
    private int id;
    private String password;
    private String email;
    private String telnumber;
    private int Message_coumt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public int getMessage_coumt() {
        return Message_coumt;
    }

    public void setMessage_coumt(int message_coumt) {
        Message_coumt = message_coumt;
    }

    public User login(String username, String password) {
        User userinfo = new User();
        userinfo.setUsername("0");
        Connection con = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true", "root", "1244497807");
                String sql = "select * from internship.user where username=? and password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                while (rs.next()) {
                    userinfo.setUsername(rs.getString("username"));
                    System.out.println(userinfo.getUsername());
                    userinfo.setPassword(rs.getString("password"));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {

        }
        return userinfo;
    }
}
