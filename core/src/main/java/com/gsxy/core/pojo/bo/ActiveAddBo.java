package com.gsxy.core.pojo.bo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ActiveAddBo implements Serializable {

    private String token;

    private String title;

    public ActiveAddBo(String token, String title) {
        this.token = token;
        this.title = title;
    }

    public ActiveAddBo() {
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

    @Override
    public String toString() {
        return "ActiveAddBo{" +
                "token='" + token + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

