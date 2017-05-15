package com.foxinmy.weixin4j.app.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 分类
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 16:28
 */
public class Category {

    @JSONField(name = "first_class")
    private String firstClass;
    @JSONField(name = "second_class")
    private String secondClass;

    @JSONField(name = "third_class")
    private String thirdClass;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public String getThirdClass() {
        return thirdClass;
    }

    public void setThirdClass(String thirdClass) {
        this.thirdClass = thirdClass;
    }
}
