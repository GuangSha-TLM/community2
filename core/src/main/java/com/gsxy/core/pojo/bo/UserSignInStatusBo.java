package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户签到返回给前端所需字段
 */
public class UserSignInStatusBo implements Serializable {

    private String token;
    private Long id;
    private Long adminId;//管理员ID（仅用来进行连表查询）
    private Long userId;//用户ID
    private Long communityId;//社团ID
    private String name;//用户性名
    private Integer college;//学院
    private String grade;//年级
    private String professional;//专业
    private Integer org;//班级
    private String studentId;//学号
    private Integer status;//状态(0未签，1签到 默认为0)
    private Date createTime;//签到时间

    public UserSignInStatusBo(String token, Long id, Long adminId, Long userId, Long communityId, String name, Integer college, String grade, String professional, Integer org, String studentId, Integer status, Date createTime) {
        this.token = token;
        this.id = id;
        this.adminId = adminId;
        this.userId = userId;
        this.communityId = communityId;
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
        this.org = org;
        this.studentId = studentId;
        this.status = status;
        this.createTime = createTime;
    }

    public UserSignInStatusBo() {
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserSignInStatusBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", adminId=" + adminId +
                ", userId=" + userId +
                ", communityId=" + communityId +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", org=" + org +
                ", studentId='" + studentId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
