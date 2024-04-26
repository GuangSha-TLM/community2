package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class AdminSignInNoticeBo implements Serializable {

    private String token;
    private String noticeContext;//通知内容
    private String duration;//签到时长

    public AdminSignInNoticeBo (){}

    public AdminSignInNoticeBo(String token, String noticeContext, String duration) {
        this.token = token;
        this.noticeContext = noticeContext;
        this.duration = duration;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AdminSignInNoticeBo{" +
                "token='" + token + '\'' +
                ", noticeContext='" + noticeContext + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
