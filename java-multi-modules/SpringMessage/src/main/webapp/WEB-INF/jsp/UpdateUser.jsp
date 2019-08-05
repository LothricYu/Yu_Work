<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">

<%
    Object user = session.getAttribute("user");
%>


<center>
    <form action="/user_updata" method="post">
        <h1><label>请输入用户信息：</label></h1>
        <label>用户ID：</label><br/>
        <input readonly type="text" value="${user.id}" name="id"><br/>
        <label>用户名：</label><br/>
        <input type="text" value="${user.username}" name="username"><br/>
        <label>密码：</label><br/>
        <input type="text" value="${user.password}" name="password"><br/>
        <label>邮箱：</label><br/>
        <input type="text" value="${user.email}" name="email"><br/>
        <label>联系电话：</label><br/>
        <input type="text" value="${user.tel}" name="tel"><br/>
        <label>用户留言数：</label><br/>
        <input readonly type="text" value="${user.messageNum}" name="messageNum">
        <br>
        <input type="submit" value="提交">
        <a href="javascript:" onclick="history.back();">返回</a>
    </form>
</center>
</body>
</html>
