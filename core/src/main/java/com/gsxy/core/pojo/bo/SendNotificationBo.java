package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class SendNotificationBo implements Serializable {

    private String token;
    private String content;//签到内容
    private Integer signInTime;//签到时长

    public SendNotificationBo(String token, String content, Integer signInTime) {
        this.token = token;
        this.content = content;
        this.signInTime = signInTime;
    }

    public SendNotificationBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Integer signInTime) {
        this.signInTime = signInTime;
    }

    @Override
    public String toString() {
        return "SendNotificationBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                ", signInTime=" + signInTime +
                '}';
    }
}
