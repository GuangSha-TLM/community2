package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Img;
import com.gsxy.core.pojo.UserAdmin;

import java.io.Serializable;
import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 分页查询返回数据实体类
 */
public class UserAdminPagingToGetDataVo implements Serializable {

    private List<UserAdmin> list;
    private Integer count;

    public UserAdminPagingToGetDataVo() {
    }

    public UserAdminPagingToGetDataVo(List<UserAdmin> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<UserAdmin> getList() {
        return list;
    }

    public void setList(List<UserAdmin> list) {
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
        return "UserAdminPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
