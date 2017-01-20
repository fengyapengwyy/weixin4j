package com.foxinmy.weixin4j.model.poi;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信门店
 * @className Poi
 * @author zhangbin
 * @date 2017年1月19日13:52:39
 * @since JDK 1.7
 */
public class Poi extends PoiBaseInfo{
	private static final long serialVersionUID = -1149061095642414212L;
	/**
	 * 可用状态
	 * 1 表示系统错误、2 表示审核中、3 审核通过、4 审核驳回。当该字段为1、2、4 状态时
	 */
	@JSONField(name = "available_state")
	private Integer availableState;

	/**
	 * 1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段没有在更新中或更新已生效，可以再次更新
	 */
	@JSONField(name = "update_status")
	private Integer updateStatus;

	public Integer getAvailableState() {
		return availableState;
	}

	public void setAvailableState(Integer availableState) {
		this.availableState = availableState;
	}

	public Integer getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(Integer updateStatus) {
		this.updateStatus = updateStatus;
	}

	@Override
	public String toString() {
		return "Poi{" +
				"availableState=" + availableState +
				", updateStatus=" + updateStatus +
				", " + super.toString() +
				'}';
	}
}
