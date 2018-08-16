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


    @JSONField(name = "first_id")
    private Integer firstId;
    @JSONField(name = "second_id")
    private Integer secondId;

    @JSONField(name = "third_id")
    private Integer thirdId;

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

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }
}
