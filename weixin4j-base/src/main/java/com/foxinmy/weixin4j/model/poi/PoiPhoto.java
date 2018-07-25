package com.foxinmy.weixin4j.model.poi;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 门店图标信息
 * @author zhangbin
 * @since 2017/1/19 13:53
 */
public class PoiPhoto implements Serializable {
    private static final long serialVersionUID = -3028490745590081496L;
    @JSONField(name = "photo_url")
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "PoiPhoto{" +
                "photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
