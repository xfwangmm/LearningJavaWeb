package com.xf.sm.dao;

import com.xf.sm.model.User;
import com.xf.sm.utils.StringUtils;

import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public int add(User user) {
        String sql = "insert into user (name, password, phone, email, date) values (?, ?, ?, ?, ?)";
        return super.update(sql, user.getName(), user.getPassword(), user.getPhone(), user.getEmail(), user.getDate());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from user where id = ?";
        return super.update(sql, id);
    }

    @Override
    public int delete(String name) {
        String sql = "delete from user where name = ?";
        return super.update(sql, name);
    }

    @Override
    public int update(User user) {
        String sql = "update user set name = ?, password = ?, phone = ?, email = ?, date = ? where id = ?";
        return super.update(sql, user.getName(), user.getPassword(), user.getPhone(), user.getEmail(),user.getDate() , user.getId());
    }

    @Override
    public User get(int id) {
        String sql = "select id, name, password, phone, email, date from user where id = ?";
        return super.query(sql, id);
    }

    @Override
    public User get(String name) {
        String sql = "select id, name, password, phone, email, date from user where name = ?";
        return super.query(sql, name);
    }

    @Override
    public List<User> getAll() {
        String sql = "select id, name, password, phone, email, date from user";
        return super.queryBatch(sql);
    }

    @Override
    public List<User> query(String name, String phone, String email) {
        String sql = "select id, name, password, phone, email, date from user where 1 = 1";
        if(!StringUtils.isEmpty(name)){
            sql += " and name like '%" + name + "%'";
        }
        if(!StringUtils.isEmpty(phone)){
            sql += " and phone like '%" + phone + "%'";
        }
        if(!StringUtils.isEmpty(email)){
            sql += " and email like '%" + email + "%'";
        }
        return super.queryBatch(sql);
    }
}
