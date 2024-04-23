package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class ReceiveNotificationsBo implements Serializable {

    private String token;
    private String content;//签到内容

    public ReceiveNotificationsBo(String token, String content) {
        this.token = token;
        this.content = content;
    }

    public ReceiveNotificationsBo() {
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

    @Override
    public String toString() {
        return "ReceiveNotificationsBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
