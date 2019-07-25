<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/7/24
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
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
<script>
    function check() {
        window.location.href='Shop.jsp';
    }
</script>
<div id="ri">
    <form action="Loginout"method="get"name="forms2">
        <label>欢迎：</label>
<%--        <%String i= (String) session.getAttribute("user");--%>
<%--            if (i==null || i.equals(""))--%>
<%--            {--%>
<%--                response.setContentType("text/html;charset=utf-8");--%>
<%--                response.getWriter().print("<script>alert('请登录');window.location.href='Deng.jsp';</script>");--%>
<%--            }--%>
<%--        %>--%>
        <%=session.getAttribute("user")%>
        <input name="out"type="submit"class="btn_grey"value="退出">
    </form>
</div>

<center>
    <h1>购物车页面</h1>
    <%
        ArrayList Nu= (ArrayList) request.getAttribute("list");
        request.setAttribute("Nu",Nu);
    %>
    <table border="1" width="300">
        <tr>
            商品名：
        </tr>
        <br>
        <c:forEach var="goods" items="${Nu}">
        <tr>
            <td>
                <c:out value="${goods}" />
            </td>
        </tr>
        </c:forEach>
    </table>
        <br>
        <input type="button"value="返回购物页面"onclick="check()">
</center>
</body>
</html>
