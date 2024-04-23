package com.gsxy.core.pojo;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;


public class SignInAdmin implements Serializable {

    private Long id;
    private Long adminId;//管理员ID
    private Long communityId;//社团ID
    private Integer status;//签到状态(0 未签,1签到)
    private Date createTime;//签到发布时间

    public SignInAdmin(Long id, Long adminId, Long communityId, Integer status, Date createTime) {
        this.id = id;
        this.adminId = adminId;
        this.communityId = communityId;
        this.status = status;
        this.createTime = createTime;
    }

    public SignInAdmin() {
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
        return "SignInAdmin{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", communityId=" + communityId +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
