package com.xf.hrms.controller;

import com.xf.hrms.domain.Admin;
import com.xf.hrms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin控制器
 */
@RestController("adminController")
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param admin
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Admin login(@ModelAttribute Admin admin){
        System.out.println(admin);
        return adminService.login(admin);
    }

    /**
     * 管理员列表
     * @param name
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Admin> adminList(@RequestParam(name = "name") String name){
        return adminService.getAdmins(name);
    }

    /**
     * 管理员人数
     * @param name
     * @return
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Integer adminCount(@RequestParam(name = "name") String name){
        return adminService.getCount(name);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer addAdmin(@ModelAttribute Admin admin){
        return adminService.addAdmin(admin);
    }

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Integer delete(@RequestParam(name = "id") Integer id){
        return adminService.deleteAdmin(id);
    }

}
