package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class UserSignInRequestBo implements Serializable {
    private String context;//签到信息内容

    private String token;

    public UserSignInRequestBo(){}

    public UserSignInRequestBo(String context, String token) {
        this.context = context;
        this.token = token;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserSignInRequestBo{" +
                "context='" + context + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
