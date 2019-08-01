<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/7/30
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>

</head>

<body bgcolor="#f0f8ff">
<center>
<form action="AddServlet" method="post">
    <h1><label>请输入留言信息：</label></h1>
    <label>留言标题：</label><br/>
    <input type="text" name="m_title"/><br/>
    <label>留言内容：</label><br/>
    <input type="text" name="m_detail"/><br/>
    <br/>
    <input type="submit" value="提交"/>
</form>
</center>
</body>
</html>
