package com.xf.ssm.test;

import com.xf.ssm.dao.UserDao;
import com.xf.ssm.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectAllUser(){
        List<User> users = userDao.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
