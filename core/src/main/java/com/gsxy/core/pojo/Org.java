package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxinyu 2023-10-23
 *      班级实体类
 */
public class Org implements Serializable {
    private Long id;
    private Integer college;//学院
    private String professional;//专业
    private String grade;//年级
    private Integer name; //班级
    private String createBy; //创建人
    private Date createTime; //创建时间
    private String updateBy; //修改人
    private Date updateTime; //修改时间
    private Integer status;  //状态
    private Integer delFlag;//逻辑删除
    public Org(){

    }

    public Org(Long id, Integer college, String professional, String grade, Integer name, String createBy, Date createTime, String updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.college = college;
        this.professional = professional;
        this.grade = grade;
        this.name = name;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", college=" + college +
                ", professional='" + professional + '\'' +
                ", grade='" + grade + '\'' +
                ", name=" + name +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }

    public void setCreateBy(Long userId) {
    }

    public void setUpdateBy(Long userId) {
    }
}

