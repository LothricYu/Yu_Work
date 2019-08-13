<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/8/13
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="springmessage.pojo.Permission" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    HttpSession session1=request.getSession();
    String name= (String) session1.getAttribute("user_name");
    Permission permission = (Permission) session1.getAttribute("permission");
    int p=permission.getUpdate_user_all();
    if (!name.equals("admin"))
    {
        response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
    }
%>
<body>

<a href="/ad?roleid=2">管理员</a>
<a href="/no?roleid=3">一般用户</a>
<a href="/vis?roleid=4">游客</a>


</body>
</html>

