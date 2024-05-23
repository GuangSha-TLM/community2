package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class CommunityUserAndUserqueryBo implements Serializable {

    private String token;
    private Long communityId;

    public CommunityUserAndUserqueryBo(){}

    public CommunityUserAndUserqueryBo(String token, Long communityId) {
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
        return "CommunityUserAndUserqueryBo{" +
                "token='" + token + '\'' +
                ", communityId=" + communityId +
                '}';
    }
}
