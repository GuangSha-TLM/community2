package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Active;

import java.io.Serializable;
import java.util.List;

public class PagingToGetActiveDataVO implements Serializable {

    private List<Active> list;
    private Long count;

    public PagingToGetActiveDataVO(List<Active> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public PagingToGetActiveDataVO() {
    }

    public List<Active> getList() {
        return list;
    }

    public void setList(List<Active> list) {
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
        return "PagingToGetActiveDataVO{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
