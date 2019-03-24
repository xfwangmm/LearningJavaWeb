package com.xf.hrms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告实体类
 */
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

//    公告编号
    private Integer id;
//    公告标题
    private String title;
//    公告内容
    private String content;
//    公告发布人，只能是管理员
    private Admin admin;
//    公告发布日期
    private Date date;

    public Post() {
    }

    public Post(String title, String content, Admin admin, Date date) {
        this.title = title;
        this.content = content;
        this.admin = admin;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", admin=" + admin +
                ", date=" + date +
                '}';
    }
}
