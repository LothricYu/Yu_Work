<%@ page import="com.demo.springmessage.pojo.User" %>
<%@ page import="java.util.List" %><%--
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


<center>
    <h1>账单记录<h1>
<table border="1" align="center" width="90%">      
    <thead>       
    <tr>        
        <th>账单id</th>
        <th>类型</th>
        <th>数值</th>
        <th>时间</th>
        <th>操作</th>
    </tr>

     
    </thead>
      
    <tbody id="table">

    <%
        List billList = (List) request.getAttribute("billList");
    %>
    <c:forEach items="<%=billList%>" var="bill">
        <tr>
            <td><c:out value="${bill.bill_id}"/></td>
            <td><c:out value="${bill.bill_type}"/></td>
            <td><c:out value="${bill.bill_amount}元"/></td>
            <td><c:out value="${bill.bill_date}"/></td>
            <td><a href="">详细</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<c:if test="${requestScope.page > 1 }">
    <a href="Showbill?userid=${requestScope.userid}&page=${requestScope.page - 1}"> 上一页 </a>
</c:if>
<div style="margin: 0 15px 0 15px ;display:inline">
    第 ${requestScope.page} 页
</div>
<c:if test="${requestScope.count > requestScope.page * 10}">
    <a href="Showbill?userid=${requestScope.userid}&page=${requestScope.page + 1}"> 下一页 </a>
</c:if>
</center>

</body>
</html>
