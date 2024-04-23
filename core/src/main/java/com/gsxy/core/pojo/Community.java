package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxinyu 2023-10-23
 *      社团实体类
 */
public class Community implements Serializable {
    private Long id;
    private String name;    //社团班级
    private String introduce;//社团介绍
    private Long communityId;//社团id
    private Long createBy;    //创建人
    private Date createTime;    //创建时间
    private Long updateBy;    //修改人
    private Date updateTime;    //修改时间
    private Integer status;     //状态
    private Integer delFlag;   //逻辑删除
    private String remark;      //备注
    public Community(){

    }

    public Community(Long id, String name, String introduce, Long communityId, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag, String remark) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.communityId = communityId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
        this.remark = remark;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", communityId=" + communityId +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                ", remark='" + remark + '\'' +
                '}';
    }
}
