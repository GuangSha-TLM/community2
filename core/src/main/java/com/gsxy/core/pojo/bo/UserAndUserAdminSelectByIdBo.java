package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class UserAndUserAdminSelectByIdBo implements Serializable {

    private String token;
    private UserAndUserAdminBo userAndUserAdminBo;

    public UserAndUserAdminSelectByIdBo(String token, UserAndUserAdminBo userAndUserAdminBo) {
        this.token = token;
        this.userAndUserAdminBo = userAndUserAdminBo;
    }

    public UserAndUserAdminSelectByIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserAndUserAdminBo getUserAndUserAdminBo() {
        return userAndUserAdminBo;
    }

    public void setUserAndUserAdminBo(UserAndUserAdminBo userAndUserAdminBo) {
        this.userAndUserAdminBo = userAndUserAdminBo;
    }

    @Override
    public String toString() {
        return "UserAndUserAdminSelectByIdBo{" +
                "token='" + token + '\'' +
                ", userAndUserAdminBo=" + userAndUserAdminBo +
                '}';
    }
}
