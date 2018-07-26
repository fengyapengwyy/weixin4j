package com.foxinmy.weixin4j.app.model.template;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 模板消息的模板里的关键词。
 *
 * @since 1.8
 */
public class Keyword implements Serializable {

	private static final long serialVersionUID = 2018052601L;

	private int id;
	private String name;
	private String example;

	public int getId() {
		return id;
	}

	@JSONField(name = "keyword_id")
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
