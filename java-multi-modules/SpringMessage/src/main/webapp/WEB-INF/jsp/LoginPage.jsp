<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">

<center>
    <h1>登陆页面</h1>

    <form action="/checklogin" method="post" >
        <table>
            <tr><td>用户名</td><td><input id="username" name="username" type="text" placeholder="Your name" maxlength="20"></td></tr>
            <tr><td>密码</td><td><input id="password" name="password" type="password" placeholder="Password" maxlength="20"></td></tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" id="login" value="登 录">
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
