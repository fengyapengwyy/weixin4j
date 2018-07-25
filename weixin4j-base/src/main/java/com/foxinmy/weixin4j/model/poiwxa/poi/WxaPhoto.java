package com.foxinmy.weixin4j.model.poiwxa.poi;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhangbin
 * @since 2017/7/10 13:36
 */
public class WxaPhoto {
    @JSONField(name = "photo_url")
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
