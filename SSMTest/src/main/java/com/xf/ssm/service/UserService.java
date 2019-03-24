package com.xf.ssm.service;

import com.xf.ssm.model.User;

import java.util.List;

/**
 * 用户相关业务逻辑接口
 */
public interface UserService {
    /**
     * 查询某个用户
     * @param user
     * @return
     */
    User selectUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * delete user by id
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * update user
     * @param user
     */
    void updateUser(User user);
}
