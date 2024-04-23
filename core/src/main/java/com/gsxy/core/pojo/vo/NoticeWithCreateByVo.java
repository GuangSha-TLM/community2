package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.User;
import io.swagger.models.auth.In;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author Oh...Yeah!!! 2023-11-5
 * 用户查看通知的实体类
 */
public class NoticeWithCreateByVo {

    private Long id;
    private String noticeName;//通知的名字
    private Long UserEmailId;
    private Long createBy;
    private String context;
    private String name; //用户的名字
    private String professional;
    private String grade;
    private Integer read;
    private Integer dealt;
    private Integer kinds;
    private Date createTime;
    private Long adminSignId;




    public NoticeWithCreateByVo() {
    }

    public NoticeWithCreateByVo(String name) {
        this.name = name;
    }

    public NoticeWithCreateByVo(Date createTime) {
        this.createTime = createTime;
    }

    public NoticeWithCreateByVo(Long id, String noticeName, Long userEmailId, Long createBy, String context, String name, String professional, String grade, Integer read, Integer dealt, Integer kinds,Date createTime,long adminSignId) {
        this.id = id;
        this.noticeName = noticeName;
        UserEmailId = userEmailId;
        this.createBy = createBy;
        this.context = context;
        this.name = name;
        this.professional = professional;
        this.grade = grade;
        this.read = read;
        this.dealt = dealt;
        this.kinds = kinds;
        this.createTime = createTime;
        this.adminSignId =adminSignId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public Long getUserEmailId() {
        return UserEmailId;
    }

    public void setUserEmailId(Long userEmailId) {
        UserEmailId = userEmailId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getDealt() {
        return dealt;
    }

    public void setDealt(Integer dealt) {
        this.dealt = dealt;
    }

    public Integer getKinds() {
        return kinds;
    }

    public void setKinds(Integer kinds) {
        this.kinds = kinds;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAdminSignId() {
        return adminSignId;
    }

    public void setAdminSignId(Long adminSignId) {
        this.adminSignId = adminSignId;
    }

    @Override
    public String toString() {
        return "NoticeWithCreateByVo{" +
                "id=" + id +
                ", noticeName='" + noticeName + '\'' +
                ", UserEmailId=" + UserEmailId +
                ", createBy=" + createBy +
                ", context='" + context + '\'' +
                ", name='" + name + '\'' +
                ", professional='" + professional + '\'' +
                ", grade='" + grade + '\'' +
                ", read=" + read +
                ", dealt=" + dealt +
                ", kinds=" + kinds +
                ", createTime=" + createTime +
                ", adminSignId=" + adminSignId +
                '}';
    }
}
