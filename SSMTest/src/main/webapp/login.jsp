<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21/021
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<h4>Login Page</h4>

<form action="login" method="post">
    <font color="red">${sessionScope.message}</font>
    <table>
        <tr>
            <td><label>username:</label></td>
            <td><input type="text" id="name" name="name" />
        </tr>
        <tr>
            <td><label>password:</label></td>
            <td><input type="password" id="pwd" name="pwd" />
        </tr>
        <tr>
            <td><input type="submit" value="login" />
        </tr>
    </table>
</form>

</body>
</html>
