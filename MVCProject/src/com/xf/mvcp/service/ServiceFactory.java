package com.xf.mvcp.service;

/**
 * 业务逻辑工厂类
 */
public class ServiceFactory {
    /**
     * 获取用户业务逻辑实现类对象
     * @return
     */
    public static UserService getUserService(){
        return new UserServiceImpl();
    }
}
