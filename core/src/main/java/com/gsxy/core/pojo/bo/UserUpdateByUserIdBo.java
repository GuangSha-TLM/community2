package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.User;

import java.io.Serializable;

public class UserUpdateByUserIdBo implements Serializable {

    private String token;
    private User user;

    public UserUpdateByUserIdBo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public UserUpdateByUserIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserUpdateByUserIdBo{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
