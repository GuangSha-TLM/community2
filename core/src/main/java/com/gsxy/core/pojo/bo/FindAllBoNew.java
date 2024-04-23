package com.gsxy.core.pojo.bo;

public class FindAllBoNew {

    private Integer college;//学院
    private String grade;//年级
    private String professional;//专业
    private Integer page;//开始长度
    private Integer size;//截止长度
    private Long userId;//用户id

    public FindAllBoNew(Integer college, String grade, String professional, Integer page, Integer size, Long userId) {
        this.college = college;
        this.grade = grade;
        this.professional = professional;
        this.page = page;
        this.size = size;
        this.userId = userId;
    }

    public FindAllBoNew() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FindAllBoNew{" +
                "college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", page=" + page +
                ", size=" + size +
                ", userId=" + userId +
                '}';
    }
}
