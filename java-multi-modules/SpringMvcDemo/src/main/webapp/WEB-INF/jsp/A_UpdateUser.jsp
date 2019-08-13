<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/8/13
  Time: 9:03
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
<label>欢迎：</label>
<%=session1.getAttribute("user_name")
%>
<%
    //    User user= (User) request.getSession().getAttribute("A_user");
//    int id=user.getId();
//    String u_name=user.getUsername();
//    String password=user.getPassword();
//    String email=user.getEmail();
//    String tel=user.getTel();
//    int groupid=user.getGroupid();
%>
<center>
    <h1>管理员界面</h1>
    <form action="/A_user_updata" method="post">
        <h3><label>请输入用户信息：</label></h3>
        <label>用户ID：</label><br/>
        <input readonly type="text" value="${A_user.id}" name="id"><br/>
        <label>用户名：</label><br/>
        <input type="text" value="${A_user.username}" name="username"><br/>
        <label>密码：</label><br/>
        <input type="text" value="${A_user.password}" name="password"><br/>
        <label>邮箱：</label><br/>
        <input type="text" value="${A_user.email}" name="email"><br/>
        <label>联系电话：</label><br/>
        <input type="text" value="${A_user.tel}" name="tel"><br/>
        <label>用户留言数：</label><br/>
        <input readonly type="text" value="${A_user.messageNum}" name="messageNum">
        <br>
        <label>组别：</label><br/>
        <input type="text" value="${A_user.groupid}" name="groupid"><br>
        <input type="submit" value="提交">
        <a href="javascript:" onclick="history.back();">返回</a>
    </form>
</center>
</body>
</html>
