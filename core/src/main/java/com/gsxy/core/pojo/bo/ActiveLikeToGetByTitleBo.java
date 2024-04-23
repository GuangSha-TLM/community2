package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class ActiveLikeToGetByTitleBo implements Serializable {

    private String token;
    private String title;
    private Integer status;
    private Integer delFlag;

    public ActiveLikeToGetByTitleBo(String token, String title, Integer status, Integer delFlag) {
        this.token = token;
        this.title = title;
        this.status = status;
        this.delFlag = delFlag;
    }

    public ActiveLikeToGetByTitleBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        return "ActivePagingQueryByTitleBo{" +
                "token='" + token + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
