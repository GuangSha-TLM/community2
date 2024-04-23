package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户签到返回前端实体类
 */
public class UserSignInBo implements Serializable {

    private String token;
    private Long Id;
    private Long userId;//用户ID
    private Long communityId;//社团ID
    private Integer status;//状态(0未签，1签到 默认为0)
    private Date createTime;//签到时间

    public UserSignInBo(String token, Long id, Long userId, Long communityId, Integer status, Date createTime) {
        this.token = token;
        Id = id;
        this.userId = userId;
        this.communityId = communityId;
        this.status = status;
        this.createTime = createTime;
    }

    public UserSignInBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserSignInBo{" +
                "token='" + token + '\'' +
                ", Id=" + Id +
                ", userId=" + userId +
                ", communityId=" + communityId +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
