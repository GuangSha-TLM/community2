package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class AdminSignInNoticeBo implements Serializable {

    private String token;
    private String noticeContext;//通知内容
    private Long duration;//签到时长
    private String signKey;//签到key

    public AdminSignInNoticeBo (){}

    public AdminSignInNoticeBo(String token, String noticeContext, Long duration, String signKey) {
        this.token = token;
        this.noticeContext = noticeContext;
        this.duration = duration;
        this.signKey = signKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNoticeContext() {
        return noticeContext;
    }

    public void setNoticeContext(String noticeContext) {
        this.noticeContext = noticeContext;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    @Override
    public String toString() {
        return "AdminSignInNoticeBo{" +
                "token='" + token + '\'' +
                ", noticeContext='" + noticeContext + '\'' +
                ", duration=" + duration +
                ", signKey='" + signKey + '\'' +
                '}';
    }
}
