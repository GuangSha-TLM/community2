package com.gsxy.core.pojo.bo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ActiveAddBo implements Serializable {

    private String token;
    private String title;
    private String context;

    public ActiveAddBo(String token, String title, String context) {
        this.token = token;
        this.title = title;
        this.context = context;
    }

    public ActiveAddBo() {
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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
                ", context='" + context + '\'' +
                '}';
    }
}

