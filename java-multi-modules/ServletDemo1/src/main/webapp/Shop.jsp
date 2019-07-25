<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/7/24
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        #ri{
            width: 150px;
            height: 50px;
            position: absolute;
            top: 0px;
            right:0px;

        }
    </style>
</head>
<body bgcolor="#f0f8ff">

<div id="ri">
    <form action="Loginout"method="get"name="forms2">
        <label>欢迎：</label>
<%--        <%String i= (String) session.getAttribute("user");--%>
<%--        if (i==null || i.equals(""))--%>
<%--        {--%>
<%--            response.setContentType("text/html;charset=utf-8");--%>
<%--            response.getWriter().print("<script>alert('请登录');window.location.href='Deng.jsp';</script>");--%>
<%--        }--%>
<%--        %>--%>
        <%=session.getAttribute("user")

        %>
    <input name="out"type="submit"class="btn_grey"value="退出">
    </form>

</div>
<center>
    <h1>购物页面</h1>
    <form action="ShopList"method="post"name="formshop" onsubmit="check()">
        <label>输入商品名称：</label><input name="goods"type="text"id="goods"maxlength="20">
        <input name="add"type="submit"class="btn_grey"value="添加到购物车">
    </form>
    <form action="ShopList"method="get"name="formshop">
    <input name="detail"type="submit"class="btn_grey"value="查看购物车列表">
    </form>
</center>
</body>
</html>
