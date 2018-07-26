package com.foxinmy.weixin4j.app.model.template;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * TODO(这个类的作用)
 *
 * @auther: Feng Yapeng
 * @since: 2018/7/25 18:34
 */
public class Message {

    /**
     * 接收者（用户）的 openid
     */
    @JSONField(name = "touser")
    private String toUser;
    /**
     * 所需下发的模板消息的id
     */
    @JSONField(name = "template_id")
    private String templateId;
    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     */
    private String page;
    /**
     * 表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     */
    @JSONField(name = "form_id")
    private String formId;
    /**
     * 模板内容，不填则下发空模板
     */
    private Map<String, Message.Data> data;

    /**
     * 模板需要放大的关键词，不填则默认无放大
     */
    @JSONField(name = "emphasis_keyword")
    private String highlight;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Map<String, Data> getData() {
        return data;
    }

    public void setData(Map<String, Data> data) {
        this.data = data;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public static class Data {

        private String value;
        private String color;

        public Data() {
        }

        public Data(String value) {
            this.value = value;
        }

        public Data(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }


}