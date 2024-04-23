package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Org;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-23
 *  班级添加实体类
 */
public class OrgAddBo implements Serializable {
    private String token;
    private Org org; //班级实体类
    public OrgAddBo(){

    }

    public OrgAddBo(String token, Org org) {
        this.token = token;
        this.org = org;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "OrgAddBo{" +
                "token='" + token + '\'' +
                ", org=" + org +
                '}';
    }
}
