package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class CommunityUserAndUserBo implements Serializable {
    private Long id;
    private String token;
    private String communityId;
    private String name;//姓名
    private String studentId;//学号
    private Integer college;//学院
    private String professional;//专业
    private Integer org;//班级
    private String grade;//年级
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public CommunityUserAndUserBo(){

    }

    public CommunityUserAndUserBo(Long id, String token, String communityId, String name, String studentId, Integer college, String professional, Integer org, String grade, Date createTime, Date updateTime) {
        this.id = id;
        this.token = token;
        this.communityId = communityId;
        this.name = name;
        this.studentId = studentId;
        this.college = college;
        this.professional = professional;
        this.org = org;
        this.grade = grade;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CommunityUserAndUserBo{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", communityId='" + communityId + '\'' +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", college=" + college +
                ", professional='" + professional + '\'' +
                ", org=" + org +
                ", grade='" + grade + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
