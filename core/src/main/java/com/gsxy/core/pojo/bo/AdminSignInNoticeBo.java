package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class AdminSignInNoticeBo implements Serializable {

    private String token;
    private String noticeContext;//通知内容
    private Long duration;//签到时长
    private String signKey;//签到key
    private Long communityId;//社团id
    private Date signInTime;

    public AdminSignInNoticeBo (){}

    public AdminSignInNoticeBo(String token, String noticeContext, Long duration, String signKey, Long communityId, Date signInTime) {
        this.token = token;
        this.noticeContext = noticeContext;
        this.duration = duration;
        this.signKey = signKey;
        this.communityId = communityId;
        this.signInTime = signInTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNoticeContext() {
        return noticeContext;
    }

    public void setNoticeContext(String noticeContext) {
        this.noticeContext = noticeContext;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    @Override
    public String toString() {
        return "AdminSignInNoticeBo{" +
                "token='" + token + '\'' +
                ", noticeContext='" + noticeContext + '\'' +
                ", duration=" + duration +
                ", signKey='" + signKey + '\'' +
                ", communityId=" + communityId +
                ", signInTime=" + signInTime +
                '}';
    }
}


