package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class UserSignInRequestBo implements Serializable {
    private String context;//签到信息内容
    private Long id;
    private String token;

    public UserSignInRequestBo(){}

    public UserSignInRequestBo(String context, Long id, String token) {
        this.context = context;
        this.id = id;
        this.token = token;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
