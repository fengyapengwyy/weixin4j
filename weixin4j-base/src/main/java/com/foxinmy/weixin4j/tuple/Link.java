package com.foxinmy.weixin4j.tuple;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图文链接。
 *
 * @since 1.8
 */
public class Link implements NotifyTuple {

	private static final long serialVersionUID = 2018052901L;

	/**
	 * 消息标题
	 */
	private String title;
	/**
	 * 图文链接消息
	 */
	private String description;
	private String url;
	private String thumbUrl;

	public Link() {
	}

	public Link(
		String title,
		String description,
		String url,
		String thumbUrl
	) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.thumbUrl = thumbUrl;
	}

	@Override
	@JSONField(serialize = false)
	public String getMessageType() {
		return "link";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JSONField(name = "thumb_url")
	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

}