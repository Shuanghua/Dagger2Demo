package com.shuanghua.dagger2demo.bean;

/**
 * Created by ShuangHua on 2016/5/7.
 */
public class Test {
    private String num;
    private String page;
    private String showapi_appid;
    private String showapi_sign;

    public Test(String num, String page, String showapi_appid, String showapi_sign) {
        this.num = num;
        this.page = page;
        this.showapi_appid = showapi_appid;
        this.showapi_sign = showapi_sign;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getShowapi_appid() {
        return showapi_appid;
    }

    public void setShowapi_appid(String showapi_appid) {
        this.showapi_appid = showapi_appid;
    }

    public String getShowapi_sign() {
        return showapi_sign;
    }

    public void setShowapi_sign(String showapi_sign) {
        this.showapi_sign = showapi_sign;
    }
}
