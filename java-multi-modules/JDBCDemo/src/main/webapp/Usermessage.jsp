<%@ page import="java.util.ArrayList" %>
<%@ page import="jbdc_java.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="jbdc_java.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/7/30
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<%
    List<User> userlist = new ArrayList<>();
    Connection con=null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true","root","1244497807");
        Statement stmt = con.createStatement();
        String username= (String) session.getAttribute("user");
        System.out.println(username);
        ResultSet rs = stmt.executeQuery("SELECT id,username,password,email,telnumber,count(m_id)FROM internship.message,internship.user where `userid`=`id` and username='"+username+"'");
        while(rs.next()){
            User me = new User();
            me.setId(rs.getInt("id"));
            me.setUsername(rs.getString("username"));
            me.setPassword(rs.getString("password"));
            me.setEmail(rs.getString("email"));
            me.setTelnumber(rs.getString("telnumber"));
            me.setMessage_coumt(rs.getInt("count(m_id)"));
            userlist.add(me);
        }
        request.setAttribute("userlist",userlist);
        rs.close();
        stmt.close();
        con.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
%>

<body bgcolor="#f0f8ff">

<center>
    <h1>用户信息页面</h1>
    <table border="1" align="center" width="70%">
        <tr>
            <td>用户ID</td>
            <td>用户名</td>
            <td>用户密码</td>
            <td>用户邮箱</td>
            <td>联系电话</td>
            <td>留言数</td>
        </tr>

        <c:forEach items="${userlist}" var="userlist">
            <tr>
                <td>${userlist.id }</td>
                <td>${userlist.username }</td>
                <td>${userlist.password}</td>
                <td>${userlist.email }</td>
                <td>${userlist.telnumber}</td>
                <td>${userlist.message_coumt }</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <input type="button"value="返回留言页面"onclick="window.location.href='Show.jsp'">
    <input type="button"value="编辑用户信息"onclick="window.location.href='Updateuser.jsp'">
</center>

</body>
</html>
