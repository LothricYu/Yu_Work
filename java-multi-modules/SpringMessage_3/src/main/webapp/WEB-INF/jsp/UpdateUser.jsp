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
    <form action="/fileUpload" method="post" enctype="multipart/form-data">
        <label>上传图片</label>
        <input type="file" name="file"/>
        <input type="submit" value="上传"/>
    </form>
    <form action="/user_updata" method="post">
        <h1><label>请输入用户信息：</label></h1>
<%--        <form action="" method="post" enctype="multipart/form-data">--%>
<%--            上传图片: <input type="file" name="file" accept="image/*" />--%>
<%--            <input type="submit" value="立刻上传">--%>
<%--        </form>--%>
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
        <input readonly type="text" value="${user.messageNum}" name="messageNum"><br>
        <label>头像：</label><br/>
        <img src="${user.photo_path}" height="150px" width="150px" alt="无头像"/>
        <br>
        <a href="/choosePhoto?userid=${user.id}">选择头像</a><br>
        <input type="submit" value="提交">
        <a href="javascript:" onclick="history.back();">返回</a>
    </form>
</center>
</body>
</html>
