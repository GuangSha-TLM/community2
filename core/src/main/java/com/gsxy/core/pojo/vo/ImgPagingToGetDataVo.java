package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Img;

import java.io.Serializable;
import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 分页查询返回数据实体类
 */
public class ImgPagingToGetDataVo implements Serializable {

    private List<Img> list;
    private Integer count;


    public ImgPagingToGetDataVo() {
    }

    public ImgPagingToGetDataVo(List<Img> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<Img> getList() {
        return list;
    }

    public void setList(List<Img> list) {
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
        return "ImgPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
