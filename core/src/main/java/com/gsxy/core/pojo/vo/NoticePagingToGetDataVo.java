package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Img;
import com.gsxy.core.pojo.Notice;

import java.io.Serializable;
import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 分页查询返回数据实体类
 */
public class NoticePagingToGetDataVo implements Serializable {


    private List<Notice> list;
    private Integer count;

    public NoticePagingToGetDataVo() {
    }

    public NoticePagingToGetDataVo(List<Notice> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<Notice> getList() {
        return list;
    }

    public void setList(List<Notice> list) {
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
        return "NoticePagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
