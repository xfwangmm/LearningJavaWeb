<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21/021
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user list</title>
    <style type="text/css">
        td {
            text-align: center;
            width: 100px;
        }
    </style>
</head>
<body>
<div align="right">
    Welcome,[<font color=red>${sessionScope.user.name}</font>] | <a
        href="loginout">Exit</a>
</div>
<br>
<center>
    <table border="1">
        <tbody>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>sex</th>
            <th>age</th>
            <th colspan="2" style="">Options</th>
        </tr>
        <c:if test="${!empty userList }">
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.pwd}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td><a href="toupdateuser?id=${user.id}">modify</a></td>
                    <td><a href="deleteuser?id=${user.id}">delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <br>
    <a href="toadduser">Add a new user</a>
</center>

</body>
</html>
