package com.foxinmy.weixin4j.app.model.qrcode;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class WxaCodeUnlimitParameter implements Serializable {

	private static final long serialVersionUID = 2018052201L;

	/**
	 * 	最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
	 */
	private String scene;
	/**
	 * 必须是已经发布的小程序存在的页面（否则报错），例如 "pages/index/index" ,根路径前不要填加'/',不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
	 */
	private String page;
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

	public WxaCodeUnlimitParameter(
		String scene,
		String page,
		Integer width,
		Boolean autoColor,
		java.awt.Color color,
		Boolean hyaline
	) {
		this.scene = scene;
		this.page = page;
		this.width = width;
		this.autoColor = autoColor;
		if (color != null) {
			this.color = new Color(color);
		}
		this.hyaline = hyaline;
	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
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
