package com.gsxy.core.pojo;

import java.io.Serializable;

public class SignInUserStatus implements Serializable {

    private Long id;
    private Long adminId;//管理员ID
    private Long userId;//用户ID
    private String name;//姓名（用户）
    private Integer college;//学院
    private String grade;//年级
    private String professional;//专业
    private Integer org;//班级
    private String studentId;//学号
    private Integer status;//状态(0未签，1签到 默认为0)

    public SignInUserStatus(Long id, Long adminId, Long userId, String name, Integer college, String grade, String professional, Integer org, String studentId, Integer status) {
        this.id = id;
        this.adminId = adminId;
        this.userId = userId;
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
        this.org = org;
        this.studentId = studentId;
        this.status = status;
    }

    public SignInUserStatus() {
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

    @Override
    public String toString() {
        return "SignInUserStatus{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", org=" + org +
                ", studentId='" + studentId + '\'' +
                ", status=" + status +
                '}';
    }
}
