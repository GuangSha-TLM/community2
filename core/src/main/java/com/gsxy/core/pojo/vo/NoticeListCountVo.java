package com.gsxy.core.pojo.vo;

import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-11-5
 * 用户查看通知返回结果的实体类
 */
public class NoticeListCountVo {

    private List<NoticeWithCreateByVo> list;
    private Long noReadCounts;

    public NoticeListCountVo() {
    }

    public NoticeListCountVo(List<NoticeWithCreateByVo> list, Long noReadCounts) {
        this.list = list;
        this.noReadCounts = noReadCounts;
    }

    public List<NoticeWithCreateByVo> getList() {
        return list;
    }

    public void setList(List<NoticeWithCreateByVo> list) {
        this.list = list;
    }

    public Long getNoReadCounts() {
        return noReadCounts;
    }

    public void setNoReadCounts(Long noReadCounts) {
        this.noReadCounts = noReadCounts;
    }

    @Override
    public String toString() {
        return "NoticeListCountVo{" +
                "list=" + list +
                ", noReadCounts=" + noReadCounts +
                '}';
    }
}
