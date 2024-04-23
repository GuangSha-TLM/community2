package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过id查询img
 */
public class ImgSelectByIdBo implements Serializable{

    private Long id;
    private String token;

    public ImgSelectByIdBo() {

    }

    public ImgSelectByIdBo(Long id, String token) {
        this.id = id;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ImgSelectByIdBo{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
