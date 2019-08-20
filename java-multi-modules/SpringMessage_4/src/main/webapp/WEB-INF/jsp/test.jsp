<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">

<center>

    <form action="/addphoto" method="post" enctype ="multipart/form-data">
        <label for="file">选择考生照片</label>
        <input  id="file" name="file" type="file" />
        <input  type="submit" value="提交" >
    </form>
</center>

</body>
</html>
