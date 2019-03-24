package com.xf.sm.controller;

import com.xf.sm.model.User;
import com.xf.sm.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

@WebServlet(urlPatterns = {"*.do"})
public class UserController extends HttpServlet {
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        userService = (UserService) context.getBean("user_service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String methodName = req.getServletPath().substring(1).replace(".do", "");
//        根据方法名获取方法并执行
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(methodName);
    }

    /**
     * 注册账号，添加用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setDate(new Date());

        System.out.println(userService);
        int rows = userService.add(user);

        if(rows > 0){
            System.out.println("add user success");
        }else {
            System.out.println("add user failed");
        }
    }
}
