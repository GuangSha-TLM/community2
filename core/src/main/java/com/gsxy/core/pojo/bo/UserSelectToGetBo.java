package com.gsxy.core.pojo.bo;


import java.io.Serializable;
/**
 * @author hln 2023-11-03
 *      根据前端指定字段返回User信息的BO返回类
 */
public class UserSelectToGetBo implements Serializable {

    private String token;
    private String college;
    private String grade;
    private String professional;

    public UserSelectToGetBo(String token, String college, String grade, String professional) {
        this.token = token;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
    }

    public UserSelectToGetBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
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
        return "UserSelectToGetBo{" +
                "token='" + token + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                '}';
    }
}


