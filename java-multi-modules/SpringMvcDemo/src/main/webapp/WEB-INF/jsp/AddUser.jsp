<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/8/13
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="springmessage.pojo.Permission" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">

<%
    HttpSession session1=request.getSession();
    String name= (String) session1.getAttribute("user_name");
    Permission permission = (Permission) session1.getAttribute("permission");
    int p=permission.getUpdate_user_all();
    if (p==0)
    {
        response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
    }
%>

<center>
    <form action="/user_new" method="post">
        <h1><label>请输入用户信息：</label></h1>
        <label>用户名：</label><br/>
        <input type="text" value="" name="add_username"><br/>
        <label>用户密码：</label><br/>
        <input type="text" value="" name="add_password"><br/>
        <label>邮箱：</label><br/>
        <input type="text" value="" name="add_email"><br/>
        <label>电话：</label><br/>
        <input type="text" value="" name="add_telnumber"><br/>
        <label>分组：</label><br/>
        <input type="text" value="" name="add_group"><br/>

        <input type="submit" value="提交">
        <a href="javascript:" onclick="history.back();">返回</a>
    </form>
</center>

</body>
</html>
