package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class CommunityUserDeleteByIdBo implements Serializable {
    private String token;
    private Long userId;
    public CommunityUserDeleteByIdBo(){

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CommunityUserDeleteByIdBo(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommunityUserDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
