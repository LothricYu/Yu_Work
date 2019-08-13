<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/8/13
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">

<%
    Object message = request.getAttribute("message");
    Object msg = request.getAttribute("msg");
%>


<center>
    <form action="/message_updata" method="post">
        <h1><label>请输入留言信息：</label></h1>
        <label>留言ID：</label><br/>
        <input readonly type="text" value="${message.id}" name="id"><br>
        <label>留言标题：</label><br/>
        <input type="text" value="${message.title}" name="title"><br>
        <label>留言内容：</label><br/>
        <input type="text" value="${message.content}" name="content"><br/>
        <br/>
        <input type="submit" value="提交">
        <a href="javascript:" onclick="history.back();">返回</a>
    </form>
</center>

</body>
</html>
