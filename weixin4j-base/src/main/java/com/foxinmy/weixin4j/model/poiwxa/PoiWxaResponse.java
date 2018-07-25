package com.foxinmy.weixin4j.model.poiwxa;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 门店小程序 返回接口
 *
 * @author zhangbin
 * @since 2017/7/8 15:17
 */
public class PoiWxaResponse {
    private Integer errcode;
    private String errmsg;
    private String data; //部分查询的返回值
    private String business;//门店拉取接口
    @JSONField(name = "business_list")
    private String businesslist;//门店列表信息

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinesslist() {
        return businesslist;
    }

    public void setBusinesslist(String businesslist) {
        this.businesslist = businesslist;
    }
}
