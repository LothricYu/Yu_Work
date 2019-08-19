<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.demo.springmessage.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    List photolist= (List) request.getSession().getAttribute("photolist");
    Object user = session.getAttribute("user");
%>
<body>
<%--<form action="updatephoto?userid=${user.id}" method="post">--%>
<%--<c:forEach items="<%=photolist%>" var="photo">--%>
<%--        <input type="radio" name="ph" value="${photo.photo_path}" >图片<br>--%>
<%--        <img src="${photo.photo_path}" height="150px" width="150px"/><br>--%>
<%--</c:forEach>--%>
<%--    <input type="submit" name="roletijiao" value="提交"><br>--%>
<%--</form>--%>
<table border="1" align="center" width="90%">      
    <thead>       
    <tr>        
        <th>图片ID</th>
        <th>图片展示</th>
        <th>操作</th>
    </tr>

    </thead>
      
    <tbody id="table">

    <c:forEach items="<%=photolist%>" var="photo">
        <tr>
            <td><c:out value="${photo.photo_id}"/></td>
            <td><img src="${photo.photo_path}" height="150px" width="150px"/></td>
            <td><a href="updatephoto?userid=${user.id}&path=${photo.photo_path}">设为头像</a>
                <a href="deletephoto?photo_id=${photo.photo_id}">删除头像</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>


