package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-24
 *  社团数据查找
 */
public class CommunitySelectByIdBo implements Serializable {
    private String token;
    private Long id;
    public CommunitySelectByIdBo(){

    }
    public CommunitySelectByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CommunitySelectByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
