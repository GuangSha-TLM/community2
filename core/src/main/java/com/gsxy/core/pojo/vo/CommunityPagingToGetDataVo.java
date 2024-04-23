package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Community;

import java.io.Serializable;
import java.util.List;
/**
 * @author zhuxinyu 2023-10-30
 * 分页查询返回数据实体类
 */
public class CommunityPagingToGetDataVo implements Serializable {
    private List<Community> list;
    private Integer count;

    public CommunityPagingToGetDataVo(){

    }

    public CommunityPagingToGetDataVo(List<Community> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<Community> getList() {
        return list;
    }

    public void setList(List<Community> list) {
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
        return "CommunityPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
