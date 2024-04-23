package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.NoticeWithUser;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 分页查询返回数据实体类
 */
public class NoticeWithUserPagingToGetDataVo implements Serializable {

    private List<NoticeWithUser> list;
    private Integer count;

    public NoticeWithUserPagingToGetDataVo() {
    }

    public NoticeWithUserPagingToGetDataVo(List<NoticeWithUser> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<NoticeWithUser> getList() {
        return list;
    }

    public void setList(List<NoticeWithUser> list) {
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
        return "NoticeWithUserPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
