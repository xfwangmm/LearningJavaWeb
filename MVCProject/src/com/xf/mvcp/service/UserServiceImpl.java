package com.xf.mvcp.service;

import com.xf.mvcp.dao.DaoFactory;
import com.xf.mvcp.dao.UserDao;
import com.xf.mvcp.model.User;
import com.xf.mvcp.utils.StringUtils;

import java.util.List;

/**
 * 用户业务逻辑接口实现类
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = DaoFactory.getUserDao();

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int delete(String name) {
        return userDao.delete(name);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public User get(String name) {
        return userDao.get(name);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> query(String name, String phone, String email) {
        return userDao.query(name, phone, email);
    }

    @Override
    public boolean login(String name, String password) {
        name = StringUtils.removeIllegalChar(name);
        password = StringUtils.removeIllegalChar(password);

        User user = get(name);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
