package com.xf.hrms.service;

import com.xf.hrms.dao.AdminDao;
import com.xf.hrms.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Admin相关业务逻辑接口实现类
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    public List<Admin> getAdmins(String name) {
        return adminDao.getAdmins(name);
    }

    public Integer getCount(String name) {
        return adminDao.getCount(name);
    }

//    public List<Admin> getAdmins(Map<String, Object> map) {
//        return adminDao.getAdmins(map);
//    }

//    public Integer getCount(Map<String, Object> map) {
//        return adminDao.getCount(map);
//    }

    public Integer addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    public Integer deleteAdmin(Integer id) {
        return adminDao.deleteAdmin(id);
    }

    public Integer updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }
}
