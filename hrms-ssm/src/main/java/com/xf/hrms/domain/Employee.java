package com.xf.hrms.domain;

import java.io.Serializable;

/**
 * 员工实体类
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

//    员工编号
    private Integer id;
//    员工名字
    private String name;
//    性别
    private String sex;
//    电话
    private String phone;
//    邮箱
    private String email;
//    地址
    private String address;
//    学历
    private String education;
//    生日
    private String birthday;
//    所属部门
    private Department department;
//    所在职位
    private Position position;

    public Employee() {
    }

    public Employee(String name, String sex, String phone, String email, String address, String education, String birthday, Department department, Position position) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.education = education;
        this.birthday = birthday;
        this.department = department;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", birthday='" + birthday + '\'' +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
