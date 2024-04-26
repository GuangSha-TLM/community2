package com.gsxy.core.pojo.bo;


import java.io.Serializable;
import java.util.Date;

public class AdminSignInRequestBo implements Serializable {

    private long duration;//时长
    private String communityId;//社团id
    private String context;//签到内容

    public AdminSignInRequestBo(){}

    public AdminSignInRequestBo(long duration, String communityId, String context) {
        this.duration = duration;
        this.communityId = communityId;
        this.context = context;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "AdminSignInRequestBo{" +
                "duration=" + duration +
                ", communityId='" + communityId + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
