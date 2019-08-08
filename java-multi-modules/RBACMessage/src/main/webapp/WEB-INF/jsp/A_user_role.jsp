<%@ page import="com.demo.springmessage.pojo.Permission" %>
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
    if (!name.equals("admin"))
    {
        response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
    }
%>
<label>欢迎：</label>
<%=session1.getAttribute("user_name")
%>

<%
    int roleid= Integer.parseInt(request.getParameter("roleid"));
    int id= Integer.parseInt(request.getParameter("userid"));
    request.getSession().setAttribute("roleid",roleid);
    request.getSession().setAttribute("userid",id);

%>
<center>
    <h1>角色修改界面</h1>
    <form action="/user_roleup" method="post">
        <input type="radio" name="ur" value="ad" <% if(roleid==2){ %> checked <% } %>>管理员<br>
        <input type="radio" name="ur" value="normal"<% if(roleid==3){ %> checked <% } %>>一般用户<br>
        <input type="radio" name="ur" value="vis"<% if(roleid==4){ %> checked <% } %>>游客<br>
        <input type="submit" name="roletijiao" value="提交"><br>
    </form>
    <a href="javascript:" onclick="history.back();">返回</a>
</center>
</body>
</html>
