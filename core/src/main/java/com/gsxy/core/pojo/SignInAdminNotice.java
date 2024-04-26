package com.gsxy.core.pojo;

import java.io.Serializable;

public class SignInAdminNotice implements Serializable {

    private Long id;
    private String noticeContext;//通知内容

    public SignInAdminNotice (){}

    public SignInAdminNotice(Long id, String noticeContext) {
        this.id = id;
        this.noticeContext = noticeContext;
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

    @Override
    public String toString() {
        return "SignInAdminNotice{" +
                "id=" + id +
                ", noticeContext='" + noticeContext + '\'' +
                '}';
    }
}
