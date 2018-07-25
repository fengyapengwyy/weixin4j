package com.foxinmy.weixin4j.model.poiwxa.poi;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhangbin
 * @since 2017/7/8 20:09
 */
public class WxaPoiAdd {
    @JSONField(name = "map_poi_id", ordinal = 1)
    private String mapPoiId;
    @JSONField(name = "pic_list", ordinal = 2)
    private String picList;
    @JSONField(name = "contract_phone", ordinal = 3)
    private String contractPhone;
    @JSONField(name = "hour", ordinal = 4)
    private String hour;
    @JSONField(ordinal = 5)
    private String credential;
    @JSONField(name = "company_name", ordinal = 6)
    private String companyName;
    @JSONField(name = "qualification_list", ordinal = 7)
    private String qualificationList;
    @JSONField(name = "card_id", ordinal = 8)
    private String cardId;
    @JSONField(name = "poi_id", ordinal = 9)
    private String poiId;

    public String getMapPoiId() {
        return mapPoiId;
    }

    public void setMapPoiId(String mapPoiId) {
        this.mapPoiId = mapPoiId;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public String getContractPhone() {
        return contractPhone;
    }

    public void setContractPhone(String contractPhone) {
        this.contractPhone = contractPhone;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(String qualificationList) {
        this.qualificationList = qualificationList;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
}
