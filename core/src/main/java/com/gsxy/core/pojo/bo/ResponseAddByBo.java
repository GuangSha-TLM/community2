package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Response;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过增加数据
 */

public class ResponseAddByBo implements Serializable {

    private String token;
    private Response response;

    public ResponseAddByBo() {
    }

    public ResponseAddByBo(String token, Response response) {
        this.token = token;
        this.response = response;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ResponseAddByBo{" +
                "token='" + token + '\'' +
                ", response=" + response +
                '}';
    }
}
