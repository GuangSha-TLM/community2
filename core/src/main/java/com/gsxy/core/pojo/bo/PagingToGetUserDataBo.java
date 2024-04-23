package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class PagingToGetUserDataBo implements Serializable {

    private String token;
    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private String username;//id
    private Integer status;//0为私有活动 1多个社团活动 2 所有社团活动
    private Integer delFlag;//逻辑删除

    public PagingToGetUserDataBo(String token, Long start, Integer size, String username, Integer status, Integer delFlag) {
        this.token = token;
        this.start = start;
        this.size = size;
        this.username = username;
        this.status = status;
        this.delFlag = delFlag;
    }

    public PagingToGetUserDataBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "PagingToGetUserDataBo{" +
                "token='" + token + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
