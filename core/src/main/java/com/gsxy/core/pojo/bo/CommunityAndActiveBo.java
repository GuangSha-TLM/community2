package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author  zhuxinyu 2023-11-02
 *      根据社团Id查询社团的所有活动
 */
public class CommunityAndActiveBo implements Serializable {
    private String token;
    private Long communtiyId;//社团id
    public CommunityAndActiveBo(){

    }

    public CommunityAndActiveBo(String token, Long communtiyId) {
        this.token = token;
        this.communtiyId = communtiyId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCommuntiyId() {
        return communtiyId;
    }

    public void setCommuntiyId(Long communtiyId) {
        this.communtiyId = communtiyId;
    }

    @Override
    public String toString() {
        return "CommunityAndActiveBo{" +
                "token='" + token + '\'' +
                ", communtiyId=" + communtiyId +
                '}';
    }
}
