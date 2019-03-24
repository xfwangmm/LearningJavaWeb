package com.xf.ssm.controller;

import com.xf.ssm.model.User;
import com.xf.ssm.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理用户相关的请求
 */
@Controller("userController")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        user = userService.selectUser(user);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:alluser";
        } else {
            session.setAttribute("message", "username or password is wrong!");
            return "redirect:login.jsp";
        }
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "login";
    }

    /**
     * 显示所有用户
     * @param request
     * @return
     */
    @RequestMapping("/alluser")
    public String selectAllUser(HttpServletRequest request){
        List<User> users = userService.selectAllUser();
        request.setAttribute("userList", users);
        return "userlist";
    }

    /**
     * 跳转到添加用户界面
     * @return
     */
    @RequestMapping("/toadduser")
    public String toAddUserPage(){
        return "adduser";
    }

    /**
     * 添加用户
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/adduser")
    public String addUser(User user, HttpServletRequest request){
        userService.addUser(user);
        List<User> users = userService.selectAllUser();
        request.setAttribute("userList", users);
        return "userlist";
    }

    /**
     * 删除用户
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/deleteuser")
    public String deleteUser(@Param("id") Integer id, HttpServletRequest request){
        userService.deleteUserById(id);
        List<User> users = userService.selectAllUser();
        request.setAttribute("userList", users);
        return "userlist";
    }

    /**
     * 跳转到更新用户界面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdateuser")
    public String toUpdateUserPage(@Param("id") Integer id, Model model){
        model.addAttribute("user_id", id);
        return "updateuser";
    }

    /**
     * 更新用户
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/updateuser")
    public String updateUser(User user, HttpServletRequest request){
        userService.updateUser(user);
        List<User> users = userService.selectAllUser();
        request.setAttribute("userList", users);
        return "userlist";
    }
}
