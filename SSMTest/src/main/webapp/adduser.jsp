<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21/021
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user</title>
</head>
<body>
<h4>AddUser Page</h4>
<form action="adduser" method="post">
    <table>
        <tr>
            <td><label>username:</label></td>
            <td><input type="text" id="name" name="name" />
        </tr>
        <tr>
            <td><label>password:</label></td>
            <td><input type="passwd" id="pwd" name="pwd" />
        </tr>
        <tr>
            <td><label>sex:</label></td>
            <td><input type="text" id="sex" name="sex" />
        </tr>
        <tr>
            <td><label>age:</label></td>
            <td><input type="text" id="age" name="age" />
        </tr>
        <tr>
            <td><input type="submit" value="add" />
        </tr>
    </table>
</form>

</body>
</html>
