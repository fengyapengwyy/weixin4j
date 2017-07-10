package com.foxinmy.weixin4j.model.poiwxa.map;

import java.math.BigDecimal;

/**
 * @author zhangbin
 * @since 2017/7/8 16:55
 */
public class QQLocation {
    private BigDecimal lat;
    private BigDecimal lng;

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
}
