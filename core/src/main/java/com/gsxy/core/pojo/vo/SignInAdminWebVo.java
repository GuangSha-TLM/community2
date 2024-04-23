package com.gsxy.core.pojo.vo;

import java.util.Date;

public class SignInAdminWebVo {

    private Long id;
    private Long communityId;
    private String content;
    private Date releaseTime;
    private Integer signInTime;

    public SignInAdminWebVo(Long id, Long communityId, String content, Date releaseTime, Integer signInTime) {
        this.id = id;
        this.communityId = communityId;
        this.content = content;
        this.releaseTime = releaseTime;
        this.signInTime = signInTime;
    }

    public SignInAdminWebVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Integer signInTime) {
        this.signInTime = signInTime;
    }

    @Override
    public String toString() {
        return "SignInAdminWebVo{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                ", signInTime=" + signInTime +
                '}';
    }
}
