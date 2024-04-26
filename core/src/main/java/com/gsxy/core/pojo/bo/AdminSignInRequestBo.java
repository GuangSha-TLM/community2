package com.gsxy.core.pojo.bo;


import java.io.Serializable;
import java.util.Date;

public class AdminSignInRequestBo implements Serializable {

    private long duration;//时长
    private String context;//签到内容
    private String token;

    public AdminSignInRequestBo(){}

    public AdminSignInRequestBo(long duration, String context, String token) {
        this.duration = duration;
        this.context = context;
        this.token = token;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
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
        return "AdminSignInRequestBo{" +
                "duration=" + duration +
                ", context='" + context + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
