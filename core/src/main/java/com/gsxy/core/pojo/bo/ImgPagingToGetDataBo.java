package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 分页查询实体类
 */
public class ImgPagingToGetDataBo implements Serializable {

    private String token;
    private Long start;
    private Integer size;
    private String name;
    private Integer status;
    private Integer delFlag;

    public ImgPagingToGetDataBo() {
    }

    public ImgPagingToGetDataBo(String token, Long start, Integer size, String name, Integer status, Integer delFlag) {
        this.token = token;
        this.start = start;
        this.size = size;
        this.name = name;
        this.status = status;
        this.delFlag = delFlag;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "ImgPagingToGetDataBo{" +
                "token='" + token + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
