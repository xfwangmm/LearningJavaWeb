<%@ page import="com.xf.mvcp.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xf.mvcp.service.UserService" %>
<%@ page import="com.xf.mvcp.service.ServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: xiaofeng
  Date: 2019/2/4
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>

<%--管理用户页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>manage users</title>
    <style>
        .container{background-color: #ffffff; position: center;
            /*width: 800px;*/
            margin: 50px}
        .top-tab{height: 40px; padding: 10px; text-align: center}
        .main{
            text-align: center;
            align-content: center;
        }
        .controls{
            padding: 10px;

        }

        tr{height: 40px}
        td{text-align: center}
        table{margin: 40px; padding: 20px; border: 1px solid}
        .result td{border: 1px #ccc solid; padding: 6px}

        .result-div{text-align: center}
    </style>
</head>
<body style="background-color: #f5f5f5; text-align: center">

<div class="container">

    <div class="top-tab">
        <%--<label style="margin-top: auto; margin-bottom: auto">管理用户</label>--%>
        <h4>管理用户</h4>
    </div>

    <%
        UserService userService = ServiceFactory.getUserService();
        List<User> userList = userService.query("", "", "");
        request.setAttribute("userList", userList);
    %>

    <div class="main">
        <form action="<%=request.getContextPath()%>/query.u" method="post">

            <div class="controls">
                <label> 用户名称: </label>
                <input type="text" name="name" value="" placeholder="用户名" >
            </div>

            <div class="controls">
                <label>手机号码: </label>
                <input type="text" name="phone" value="" placeholder="手机" >
            </div>

            <div class="controls">
                <label>注册邮箱: </label>
                <input type="text" name="email" value="" placeholder="邮箱" >
            </div>
            <div class="controls" >
                <input type="submit" value="查询用户">
                <a href="<%=request.getContextPath()%>/sign_up.jsp">
                    <input type="button" value="注册账号">
                </a>
            </div>

        </form>

        <div class="result-div">
            <table style="margin-left: auto; margin-right: auto" class="result" cellspacing="0" cellpadding="0">
                <tr style="color: chocolate">
                    <td>用户ID</td>
                    <td>用户名</td>
                    <td>用户密码</td>
                    <td>手机号码</td>
                    <td>邮箱</td>
                    <td>注册日期</td>
                    <%--<td>操作记录</td>--%>
                </tr>
                <%
                    List<User> usersQuery = (List<User>) request.getAttribute("usersQueryList");
                    if (usersQuery != null){
                        for (User user : usersQuery){
                %>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getPassword()%></td>
                    <td><%=user.getPhone()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getDate()%></td>
                    <%--<td>--%>
                        <%--<a href="<%=request.getContextPath()%>/update.u?id=<%=user.getId()%>">编辑</a>--%>
                        <%--<a href="<%=request.getContextPath()%>/delete.u?id=<%=user.getId()%>">删除</a>--%>
                    <%--</td>--%>
                </tr>
                <%
                        }
                    }
                %>


            </table>
        </div>

        <div class="result-div">
            <table style="margin-left: auto; margin-right: auto" class="result" cellspacing="0" cellpadding="0">
                <tr style="color: chocolate">
                    <td>用户ID</td>
                    <td>用户名</td>
                    <td>用户密码</td>
                    <td>手机号码</td>
                    <td>邮箱</td>
                    <td>注册日期</td>
                    <td>操作记录</td>
                </tr>
                <%
                    List<User> users = (List<User>) request.getAttribute("userList");
                    if (users != null){
                        for (User user : users){
                %>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getPassword()%></td>
                    <td><%=user.getPhone()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getDate()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/edit_user.jsp?id=<%=user.getId()%>">编辑</a>
                        <a href="<%=request.getContextPath()%>/delete.u?id=<%=user.getId()%>">删除</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>


            </table>
        </div>

    </div>
</div>

</body>
</html>
