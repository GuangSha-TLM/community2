package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-30
 *      分页查询实体类
 */
public class CommunityPagingToGetDataBo implements Serializable {
    private String token;
    private Long start;
    private Integer size;
    private Integer status;
    private Integer delFlag;
    public CommunityPagingToGetDataBo(){

    }

    public CommunityPagingToGetDataBo(String token, Long start, Integer size, Integer status, Integer delFlag) {
        this.token = token;
        this.start = start;
        this.size = size;
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
        return "CommunityPagingToGetDataBo{" +
                "token='" + token + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
