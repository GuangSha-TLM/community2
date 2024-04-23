package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-30
 *      分页查询实体类
 */
public class OrgPagingToGetDataBo implements Serializable {
    private String token;
    private String name;
    private Long start;
    private Integer size;
    private Integer status;
    private Integer delFlag;
    public OrgPagingToGetDataBo(){

    }

    public OrgPagingToGetDataBo(String token, String name, Long start, Integer size, Integer status, Integer delFlag) {
        this.token = token;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "OrgPagingToGetDataBo{" +
                "token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
