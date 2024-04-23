package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 确认签到表 - 实体类
 */
public class SignInUserStatusWeb implements Serializable {

    private Long userId;//用户ID
    private Long adminId;//管理员(社长)ID
    private Long communityId;//社团ID
    private String name;//姓名
    private Integer college;//学院
    private String grade;//年级
    private String professional;//专业
    private Integer org;//班级
    private String studentId;//学号
    private Integer status;//签到状态
    private Date releaseTime;//签到发布状态
    private Date createTime;//用户进行签到时间
    private Integer signInTime;//签到时长
    private String uuid;//uuid

    public SignInUserStatusWeb(Long userId, Long adminId, Long communityId, String name, Integer college, String grade, String professional, Integer org, String studentId, Integer status, Date releaseTime, Date createTime, Integer signInTime, String uuid) {
        this.userId = userId;
        this.adminId = adminId;
        this.communityId = communityId;
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
        this.org = org;
        this.studentId = studentId;
        this.status = status;
        this.releaseTime = releaseTime;
        this.createTime = createTime;
        this.signInTime = signInTime;
        this.uuid = uuid;
    }

    public SignInUserStatusWeb() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Integer signInTime) {
        this.signInTime = signInTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "SignInUserStatusWeb{" +
                "userId=" + userId +
                ", adminId=" + adminId +
                ", communityId=" + communityId +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", org=" + org +
                ", studentId='" + studentId + '\'' +
                ", status=" + status +
                ", releaseTime=" + releaseTime +
                ", createTime=" + createTime +
                ", signInTime=" + signInTime +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
