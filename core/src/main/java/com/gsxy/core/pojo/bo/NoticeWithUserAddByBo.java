package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.NoticeWithUser;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过增加数据
 */
public class NoticeWithUserAddByBo implements Serializable {

    private String token;
    private NoticeWithUser noticeWithUser;

    public NoticeWithUserAddByBo() {
    }


    public NoticeWithUserAddByBo(String token, NoticeWithUser noticeWithUser) {
        this.token = token;
        this.noticeWithUser = noticeWithUser;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public NoticeWithUser getNoticeWithUser() {
        return noticeWithUser;
    }

    public void setNoticeWithUser(NoticeWithUser noticeWithUser) {
        this.noticeWithUser = noticeWithUser;
    }

    @Override
    public String toString() {
        return "NoticeWithUserAddByBo{" +
                "token='" + token + '\'' +
                ", noticeWithUser=" + noticeWithUser +
                '}';
    }
}
