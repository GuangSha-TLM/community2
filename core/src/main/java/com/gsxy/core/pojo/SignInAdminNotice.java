package com.gsxy.core.pojo;

import java.io.Serializable;

public class SignInAdminNotice implements Serializable {

    private Long id;
    private String noticeContext;//通知内容
    private String sign_key;// 签到key
    private Long community_id;//社团id

    public SignInAdminNotice (){}

    public SignInAdminNotice(Long id, String noticeContext, String sign_key, Long community_id) {
        this.id = id;
        this.noticeContext = noticeContext;
        this.sign_key = sign_key;
        this.community_id = community_id;
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

    public String getSign_key() {
        return sign_key;
    }

    public void setSign_key(String sign_key) {
        this.sign_key = sign_key;
    }

    public Long getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Long community_id) {
        this.community_id = community_id;
    }

    @Override
    public String toString() {
        return "SignInAdminNotice{" +
                "id=" + id +
                ", noticeContext='" + noticeContext + '\'' +
                ", sign_key='" + sign_key + '\'' +
                ", community_id=" + community_id +
                '}';
    }
}
