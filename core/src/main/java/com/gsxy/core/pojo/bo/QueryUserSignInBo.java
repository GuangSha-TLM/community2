package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * 查询当前用户的community_id and name BO类
 */
public class QueryUserSignInBo implements Serializable {

    private Long communityId;
    private String name;

    public QueryUserSignInBo(){}

    public QueryUserSignInBo(Long communityId, String name) {
        this.communityId = communityId;
        this.name = name;
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

    @Override
    public String toString() {
        return "QueryUserSignInBo{" +
                "communityId=" + communityId +
                ", name='" + name + '\'' +
                '}';
    }
}
