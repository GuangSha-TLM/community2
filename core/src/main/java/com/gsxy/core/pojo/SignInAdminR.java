package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class SignInAdminR implements Serializable {

    private Long id;
    private String key;//发签到时设置的redis主键
    private String context;//签到内容
    private Long signUserId;//发起用户id
    private Long duration;//签到时长
    private Date signInTime;//签到发起时间

    public SignInAdminR(){}

    public SignInAdminR(Long id, String key, String context, Long signUserId, Long duration, Date signInTime) {
        this.id = id;
        this.key = key;
        this.context = context;
        this.signUserId = signUserId;
        this.duration = duration;
        this.signInTime = signInTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getSignUserId() {
        return signUserId;
    }

    public void setSignUserId(Long signUserId) {
        this.signUserId = signUserId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    @Override
    public String toString() {
        return "SignInAdminR{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", context='" + context + '\'' +
                ", signUserId=" + signUserId +
                ", duration=" + duration +
                ", signInTime=" + signInTime +
                '}';
    }
}
