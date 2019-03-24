<%--
  Created by IntelliJ IDEA.
  User: xiaofeng
  Date: 2019/2/4
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>

<%--
首页
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Java Web MVC Project</title>
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
        <%--<label>登录账号</label>--%>
          <h4>登录账号</h4>
      </div>
      <div class="main">
        <form action="<%=request.getContextPath()%>/login.u" method="post">

        <div class="controls">
          <label>账号: </label>
          <input type="text" name="name" value="" required="" placeholder="用户名" aria-required="true">
        </div>

        <div class="controls">
          <label>密码: </label>
          <input type="password" name="password" value="" required="" placeholder="密码" aria-required="true">
        </div>
          <div class="controls" >
            <input type="submit" value="登录">
          </div>

        </form>

        <div>
          <label>还没有注册帐号？ </label>
          <a href="<%=request.getContextPath()%>/sign_up.jsp">立即注册</a>
        </div>

        <div style="padding: 6px">
          <a href="mng_user.jsp">管理用户</a>
        </div>
    </div>
    </div>

  </body>
</html>
