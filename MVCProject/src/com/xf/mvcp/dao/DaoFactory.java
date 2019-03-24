package com.xf.mvcp.dao;

/**
 * Dao工厂类
 */
public class DaoFactory {
    /**
     * 获取UserDao实现类对象
     * @return
     */
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
