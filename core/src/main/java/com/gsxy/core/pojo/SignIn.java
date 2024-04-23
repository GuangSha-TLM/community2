//package com.gsxy.core.pojo;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * 用户签到表
// */
//public class SignIn implements Serializable {
//
//    private Long id;
//    private Long userId;//用户ID
//    private Integer status;//签到状态（0:未签，1签到 注：默认为0）
//    private Long communityId;//社团ID
//    private Date createTime;//签到时间
//
//    public SignIn(Long id, Long userId, Integer status, Long communityId, Date createTime) {
//        this.id = id;
//        this.userId = userId;
//        this.status = status;
//        this.communityId = communityId;
//        this.createTime = createTime;
//    }
//
//    public SignIn() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public Long getCommunityId() {
//        return communityId;
//    }
//
//    public void setCommunityId(Long communityId) {
//        this.communityId = communityId;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    @Override
//    public String toString() {
//        return "SignIn{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", status=" + status +
//                ", communityId=" + communityId +
//                ", createTime=" + createTime +
//                '}';
//    }
//}
