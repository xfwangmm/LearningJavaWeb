package com.xf.sm.dao;

import com.xf.sm.model.User;

import java.util.List;

/**
 * User的Dao接口
 */
public interface UserDao {
    /**
     * 增加一个用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 通过id删除一个用户
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 通过name删除一个用户
     * @param name
     * @return
     */
    int delete(String name);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 通过id得到一个用户
     * @param id
     * @return
     */
    User get(int id);

    /**
     * 通过name得到一个用户
     * @param name
     * @return
     */
    User get(String name);

    /**
     * 得到所有注册用户
     * @return
     */
    List<User> getAll();

    /**
     * 模糊查询
     * @param name
     * @param phone
     * @param email
     * @return
     */
    List<User> query(String name, String phone, String email);
}
