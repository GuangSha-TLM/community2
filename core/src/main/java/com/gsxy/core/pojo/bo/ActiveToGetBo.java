package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class ActiveToGetBo implements Serializable {

    private Long id;
    private String title;
    private String context;
    private Date createTime;

    public ActiveToGetBo(Long id, String title, String context, Date createTime) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.createTime = createTime;
    }

    public ActiveToGetBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "active{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
