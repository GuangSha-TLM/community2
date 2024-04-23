package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.UserAdmin;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过增加数据
 */
public class UserAdminAddByBo implements Serializable {

    private String token;
    private UserAdmin userAdmin;

    public UserAdminAddByBo() {
    }

    public UserAdminAddByBo(String token, UserAdmin userAdmin) {
        this.token = token;
        this.userAdmin = userAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserAdmin getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public String toString() {
        return "UserAdminAddByBo{" +
                "token='" + token + '\'' +
                ", userAdmin=" + userAdmin +
                '}';
    }
}
