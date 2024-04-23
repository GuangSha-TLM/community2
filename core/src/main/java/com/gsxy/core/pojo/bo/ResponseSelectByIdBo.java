package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author Oh… Yeah!!!, 2023-10-28
 * 根据id查询数据.
 */
public class ResponseSelectByIdBo implements Serializable {

    private String token;
    private Long id;

    public ResponseSelectByIdBo() {
    }

    public ResponseSelectByIdBo(String token, Long id) {
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
        return "ResponseSelectByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
