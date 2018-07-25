package com.foxinmy.weixin4j.app.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 送审项
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 16:45
 */
public class SubmitAuditItem {

    /**
     * 小程序的页面，可通过“获取小程序的第三方提交代码的页面配置”接口获得
     */
    private String address;
    /**
     * 小程序的标签，多个标签用空格分隔，标签不能多于10个，标签长度不超过20
     */
    private String tag;
    /**
     * 一级类目，可通过“获取授权小程序帐号的可选类目”接口获
     */
    @JSONField(name = "first_class")
    private String firstClass;
    /**
     * 二级类目(同上)
     */
    @JSONField(name = "second_class")
    private String secondClass;
    /**
     * 三级类目(同上)
     */
    @JSONField(name = "third_class")
    private String thirdClass;
    /**
     * 小程序页面的标题,标题长度不超过32
     */
    private String title;

    public String getAddress() {
        return address;
    }

    public SubmitAuditItem setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public SubmitAuditItem setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public SubmitAuditItem setFirstClass(String firstClass) {
        this.firstClass = firstClass;
        return this;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public SubmitAuditItem setSecondClass(String secondClass) {
        this.secondClass = secondClass;
        return this;
    }

    public String getThirdClass() {
        return thirdClass;
    }

    public SubmitAuditItem setThirdClass(String thirdClass) {
        this.thirdClass = thirdClass;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SubmitAuditItem setTitle(String title) {
        this.title = title;
        return this;
    }
}
