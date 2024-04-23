package com.gsxy.core.pojo.bo;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过id删除数据
 */
public class NoticeDeleteByIdBo {

    private String token;
    private Long id;

    public NoticeDeleteByIdBo() {
    }

    public NoticeDeleteByIdBo(String token, Long id) {
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
        return "NoticeDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
