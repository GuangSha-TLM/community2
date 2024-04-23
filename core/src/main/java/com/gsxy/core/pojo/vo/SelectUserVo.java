package com.gsxy.core.pojo.vo;

public class SelectUserVo {

    private Long id;
    private String username;//用户名
    private String name;//姓名
    private Integer college;//学院
    private String studentId;//学号
    private Integer org;//班级
    private String grade;//年级
    private String professional;//专业
    private Integer role;//权限

    public SelectUserVo(Long id, String username, String name, Integer college, String studentId, Integer org, String grade, String professional, Integer role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.college = college;
        this.studentId = studentId;
        this.org = org;
        this.grade = grade;
        this.professional = professional;
        this.role = role;
    }

    public SelectUserVo() {
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

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SelectUserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", studentId='" + studentId + '\'' +
                ", org=" + org +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", role=" + role +
                '}';
    }
}
