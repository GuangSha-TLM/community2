package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class AdminCheckInStatusInRealTimeBo implements Serializable {

    private String token;
    private String content;

    public AdminCheckInStatusInRealTimeBo(String token, String content) {
        this.token = token;
        this.content = content;
    }

    public AdminCheckInStatusInRealTimeBo() {
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
        return "AdminCheckInStatusInRealTimeBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
