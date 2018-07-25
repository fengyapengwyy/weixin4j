package com.foxinmy.weixin4j.model.poiwxa.poi;

import com.alibaba.fastjson.annotation.JSONField;


public class WxaPoiUpdate {
    @JSONField(name = "poi_id", ordinal = 0)
    private String poiId; //门店ID
    @JSONField(name = "hour", ordinal = 1)
    private String hour;
    @JSONField(name = "contract_phone", ordinal = 2)
    private String contractPhone;
    @JSONField(name = "pic_list", ordinal = 3)
    private String picList;
    @JSONField(name = "card_id", ordinal = 4)
    private String cardId;
    @JSONField(name = "map_poi_id", ordinal = 5)
    private String mapPoiId;

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getContractPhone() {
        return contractPhone;
    }

    public void setContractPhone(String contractPhone) {
        this.contractPhone = contractPhone;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMapPoiId() {
        return mapPoiId;
    }

    public void setMapPoiId(String mapPoiId) {
        this.mapPoiId = mapPoiId;
    }
}
