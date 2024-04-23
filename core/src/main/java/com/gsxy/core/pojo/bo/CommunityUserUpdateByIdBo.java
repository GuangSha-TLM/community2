package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.CommunityUser;

import java.io.Serializable;

public class CommunityUserUpdateByIdBo implements Serializable {
    private String token;
    private CommunityUser communityUser;

    public CommunityUserUpdateByIdBo(){

    }

    public CommunityUserUpdateByIdBo(String token, CommunityUser communityUser) {
        this.token = token;
        this.communityUser = communityUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CommunityUser getCommunityUser() {
        return communityUser;
    }

    public void setCommunityUser(CommunityUser communityUser) {
        this.communityUser = communityUser;
    }

    @Override
    public String toString() {
        return "CommunityUserUpdateByIdBo{" +
                "id=" + token +
                ", communityUser=" + communityUser +
                '}';
    }
}
