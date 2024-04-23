package com.gsxy.core.pojo.bo;

import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-31
 *  社长向用户发送回复通知
 */
public class CommunityReplyNoticeBo implements Serializable {

    private String token;
    private String context;
    private Long noticeId;
    //社长同意或拒绝用户的申请(0:同意,1:拒绝)
    private Integer result;

    public String getToken() {
        return token;
    }

    public CommunityReplyNoticeBo(String token, String context, Long noticeId, Integer result) {
        this.token = token;
        this.context = context;
        this.noticeId = noticeId;
        this.result = result;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CommunityReplyNoticeBo{" +
                "token='" + token + '\'' +
                ", context='" + context + '\'' +
                ", noticeId=" + noticeId +
                ", result=" + result +
                '}';
    }
}
