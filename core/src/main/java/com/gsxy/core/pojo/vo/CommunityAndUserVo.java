package com.gsxy.core.pojo.vo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-30
 *      查询用户的所有信息
 */
public class CommunityAndUserVo implements Serializable {
    private Long userId;
    private String name;//姓名
    private String studentId;//学号
    private Integer college;//学院
    private String professional;//专业
    private Integer org;//班级
    private String grade;//年级

    public CommunityAndUserVo() {
    }

    public CommunityAndUserVo(Long userId, String name, String studentId, Integer college, String professional, Integer org, String grade) {
        this.userId = userId;
        this.name = name;
        this.studentId = studentId;
        this.college = college;
        this.professional = professional;
        this.org = org;
        this.grade = grade;
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

    @Override
    public String toString() {
        return "CommunityAndUserVo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", college=" + college +
                ", professional='" + professional + '\'' +
                ", org=" + org +
                ", grade='" + grade + '\'' +
                '}';
    }
}
