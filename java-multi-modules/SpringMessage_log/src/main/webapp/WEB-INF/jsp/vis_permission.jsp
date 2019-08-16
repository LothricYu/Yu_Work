<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.springmessage.pojo.Permission" %>
<%@ page import="com.demo.springmessage.pojo.Permissionrole" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Permissionrole permission= (Permissionrole) request.getSession().getAttribute("vis_permission");
    int roleId = Integer.parseInt(request.getParameter("roleid"));
%>
<center>
    <form action="/vis_per" method="post">
        角色权限：
        <label><input type="checkbox" <%if (permission.getSearch_m()==1) out.print("checked='checked'");%> name="Search_m"/>查看留言</label>
        <label><input type="checkbox" <%if (permission.getAdd_m()==1) out.print("checked='checked'");%> name="Add_m"/>添加留言</label>
        <label><input type="checkbox" <%if (permission.getUpdate_m_all()==1) out.print("checked='checked'");%> name="Update_m_all"/>编辑任意留言</label>
        <label><input type="checkbox" <%if (permission.getDelete_m_all()==1) out.print("checked='checked'");%> name="Delete_m_all"/>删除任意留言</label>
        <label><input type="checkbox" <%if (permission.getUpdate_user_all()==1) out.print("checked='checked'");%> name="Update_user_all"/>修改用户信息</label>
        <label><input type="checkbox" <%if (permission.getUpdate_m_person()==1) out.print("checked='checked'");%> name="Update_m_person"/>编辑个人留言</label>
        <label><input type="checkbox" <%if (permission.getDelete_m_person()==1) out.print("checked='checked'");%> name="Delete_m_person"/>删除个人留言</label>
        <label><input type="checkbox" <%if (permission.getUpdate_m_group()==1) out.print("checked='checked'");%> name="Update_m_group"/>编辑同组用户留言</label>
        <label><input type="checkbox" <%if (permission.getUpdate_user_person()==1) out.print("checked='checked'");%> name="Update_user_person"/>编辑个人信息</label>
        <input type="submit" value="提交修改">
    </form>
</center>
</body>
</html>

