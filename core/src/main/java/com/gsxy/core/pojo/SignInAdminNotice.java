package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class SignInAdminNotice implements Serializable {

    private Long id;
    private String noticeContext;//通知内容e
    private String signKey;// 签到key
    private Long communityId;//社团id
    private Date signInTime;//签到发布时间

    public SignInAdminNotice() {
    }

    public SignInAdminNotice(Long id, String noticeContext, String signKey, Long communityId, Date signInTime) {
        this.id = id;
        this.noticeContext = noticeContext;
        this.signKey = signKey;
        this.communityId = communityId;
        this.signInTime = signInTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeContext() {
        return noticeContext;
    }

    public void setNoticeContext(String noticeContext) {
        this.noticeContext = noticeContext;
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
        return "SignInAdminNotice{" +
                "id=" + id +
                ", noticeContext='" + noticeContext + '\'' +
                ", signKey='" + signKey + '\'' +
                ", communityId=" + communityId +
                ", signInTime=" + signInTime +
                '}';
    }
}
