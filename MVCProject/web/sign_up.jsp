<%--
  Created by IntelliJ IDEA.
  User: xiaofeng
  Date: 2019/2/5
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>

<%--
注册账号页面
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up</title>
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
        <h4>注册账号</h4>
    </div>
    <div class="main">
        <form action="<%=request.getContextPath()%>/addUser.u" method="post">

            <div class="controls">
                <label>昵  称: </label>
                <input type="text" name="name" value="" required="" placeholder="用户名" aria-required="true">
            </div>

            <div class="controls">
                <label>密  码: </label>
                <input type="password" name="password" value="" required="" placeholder="密码" aria-required="true">
            </div>

            <div class="controls">
                <label>手  机: </label>
                <input type="text" name="phone" value="" required="" placeholder="手机" aria-required="true">
            </div>

            <div class="controls">
                <label>邮  箱: </label>
                <input type="text" name="email" value="" required="" placeholder="邮箱" aria-required="true">
            </div>

            <div class="controls" >
                <input type="submit" value="注册">
            </div>

        </form>

    </div>
</div>

</body>
</html>
