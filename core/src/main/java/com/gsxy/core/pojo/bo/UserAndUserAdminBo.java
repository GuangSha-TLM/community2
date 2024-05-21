package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class UserAndUserAdminBo implements Serializable {

    private Long id;
    private String username;//用户名
    private String name;//姓名
    private String college;//学院
    private String studentId;//学号
    private Integer org;//班级
    private String professional;//专业
    private String grade;//年级
    private Date loginTime;//登陆时间
    private Integer role;//权限

    public UserAndUserAdminBo(Long id, String username, String name, String college, String studentId, Integer org, String professional, String grade, Date loginTime, Integer role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.college = college;
        this.studentId = studentId;
        this.org = org;
        this.professional = professional;
        this.grade = grade;
        this.loginTime = loginTime;
        this.role = role;
    }

    public UserAndUserAdminBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserAndUserAdminBo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", studentId='" + studentId + '\'' +
                ", org=" + org +
                ", professional='" + professional + '\'' +
                ", grade='" + grade + '\'' +
                ", loginTime=" + loginTime +
                ", role=" + role +
                '}';
    }
}
