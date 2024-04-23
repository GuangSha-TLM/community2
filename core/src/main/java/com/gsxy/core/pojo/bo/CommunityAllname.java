package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-11-02
 *      查找所有社团
 */
public class CommunityAllname implements Serializable {
    private Long    createBy;//用户id
    private Long   communityId;//社团id
    private String name;//社团名字
    private String introduce;//社团介绍
    private String username;//创建人姓名

    public CommunityAllname(){

    }

    public CommunityAllname(Long createBy, Long communityId, String name, String introduce, String username) {
        this.createBy = createBy;
        this.communityId = communityId;
        this.name = name;
        this.introduce = introduce;
        this.username = username;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CommunityAllname{" +
                "createBy=" + createBy +
                ", communityId=" + communityId +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
