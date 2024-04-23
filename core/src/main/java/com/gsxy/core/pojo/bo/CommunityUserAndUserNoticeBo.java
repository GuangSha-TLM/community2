package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-11-07
 *       社长向用户发送已加入通知
 */
public class CommunityUserAndUserNoticeBo implements Serializable {
    private String token;
    private String context;
    //传入用户id
    private Long userId;


    public CommunityUserAndUserNoticeBo(){

    }

    public CommunityUserAndUserNoticeBo(String token, String context, Long userId) {
        this.token = token;
        this.context = context;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommunityUserAndUserNoticeBo{" +
                "token='" + token + '\'' +
                ", context='" + context + '\'' +
                ", userId=" + userId +
                '}';
    }
}
