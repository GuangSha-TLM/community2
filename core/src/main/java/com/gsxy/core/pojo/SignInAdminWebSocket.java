package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员发起签到实体类-WebSocket实现
 */
public class SignInAdminWebSocket implements Serializable {

    private Long id;
    private Long adminId;//管理员ID
    private Long communityId;//社团ID
    private String content;//签到内容(管理员发布的)
    private Date releaseTime;//发布时间
    private Integer signInTime;//签到时长
    private String uuid;//uuid

    public SignInAdminWebSocket(Long id, Long adminId, Long communityId, String content, Date releaseTime, Integer signInTime, String uuid) {
        this.id = id;
        this.adminId = adminId;
        this.communityId = communityId;
        this.content = content;
        this.releaseTime = releaseTime;
        this.signInTime = signInTime;
        this.uuid = uuid;
    }

    public SignInAdminWebSocket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "SignInAdminWebSocket{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                ", signInTime=" + signInTime +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
