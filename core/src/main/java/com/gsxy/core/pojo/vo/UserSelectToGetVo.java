package com.gsxy.core.pojo.vo;

import java.io.Serializable;
/**
 * @author hln 2023-11-03
 *      根据前端用来指定字段的VO实体类
 */
public class UserSelectToGetVo implements Serializable {

    private Long id;
    private String name;
    private Integer college;
    private String grade;
    private String professional;

    public UserSelectToGetVo(Long id, String name, Integer college, String grade, String professional) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
    }

    public UserSelectToGetVo() {
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

    @Override
    public String toString() {
        return "UserSelectToGetVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                '}';
    }
}
