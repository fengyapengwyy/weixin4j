package com.foxinmy.weixin4j.model.poi;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 微信门店 列表信息
 * @className Poi
 * @author zhangbin
 * @date 2017年1月20日16:48:06
 * @since JDK 1.7
 */
public class PoiList implements Serializable{

	private static final long serialVersionUID = 7003829085380906379L;
	@JSONField(name = "total_count")
	private Integer totalCount; //记录总数量

	/**
	 * 1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段没有在更新中或更新已生效，可以再次更新
	 */
	@JSONField(name = "business_list")
	private List<Poi> list;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<Poi> getList() {
		return list;
	}

	public void setList(List<Poi> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PoiList{" +
				"totalCount=" + totalCount +
				", list=" + list +
				'}';
	}
}
