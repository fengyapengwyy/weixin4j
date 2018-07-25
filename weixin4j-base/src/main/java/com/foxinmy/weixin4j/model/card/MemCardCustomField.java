package com.foxinmy.weixin4j.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.type.card.FieldNameType;

/**
 * 会员卡自定义类型
 *
 * @auther: Feng Yapeng
 * @since: 2016/12/15 10:49
 */
public class MemCardCustomField {

    /**
     * 会员信息类目半自定义名称，当开发者变更这类类目信息的value值时，可以选择触发系统模板消息通知用户。
     */
    @JSONField(name = "name_type")
    private FieldNameType nameType;

    /**
     * 会员信息类目自定义名称，当开发者变更这类类目信息的value值时, 不会触发系统模板消息通知用户
     */
    private String name;
    /**
     * 点击类目跳转外链url
     */
    private String url;
    /**
     * s
     */
    private String tips;

    /**
     * 自定义入口小程序user_name，格式为原始id+@app
     */
    @JSONField(name = "app_brand_user_name")
    private String appBrandUserName;

    /**
     * 自定义入口小程序的页面路径
     */
    @JSONField(name = "app_brand_pass")
    private String appBrandPass;

    public MemCardCustomField(FieldNameType fieldNameType, String url) {
        this.nameType = fieldNameType;
        this.url = url;
    }

    public MemCardCustomField(FieldNameType fieldNameType, String name, String url) {
        this.nameType = fieldNameType;
        this.name = name;
        this.url = url;
    }

    public MemCardCustomField(String name, String url, String tips) {
        this.name = name;
        this.url = url;
        this.tips = tips;
    }

    public MemCardCustomField(String name, String url, String tips, String appBrandUserName, String appBrandPass) {
        this.name = name;
        this.url = url;
        this.tips = tips;
        if (appBrandUserName != null) {
            this.appBrandPass = "".equals(appBrandPass) ? "" : appBrandPass;
            this.appBrandUserName = "".equals(appBrandUserName) ? "" : appBrandUserName + "@app";
        }
    }

    public FieldNameType getNameType() {
        return nameType;
    }

    public void setNameType(FieldNameType nameType) {
        this.nameType = nameType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getAppBrandUserName() {
        return appBrandUserName;
    }

    public void setAppBrandUserName(String appBrandUserName) {
        this.appBrandUserName = appBrandUserName;
    }

    public String getAppBrandPass() {
        return appBrandPass;
    }

    public void setAppBrandPass(String appBrandPass) {
        this.appBrandPass = appBrandPass;
    }
}
