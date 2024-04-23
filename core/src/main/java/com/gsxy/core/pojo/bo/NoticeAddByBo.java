package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Notice;

import java.io.Serializable;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通过增加数据
 */
public class NoticeAddByBo implements Serializable {

    private String token;
    private Notice notice;

    public NoticeAddByBo() {
    }

    public NoticeAddByBo(String token, Notice notice) {
        this.token = token;
        this.notice = notice;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "NoticeAddByBo{" +
                "token='" + token + '\'' +
                ", notice=" + notice +
                '}';
    }
}
