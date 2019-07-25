<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Lothric--%>
<%--  Date: 2019/7/24--%>
<%--  Time: 15:59--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <head>    <title>登录页面</title>  </head>

<body bgcolor="#f0f8ff">

<%
    String to=(String)session.getAttribute("user");
    if (to!=null)
    {
        RequestDispatcher de=request.getRequestDispatcher("Shop.jsp");
        de.forward(request,response);
    }
%>

<center>
    <h1>登陆页面</h1>

<form action="MyServlet" method="post" >
    <table>
        <tr><td>用户名</td><td><input type="text"name="user"maxlength="20"></td></tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit"value="登 录">
            </td>
        </tr>
    </table>
</form>
</center>

</body>
</html>
