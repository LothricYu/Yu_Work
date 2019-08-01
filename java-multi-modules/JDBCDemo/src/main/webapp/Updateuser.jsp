<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/7/31
  Time: 14:48
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
<form action="Updateuser" method="post">
    <h1><label>请输入用户信息：</label></h1>
    <label>用户名：</label><br/>
    <input type="text" name="up_username"/><br/>
    <label>密码：</label><br/>
    <input type="text" name="up_password"/><br/>
    <label>邮箱：</label><br/>
    <input type="text" name="up_email"/><br/>
    <label>联系电话：</label><br/>
    <input type="text" name="up_telphone"/><br/>
    <br/>
    <input type="submit" value="修改"/>
</form>
</center>
</body>
</html>
