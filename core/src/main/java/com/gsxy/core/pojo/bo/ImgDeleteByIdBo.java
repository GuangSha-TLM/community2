package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过id删除img
 */
public class ImgDeleteByIdBo implements Serializable{

    private Long id;
    private String token;

    public ImgDeleteByIdBo() {
    }

    public ImgDeleteByIdBo(Long id, String token) {
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
        return "ImgDeleteByIdBo{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
