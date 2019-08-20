<%@ page import="com.demo.springmessage.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">

<%
    Object user = session.getAttribute("user");
    User user1= (User) request.getSession().getAttribute("user");
%>
<script type="text/javascript">
    function diag()
    {
        var activity = window.prompt('请输入充值金额：');
        if(activity!="")
        {
            alert("充值成功");
            window.location.href = 'chongzhi?number=' + window.encodeURIComponent(activity);
        }
        else{
            alert("输入为空");
        }
    }

</script>


<center>
    <form action="/fileUpload" method="post" enctype="multipart/form-data">
        <label>上传图片</label>
        <input type="file" name="file"/>
        <input type="submit" value="上传"/>
    </form>
    <form action="/user_updata" method="post">
<%--        <form action="" method="post" enctype="multipart/form-data">--%>
<%--            上传图片: <input type="file" name="file" accept="image/*" />--%>
<%--            <input type="submit" value="立刻上传">--%>
<%--        </form>--%>
        <label>头像：</label><br/>
        <img src="${user.photo_path}" height="150px" width="150px" alt="无头像"/>
        <br>
        <a href="/choosePhoto?userid=${user.id}">选择头像</a><br>
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
        <label>用户余额：<%if (user1.getBalance()==null) out.print("0元");%>${user.balance}</label><br/>
        <input type="button" name="chongzhi" value="充值" onclick="diag()"/>
    <a href="/Showbill?userid=${user.id}&page=1">账单记录</a>
    <br>
    <br>
        <input type="submit" value="提交">
        <a href="/Show?page=1">返回留言页面</a>
    </form>
</center>
</body>
</html>
