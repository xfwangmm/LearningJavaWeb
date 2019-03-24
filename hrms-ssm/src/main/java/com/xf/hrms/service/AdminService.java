package com.xf.hrms.service;

import com.xf.hrms.domain.Admin;

import java.util.List;
import java.util.Map;

/**
 * Admin相关业务逻辑接口
 */
public interface AdminService {
    /**
     * 登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);

//    /**
//     * 根据条件查询管理员
//     * @param map
//     * @return
//     */
//    List<Admin> getAdmins(Map<String, Object> map);

    /**
     * 根据username模糊查询管理员
     * @param name
     * @return
     */
    List<Admin> getAdmins(String name);

//    /**
//     * 根据条件查询管理员人数
//     * @param map
//     * @return
//     */
//    Integer getCount(Map<String, Object> map);

    /**
     * 根据username模糊查询管理员人数
     * @param name
     * @return
     */
    Integer getCount(String name);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    Integer addAdmin(Admin admin);

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    Integer deleteAdmin(Integer id);

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    Integer updateAdmin(Admin admin);
}
