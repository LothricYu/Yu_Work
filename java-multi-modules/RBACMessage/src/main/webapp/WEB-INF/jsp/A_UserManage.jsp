<%@ page import="java.util.List" %>
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
    if (p==0)
    {
        response.getWriter().write("<script>alert('没有权限！');window.location.href='/Show?page=1';</script>");
    }
%>
<label>欢迎：</label>
<%=session1.getAttribute("user_name")
%>
<a href="/logout">退出登录</a>
<a href="javascript:" onclick="history.back();">返回</a>
<center>
    <h1>用户管理页面</h1>
    <a href="/adduser">添加用户</a>
    <table border="1" align="center" width="70%">      
        <thead>       
        <tr>        
            <th>用户id</th>
            <th>用户姓名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>所属组别</th>
            <th>角色</th>
            <th>留言数</th>
            <th>操作</th>

            <th>修改角色</th>
        </tr>

         
        </thead>
          
        <tbody id="table">

        <%
            List userList = (List) request.getAttribute("userList");

        %>
        <c:forEach items="<%=userList%>" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.tel}"/></td>
                <td><c:out value="${user.groupid}"/></td>
                <td><c:out value="${user.roleid}"/></td>
                <td><c:out value="${user.messageNum}"/></td>
                <td><a href="user_delete?deleteid=${user.id}">删除</a>
                    <a href="alluseredit?username=${user.username}">编辑</a>
                </td>
<%--                <td><a href="user_per?userid=${user.id}">修改权限</a></td>--%>
                <td><a href="user_role?userid=${user.id}&roleid=${user.roleid}">修改角色</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</center>

</body>
</html>
