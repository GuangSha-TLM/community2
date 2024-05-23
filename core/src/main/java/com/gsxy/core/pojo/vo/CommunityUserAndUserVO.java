package com.gsxy.core.pojo.vo;

import java.io.Serializable;
import java.util.Date;

public class CommunityUserAndUserVO implements Serializable {

    private Long id;
    private String name;//姓名
    private Integer org;
    private String grade;
    private Integer college;//学院
    private String studentId;//学号
    private String professional;//专业
    private Date createTime;

    public CommunityUserAndUserVO(){}

    public CommunityUserAndUserVO(Long id, String name, Integer org, String grade, Integer college, String studentId, String professional, Date createTime) {
        this.id = id;
        this.name = name;
        this.org = org;
        this.grade = grade;
        this.college = college;
        this.studentId = studentId;
        this.professional = professional;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CommunityUserAndUserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", org=" + org +
                ", grade='" + grade + '\'' +
                ", college=" + college +
                ", studentId='" + studentId + '\'' +
                ", professional='" + professional + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
