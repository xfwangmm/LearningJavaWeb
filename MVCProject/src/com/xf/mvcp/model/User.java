package com.xf.mvcp.model;


import java.util.Date;

/**
 * 用户类
 */
public class User {
    /**
     * 用户id，自增，主键
     */
    int id;
    /**
     * 用户名，不能重复
     */
    String name;
    /**
     * 用户密码
     */
    String password;
    /**
     * 用户注册电话
     */
    String phone;
    /**
     * 用户注册邮箱
     */
    String email;
    /**
     * 用户注册日期
     */
    Date date;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(int id, String name, String password, String phone, String email, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.date = date;
    }
}
