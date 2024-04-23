package com.gsxy.core.pojo.vo;

import java.io.Serializable;
import java.util.List;

public class UserSelectToGetListVo implements Serializable {

    private List<UserSelectToGetVo> list;

    public UserSelectToGetListVo(List<UserSelectToGetVo> list) {
        this.list = list;
    }

    public UserSelectToGetListVo() {
    }

    public List<UserSelectToGetVo> getList() {
        return list;
    }

    public void setList(List<UserSelectToGetVo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserSelectToGetListVo{" +
                "list=" + list +
                '}';
    }
}
