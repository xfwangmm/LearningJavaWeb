package com.xf.hrms.domain;

import java.io.Serializable;

/**
 * 管理员实体类
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; //管理员编号
    private String username;    //管理员名称
    private String password;    //管理员密码
    private String userRole;    //管理员角色

    public Admin() {
    }

    public Admin(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuserRole() {
        return userRole;
    }

    public void setuserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}

