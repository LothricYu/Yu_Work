<%@ page import="java.util.ArrayList" %>
<%@ page import="jbdc_java.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Lothric
  Date: 2019/7/24
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<%!  int pageSize=10;
    int pageCount;
    int showPage;

%>
<%
    List<Message> list = new ArrayList<>();
    Connection con=null;
    try{
        String username= (String) session.getAttribute("user");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true","root","1244497807");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String sql="SELECT m_id,m_title,m_detail,starttime,edittime,userid,username FROM internship.message,internship.user where userid=id and username='"+username+"'";
        String sql2="SELECT `m_id`,`m_title`,`m_detail`,`starttime`,`edittime`,`userid`,`username` FROM internship.message,internship.user where `userid`=`id` and `username`='"+username+"'"+" limit ? , 10 ";
        ResultSet rs=st.executeQuery(sql);
        rs.last();
        int recordCount=rs.getRow();
        pageCount=(recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
        String integer=request.getParameter("showPage");
        if(integer==null){
            integer="1";
        }
        try{showPage=Integer.parseInt(integer);
        }catch(NumberFormatException e){
            showPage=1;
        }
        if(showPage<=1){
            showPage=1;
        }
        if(showPage>=pageCount){
            showPage=pageCount;
        }
        int position=(showPage-1)*pageSize;

        PreparedStatement c=con.prepareStatement(sql2);
        c.setInt(1,position);
        System.out.println(c);
        ResultSet rs2=c.executeQuery();

        while(rs2.next()){
            Message me = new Message();
            me.setm_id(rs2.getInt("m_id"));
            me.setm_title(rs2.getString("m_title"));
            me.setm_detail(rs2.getString("m_detail"));
            me.setstarttime(rs2.getTimestamp("starttime"));
            me.setedittime(rs2.getTimestamp("edittime"));
            me.setuserid(rs2.getInt("userid"));
            session.setAttribute("userid",rs2.getInt("userid"));
            me.setUsername(rs2.getString("username"));
            list.add(me);
        }
        request.setAttribute("list",list);
        rs.close();
        rs2.close();
        c.close();
        st.close();
        con.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
%>

<body bgcolor="#f0f8ff">
<div>
    <form action="Loginout"method=""name="forms2">
        <label>欢迎：</label>
        <%=session.getAttribute("user")
        %>
        <a href="Usermessage.jsp?user_name=<%=session.getAttribute("user")%>">查看用户信息</a>
        <input name="out"type="submit"class="btn_grey"value="退出">
    </form>
<center>
    <h1>消息页面</h1>
    <form action="">
        <input type="button" name="add" value="新建留言" onclick="window.location.href='Add.jsp'">
    </form>
    <form action="Delete" method="post">
        <label>请输入要删除的留言ID</label>
        <input type="text" name="d_id" >
        <input type="submit"name="delete"class="btn_grey"value="删除留言">
    </form>
    <form action="Update.jsp">
        <label>请输入要编辑的留言ID</label>
        <input type="text" name="up_id" >
        <input type="submit"name="edit"class="btn_grey"value="编辑留言" >
    </form>
    <table border="1" align="center" width="70%">
        <tr>
            <td>留言ID</td>
            <td>留言标题</td>
            <td>留言内容</td>
            <td>创建时间</td>
            <td>编辑时间</td>
            <td>留言者ID</td>
            <td>留言者姓名</td>
        </tr>

        <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.m_id }</td>
                <td>${list.m_title }</td>
                <td>${list.m_detail }</td>
                <td>${list.starttime }</td>
                <td>${list.edittime }</td>
                <td>${list.userid }</td>
                <td>${list.username }</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    第<%=showPage %>页（共<%=pageCount %>页）
    <br>
    <a href="Show.jsp?showPage=1">首页</a>
    <a href="Show.jsp?showPage=<%=showPage-1%>">上一页</a>
    <%
        for(int i=1;i<=pageCount;i++){
    %>
    <a href="Show.jsp?showPage=<%=i%>"><%=i%></a>
    <% }
    %>
    <a href="Show.jsp?showPage=<%=showPage+1%>">下一页</a>
    <a href="Show.jsp?showPage=<%=pageCount%>">末页</a>

    <form action="" method="get">
        跳转到第<input type="text" name="showPage" size="4">页
        <input type="submit" name="submit" value="跳转">
    </form>
</center>
</body>
</html>
