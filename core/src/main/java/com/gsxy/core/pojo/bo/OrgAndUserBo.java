package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxinyu 2023-10-25
 *      根据班级查询用户
 */
public class OrgAndUserBo implements Serializable {
    private Long id;
    private Integer college;//学院
    private String professional;//专业
    private Integer name;//班级
    private String grade;//年级
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public OrgAndUserBo(){

    }

    public OrgAndUserBo(Long id, Integer college, String professional, Integer name, String grade, Date createTime, Date updateTime) {
        this.id = id;
        this.college = college;
        this.professional = professional;
        this.name = name;
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

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
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
        return "OrgAndUserBo{" +
                "id=" + id +
                ", college=" + college +
                ", professional='" + professional + '\'' +
                ", name=" + name +
                ", grade='" + grade + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
