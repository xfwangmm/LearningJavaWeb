package com.xf.hrms.domain;

import java.io.Serializable;

/**
 * 部门实体类
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

//    部门编号
    private Integer id;
//    部门名称
    private String name;
//    部门描述
    private String desc;

    public Department() {
    }

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
