package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class CommunityAndUserBo implements Serializable {
    private String token;
    private Long communityId;
    public CommunityAndUserBo(){

    }

    public CommunityAndUserBo(String token, Long communityId) {
        this.token = token;
        this.communityId = communityId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    @Override
    public String toString() {
        return "CommunityAndUserBo{" +
                "token='" + token + '\'' +
                ", communityId=" + communityId +
                '}';
    }
}
