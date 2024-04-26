package com.gsxy.core.pojo.vo;

import java.io.Serializable;
import java.util.List;

public class SignInListVo implements Serializable {

    private List<String> listY;
    private List<String> listN;

    public SignInListVo(){}

    public SignInListVo(List<String> listY, List<String> listN) {
        this.listY = listY;
        this.listN = listN;
    }

    public List<String> getListY() {
        return listY;
    }

    public void setListY(List<String> listY) {
        this.listY = listY;
    }

    public List<String> getListN() {
        return listN;
    }

    public void setListN(List<String> listN) {
        this.listN = listN;
    }

    @Override
    public String toString() {
        return "SignInListVo{" +
                "listY=" + listY +
                ", listN=" + listN +
                '}';
    }
}
