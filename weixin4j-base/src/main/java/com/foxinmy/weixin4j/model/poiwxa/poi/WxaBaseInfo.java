package com.foxinmy.weixin4j.model.poiwxa.poi;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangbin
 * @since 2017/7/10 13:33
 */
public class WxaBaseInfo {
    @JSONField(name = "base_info")
    private WxaPoiInfo baseInfo;

    public WxaPoiInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(WxaPoiInfo baseInfo) {
        this.baseInfo = baseInfo;
    }
}
