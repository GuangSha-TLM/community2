package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class CommunityInActiveBo implements Serializable {

    private Long Id;//社团id
    private String name;//社团名称
    private Long createBy;//社团创建人
    private String username;//用户名

    public CommunityInActiveBo(Long id, String name, Long createBy, String username) {
        Id = id;
        this.name = name;
        this.createBy = createBy;
        this.username = username;
    }

    public CommunityInActiveBo() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CommunityInActiveBo{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", createBy=" + createBy +
                ", username='" + username + '\'' +
                '}';
    }
}
