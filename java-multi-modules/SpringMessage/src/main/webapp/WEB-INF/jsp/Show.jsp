<%@ page import="java.util.List" %>
<%@ page import="com.demo.springmessage.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Soung
  Date: 2019/7/30
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">
<%
    HttpSession session1=request.getSession();
    session1.getAttribute("user_name");
%>
<label>欢迎：</label>
<%=session1.getAttribute("user_name")
%>
<a href="/logout">退出登录</a>
<a href="/newmessage">新建留言</a>
<a href="/useredit">编辑用户信息</a>

<form action="/querymessagebyusername">
    <input type="text" name="username"/>
    <button type="submit">查询</button>
</form>

<center>
    <h1>留言页面<h1>
<table border="1" align="center" width="70%">      
    <thead>       
    <tr>        
        <th>留言id</th>
        <th>留言标题</th>
        <th>留言内容</th>
        <th>创建时间</th>
        <th>编辑时间</th>
        <th>创建者</th>
        <th>操作</th>
    </tr>

     
    </thead>
      
    <tbody id="table">

    <%
        List messageList = (List) request.getAttribute("messageList");
        Object msg = request.getAttribute("msg");
    %>
    <c:forEach items="<%=messageList%>" var="message">
        <tr>
            <td><c:out value="${message.id}"/></td>
            <td><c:out value="${message.title}"/></td>
            <td><c:out value="${message.content}"/></td>
            <td><c:out value="${message.createTime}"/></td>
            <td><c:out value="${message.editTime}"/></td>
            <td><c:out value="${message.writer}"/></td>
            <td><a href="message_delete?deleteid=${message.id}">删除</a>
                <a href="message_edit?editid=${message.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<c:if test="${requestScope.page > 1 }">
    <a href="Show?page=${requestScope.page - 1}"> 上一页 </a>
</c:if>
<div style="margin: 0 15px 0 15px ;display:inline">
    第 ${requestScope.page} 页
</div>
<c:if test="${requestScope.count > requestScope.page * 10}">
    <a href="Show?page=${requestScope.page + 1}"> 下一页 </a>
</c:if>
</center>

</body>
</html>
