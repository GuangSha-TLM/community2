package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class SignInUser implements Serializable {

    private Long id;
    private String name;//人名
    private Date signInTime;//签到时间

    public SignInUser(){}

    public SignInUser(Long id, String name, Date signInTime) {
        this.id = id;
        this.name = name;
        this.signInTime = signInTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    @Override
    public String toString() {
        return "SignInUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", signInTime=" + signInTime +
                '}';
    }
}
