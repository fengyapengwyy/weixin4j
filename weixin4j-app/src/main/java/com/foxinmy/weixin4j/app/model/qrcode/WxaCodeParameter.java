package com.foxinmy.weixin4j.app.model.qrcode;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *
 */
public class WxaCodeParameter implements Serializable {

    private static final long serialVersionUID = 2018052201L;

    /**
     * 不能为空，最大长度 128 字节
     */
    private String  path;
    /**
     * 二维码的宽度
     */
    private Integer width;
    /**
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     */
    private Boolean autoColor;
    /**
     * auto_color 为 false 时生效
     */
    private Color   color;
    /**
     * 是否需要透明底色， is_hyaline 为true时，生成透明底色的小程序码
     */
    private Boolean hyaline;

    public WxaCodeParameter( String path, Integer width, Boolean autoColor, java.awt.Color color, Boolean hyaline) {
        this.path = path;
        this.width = width;
        this.autoColor = autoColor;
        if (color != null) {
            this.color = new Color(color);
        }
        this.hyaline = hyaline;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @JSONField(name = "auto_color")
    public Boolean getAutoColor() {
        return autoColor;
    }

    public void setAutoColor(Boolean autoColor) {
        this.autoColor = autoColor;
    }

    @JSONField(name = "line_color")
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @JSONField(name = "is_hyaline")
    public Boolean getHyaline() {
        return hyaline;
    }

    public void setHyaline(Boolean hyaline) {
        this.hyaline = hyaline;
    }

}
