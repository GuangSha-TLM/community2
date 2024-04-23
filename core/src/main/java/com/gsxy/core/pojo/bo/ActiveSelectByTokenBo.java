package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class ActiveSelectByTokenBo implements Serializable {

    private String token;

    public ActiveSelectByTokenBo(String token) {
        this.token = token;
    }

    public ActiveSelectByTokenBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SelectByTokenBo{" +
                "token='" + token + '\'' +
                '}';
    }
}
