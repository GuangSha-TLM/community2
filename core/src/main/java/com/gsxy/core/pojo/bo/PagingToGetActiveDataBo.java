package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class PagingToGetActiveDataBo implements Serializable {

    private String token;
    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private String title;//标题
    private Integer status;//0为私有活动 1多个社团活动 2 所有社团活动
    private Integer delFlag;//逻辑删除

    public PagingToGetActiveDataBo(String token, Long start, Integer size, String title, Integer status, Integer delFlag) {
        this.token = token;
        this.start = start;
        this.size = size;
        this.title = title;
        this.status = status;
        this.delFlag = delFlag;
    }

    public PagingToGetActiveDataBo() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "PagingToGetActiveDataBo{" +
                "token='" + token + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
