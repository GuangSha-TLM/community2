package com.gsxy.core.pojo.vo;

/**
 * @author Oh...Yeah!!! 2023-10-30
 * 为社长发送用户的申请信息
 */
public class UserSendMessageVo {

    private String Username;
    private String Professional;
    private String Grade;
    private String ApplyContext;

    public UserSendMessageVo() {
    }

    public UserSendMessageVo(String username, String professional, String grade, String applyContext) {
        Username = username;
        Professional = professional;
        Grade = grade;
        ApplyContext = applyContext;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getProfessional() {
        return Professional;
    }

    public void setProfessional(String professional) {
        Professional = professional;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getApplyContext() {
        return ApplyContext;
    }

    public void setApplyContext(String applyContext) {
        ApplyContext = applyContext;
    }

    @Override
    public String toString() {
        return "UserSendMessageVo{" +
                "Username='" + Username + '\'' +
                ", Professional='" + Professional + '\'' +
                ", Grade='" + Grade + '\'' +
                ", ApplyContext='" + ApplyContext + '\'' +
                '}';
    }
}
