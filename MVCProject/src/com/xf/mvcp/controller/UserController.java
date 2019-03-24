package com.xf.mvcp.controller;

import com.xf.mvcp.model.User;
import com.xf.mvcp.service.ServiceFactory;
import com.xf.mvcp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * 用户账号相关的控制器
 */
@WebServlet(urlPatterns = {"*.u"})
public class UserController extends HttpServlet {
    UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//        通过方法名拿到方法并执行
        String mName = req.getServletPath().substring(1).replace(".u", "");
        System.out.println(mName);
        try {
            Method method = getClass().getDeclaredMethod(mName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean isSuccess = userService.login(name, password);

        if (isSuccess){
            resp.sendRedirect("login_result.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }

    /**
     * 注册账号，增加用户
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

        int rows = userService.add(user);

        if (rows > 0){
            resp.sendRedirect("sign_up_result.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }

    }

    /**
     * 删除用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        int rows = userService.delete(id);
        if (rows > 0){
            resp.sendRedirect("mng_user.jsp");
        }else {
            resp.sendRedirect("mng_user.jsp");
        }
    }

    /**
     * 更新用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("update");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        int id = Integer.parseInt(req.getParameter("id"));

        User user = userService.get(id);
//        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setDate(new Date());

        int rows = userService.update(user);

        if(rows > 0){
            resp.sendRedirect("mng_user.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }

    /**
     * 查询模糊匹配的所有用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        List<User> users = userService.query(name, phone, email);

        req.setAttribute("usersQueryList", users);
        req.getRequestDispatcher("mng_user.jsp").forward(req, resp);
    }
}
