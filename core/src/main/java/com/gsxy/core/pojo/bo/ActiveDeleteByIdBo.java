package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author hln 2023-10-26
 *  删除活动数据实体类
 */
public class ActiveDeleteByIdBo implements Serializable {

    private String token;
    private Long id;

    public ActiveDeleteByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public ActiveDeleteByIdBo() {
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
        return "ActivityDeleteBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
