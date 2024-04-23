package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.User;

import java.io.Serializable;
import java.util.List;

public class PagingToGetUserDataVo implements Serializable {

    private List<User> list;
    private Long count;

    public PagingToGetUserDataVo(List<User> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public PagingToGetUserDataVo() {
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PagingToGetUserDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
