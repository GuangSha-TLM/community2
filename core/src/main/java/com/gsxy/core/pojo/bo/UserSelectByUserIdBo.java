package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class UserSelectByUserIdBo implements Serializable {

    private String token;
    private Long id;

    public UserSelectByUserIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public UserSelectByUserIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserSelectByUserIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
