package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Org;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuxinyu 2023-10-30
 * 分页查询返回数据实体类
 */
public class OrgPagingToGetDataVo implements Serializable {
    private List<Org> list;
    private Integer count;
    public OrgPagingToGetDataVo(){
    }

    public OrgPagingToGetDataVo(List<Org> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<Org> getList() {
        return list;
    }

    public void setList(List<Org> list) {
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
        return "OrgPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
