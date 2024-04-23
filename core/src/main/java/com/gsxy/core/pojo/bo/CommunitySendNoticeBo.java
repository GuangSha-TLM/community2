package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-30
 *  接收发送入团申请的内容
 */
public class CommunitySendNoticeBo implements Serializable {

    private String token;
    private String applyContext;
    private Long communityId;
    private String communityAdminName;

    public CommunitySendNoticeBo() {
    }

    public CommunitySendNoticeBo(String token, String applyContext, Long communityId, String communityAdminName) {
        this.token = token;
        this.applyContext = applyContext;
        this.communityId = communityId;
        this.communityAdminName = communityAdminName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApplyContext() {
        return applyContext;
    }

    public void setApplyContext(String applyContext) {
        this.applyContext = applyContext;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityAdminName() {
        return communityAdminName;
    }

    public void setCommunityAdminName(String communityAdminName) {
        this.communityAdminName = communityAdminName;
    }

    @Override
    public String toString() {
        return "CommunitySendNoticeBo{" +
                "token='" + token + '\'' +
                ", applyContext='" + applyContext + '\'' +
                ", communityId=" + communityId +
                ", communityAdminName='" + communityAdminName + '\'' +
                '}';
    }
}
