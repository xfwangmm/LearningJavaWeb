package com.xf.hrms.domain;

import java.io.Serializable;

/**
 * 职位实体类
 */
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

//    职位编号
    private Integer id;
//    职位名称
    private String name;
//    职位描述
    private String desc;

    public Position() {
    }

    public Position(String name, String desc) {
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
