<%@ page import="java.util.List" %>
<%@ page import="com.demo.springmessage.pojo.User" %><%--
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
<a href="/Show?page=1">返回留言页面</a>

<form action="/queryoperationbyusername">
    <input type="text" name="username"/>
    <button type="submit">查询</button>
</form>

<%--<form action="/querymessagebyusername">--%>
<%--    <input type="text" name="username"/>--%>
<%--    <button type="submit">查询</button>--%>
<%--</form>--%>

<center>
    <h1>操作记录页面<h1>
<table border="1" align="center" width="90%">      
    <thead>       
    <tr>        
        <th>操作记录id</th>
        <th>操作用户id</th>
        <th>操作用户名</th>
        <th>操作类型</th>
        <th>操作时间</th>
        <th>耗时</th>
        <th>返回结果</th>
    </tr>

     
    </thead>
      
    <tbody id="table">

    <%
        List operationList = (List) request.getAttribute("operationList");
        Object msg = request.getAttribute("msg");
    %>
    <c:forEach items="<%=operationList%>" var="operation">
        <tr>
            <td><c:out value="${operation.op_id}"/></td>
            <td><c:out value="${operation.op_user_id}"/></td>
            <td><c:out value="${operation.op_user_name}"/></td>
            <td><c:out value="${operation.op_type}"/></td>
            <td><c:out value="${operation.time}"/></td>
            <td><c:out value="${operation.cost_time}ms"/></td>
            <td><c:out value="${operation.result}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<c:if test="${requestScope.page > 1 }">
    <a href="operationshow?page=${requestScope.page - 1}"> 上一页 </a>
</c:if>
<div style="margin: 0 15px 0 15px ;display:inline">
    第 ${requestScope.page} 页
</div>
<c:if test="${requestScope.count > requestScope.page * 10}">
    <a href="operationshow?page=${requestScope.page + 1}"> 下一页 </a>
</c:if>
</center>

</body>
</html>
