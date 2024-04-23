package com.gsxy.core.pojo.vo;

import java.io.Serializable;
/**
 * @author  zhuxinyu 2023-11-02
 *      根据社团Id查询社团的所有活动
 */
public class CommunityAndActiveVo implements Serializable {
    private Long   community;//社团id
    private String title;//活动标题
    private String context;//活动内容
    public CommunityAndActiveVo(){

    }

    public CommunityAndActiveVo(Long community, String title, String context) {
        this.community = community;
        this.title = title;
        this.context = context;
    }

    public Long getCommunity() {
        return community;
    }

    public void setCommunity(Long community) {
        this.community = community;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "CommunityAndActiveVo{" +
                "community=" + community +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
