package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.SignInAdmin;

import java.io.Serializable;

public class SignInAdminBo implements Serializable {

    private String token;
    private SignInAdmin signInAdmin;

    public SignInAdminBo(String token, SignInAdmin signInAdmin) {
        this.token = token;
        this.signInAdmin = signInAdmin;
    }

    public SignInAdminBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SignInAdmin getSignInAdmin() {
        return signInAdmin;
    }

    public void setSignInAdmin(SignInAdmin signInAdmin) {
        this.signInAdmin = signInAdmin;
    }

    @Override
    public String toString() {
        return
                "token='" + token + '\'' +
                ", signInAdmin=" + signInAdmin;
    }
}
