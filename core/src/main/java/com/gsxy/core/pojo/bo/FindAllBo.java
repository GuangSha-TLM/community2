package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class FindAllBo implements Serializable {

    private String token;
    private Integer college;//学院
    private String grade;//年级
    private String professional;//专业
    private Integer page;//开始长度
    private Integer size;//截止长度

    public FindAllBo(String token, Integer college, String grade, String professional, Integer page, Integer size) {
        this.token = token;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
        this.page = page;
        this.size = size;
    }

    public FindAllBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FindAllBo{" +
                "token='" + token + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
