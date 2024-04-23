package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Img;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  更新img
 */
public class ImgUpdateByIdBo implements Serializable {

    private String token;
    private Img img;

    public ImgUpdateByIdBo() {
    }

    public ImgUpdateByIdBo(String token, Img img) {
        this.token = token;
        this.img = img;
    }

    @Override
    public String toString() {
        return "ImgUpdateByIdBo{" +
                "token='" + token + '\'' +
                ", img=" + img +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

}
