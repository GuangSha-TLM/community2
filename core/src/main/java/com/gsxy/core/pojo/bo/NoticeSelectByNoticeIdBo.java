package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  用户根据通知Id来查看通知.
 */
public class NoticeSelectByNoticeIdBo implements Serializable {

    private String token;
    private Long id;

    public NoticeSelectByNoticeIdBo() {
    }

    public NoticeSelectByNoticeIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NoticeSelectByNoticeIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
