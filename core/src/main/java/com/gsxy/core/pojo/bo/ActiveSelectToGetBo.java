package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class ActiveSelectToGetBo implements Serializable {

    private String token; //jwt
    private ActiveToGetBo activeToGetBo;//活动指定返回字段实体类
    private CommunityInActiveBo communityInActiveBo;//社团包装返回字段实体类

    public ActiveSelectToGetBo(String token, ActiveToGetBo activeToGetBo, CommunityInActiveBo communityInActiveBo) {
        this.token = token;
        this.activeToGetBo = activeToGetBo;
        this.communityInActiveBo = communityInActiveBo;
    }

    public ActiveSelectToGetBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ActiveToGetBo getActiveToGetBo() {
        return activeToGetBo;
    }

    public void setActiveToGetBo(ActiveToGetBo activeToGetBo) {
        this.activeToGetBo = activeToGetBo;
    }

    public CommunityInActiveBo getCommunityInActiveBo() {
        return communityInActiveBo;
    }

    public void setCommunityInActiveBo(CommunityInActiveBo communityInActiveBo) {
        this.communityInActiveBo = communityInActiveBo;
    }

    @Override
    public String toString() {
        return "{" +
                "token='" + token + '\'' +
                ", active=" + activeToGetBo.toString() +
                ", community=" + communityInActiveBo.toString() +
                '}';
    }
}
