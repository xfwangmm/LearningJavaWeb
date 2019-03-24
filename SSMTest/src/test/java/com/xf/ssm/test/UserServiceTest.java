package com.xf.ssm.test;

import com.xf.ssm.dao.UserDao;
import com.xf.ssm.model.User;
import com.xf.ssm.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Before
    public void before(){
        System.out.println("UserServiceTest");
    }

    @Test
    public void testSelectUser(){
        System.out.println("testSelectUser");
        User user = new User();
        user.setName("xf");
        user.setPwd("sfsf");
        System.out.println(userService.selectUser(user));
    }

    @Test
    public void testSelectALLUser(){
        System.out.println("testSelectALLUser");
        List<User> users = userService.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setName("yewenjie");
        user.setPwd("123");
        user.setSex("female");
        user.setAge(34);
        userService.addUser(user);
    }

    @Test
    public void testDeleteUser(){
        userService.deleteUserById(1);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(2);
        user.setName("yewenjie");
        user.setPwd("123456");
        user.setSex("female");
        user.setAge(34);
        userService.updateUser(user);
    }

    @After
    public void after(){
        System.out.println("UserServiceTest");
    }
}
