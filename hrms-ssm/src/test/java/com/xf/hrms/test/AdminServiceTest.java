package com.xf.hrms.test;

import com.xf.hrms.domain.Admin;
import com.xf.hrms.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    public void testLogin(){
        Admin admin = new Admin();
        admin.setUsername("name");
        admin.setPassword("pwd");
        System.out.println(adminService.login(admin));
    }

    /**
     * 测试getCount()和getAdmins()
     */
    @Test
    public void testGet(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        Admin admin = new Admin();
//        admin.setUsername("test");
//        admin.setPassword("test");
//        map.put("1", admin);

        String name = "name";

        System.out.println(adminService.getAdmins(name));

        System.out.println(adminService.getCount(name));
    }

    @Test
    public void testAddAdmin(){
        Admin admin = new Admin("new admin", "123456", "role_test");
        adminService.addAdmin(admin);
    }

    @Test
    public void testDeleteAdmin(){
        adminService.deleteAdmin(3);
    }

    @Test
    public void testUpdateAdmin(){
        Admin admin = new Admin();
        admin.setid(1);
        admin.setUsername("new name");
        admin.setPassword("new pwd");
        admin.setuserRole("new role");
        adminService.updateAdmin(admin);
    }
}
