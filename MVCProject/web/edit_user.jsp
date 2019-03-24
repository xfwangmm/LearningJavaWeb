<%@ page import="com.xf.mvcp.model.User" %>
<%@ page import="com.xf.mvcp.service.ServiceFactory" %>
<%@ page import="java.util.concurrent.RunnableScheduledFuture" %><%--
  Created by IntelliJ IDEA.
  User: xiaofeng
  Date: 2019/2/5
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%--
编辑用户信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit user</title>
    <style>
        .container{background-color: #ffffff; position: center;
            margin-top: 50px;
            margin-left: 400px;
            margin-right: 400px;
        }
        .top-tab{height: 40px; padding: 10px; text-align: center}
        .main{

            text-align: center;
        }
        .controls{
            padding: 10px;

        }
    </style>
</head>
<body style="background-color: #f5f5f5; text-align: center">
<div class="container">
    <div class="top-tab">
        <%--<label>注册账号</label>--%>
        <h4>编辑用户</h4>
    </div>

    <%
        int id = Integer.parseInt(request.getParameter("id"));
        User user = ServiceFactory.getUserService().get(id);
    %>

    <div class="main">
        <form action="<%=request.getContextPath()%>/update.u?id=<%=id%>" method="post">

            <div class="controls">
                <label>昵  称: </label>
                <input type="text" name="name" value="<%=user.getName()%>" required="" aria-required="true">
            </div>

            <div class="controls">
                <label>密  码: </label>
                <input type="password" name="password" value="<%=user.getPassword()%>" required="" aria-required="true">
            </div>

            <div class="controls">
                <label>手  机: </label>
                <input type="text" name="phone" value="<%=user.getPhone()%>" required="" aria-required="true">
            </div>

            <div class="controls">
                <label>邮  箱: </label>
                <input type="text" name="email" value="<%=user.getEmail()%>" required="" aria-required="true">
            </div>

            <div class="controls" >
                <input type="submit" value="确认修改">
            </div>

        </form>

    </div>
</div>

</body>
</html>
