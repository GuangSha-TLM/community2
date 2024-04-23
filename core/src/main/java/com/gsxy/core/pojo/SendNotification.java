package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class SendNotification implements Serializable {

    private Long createBy;//创建人
    private Date createTime;//创建时间
    private String context = "签到";//签到内容
    private String name;//签到人名
    private Integer kinds = 2;//签到状态
    private Long userId;//用户ID
    private String uuid;//uuid编码

    public SendNotification(Long createBy, Date createTime, String context, String name, Integer kinds, Long userId, String uuid) {
        this.createBy = createBy;
        this.createTime = createTime;
        this.context = context;
        this.name = name;
        this.kinds = kinds;
        this.userId = userId;
        this.uuid = uuid;
    }

    public SendNotification() {
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

    public Integer getKinds() {
        return kinds;
    }

    public void setKinds(Integer kinds) {
        this.kinds = kinds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "SendNotification{" +
                "createBy=" + createBy +
                ", createTime=" + createTime +
                ", context='" + context + '\'' +
                ", name='" + name + '\'' +
                ", kinds=" + kinds +
                ", userId=" + userId +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
