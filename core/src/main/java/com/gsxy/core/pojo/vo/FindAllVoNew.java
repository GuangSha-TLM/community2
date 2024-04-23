package com.gsxy.core.pojo.vo;

import java.util.List;
import java.util.Set;

public class FindAllVoNew {

    private List<FindAllVo> list;
    private Integer count;

    public FindAllVoNew(List<FindAllVo> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public FindAllVoNew() {
    }

    public List<FindAllVo> getList() {
        return list;
    }

    public void setList(List<FindAllVo> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FindAllVoNew{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
