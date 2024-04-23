package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Community;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-24
 *  社团数据更新
 */
public class CommunityUpdateByIdBo implements Serializable {
    private String token;
    private Community community;//社团实体类

    public CommunityUpdateByIdBo(){

    }

    public CommunityUpdateByIdBo(String token, Community community) {
        this.token = token;
        this.community = community;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "CommunityUpdateByIdBo{" +
                "token='" + token + '\'' +
                ", community=" + community +
                '}';
    }
}
