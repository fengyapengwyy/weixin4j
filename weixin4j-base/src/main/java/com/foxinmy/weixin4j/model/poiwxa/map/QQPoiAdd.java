package com.foxinmy.weixin4j.model.poiwxa.map;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.util.List;

/**
 * 腾讯地图创建的门店
 * 注意 这里没有修改的概念
 * @author zhangbin
 * @since 2017 /7/8 17:09
 */
public class QQPoiAdd {
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private String longitude;
    @JSONField(ordinal = 3)
    private String latitude;
    @JSONField(ordinal = 4)
    private String province; //省
    @JSONField(ordinal = 5)
    private String city; //市
    @JSONField(ordinal = 6)
    private String district; //区
    @JSONField(ordinal = 7)
    private String address; //地址
    @JSONField(ordinal = 8)
    private String category; //类目
    @JSONField(ordinal = 9)
    private String telephone; //电话
    @JSONField(ordinal = 10)
    private String photo;//图片
    @JSONField(ordinal = 11)
    private String license; //执照
    @JSONField(ordinal = 12)
    private String introduct; //介绍
    @JSONField(ordinal = 13)
    private String districtid; //区域ID
    //@JSONField(name = "poi_id" ,ordinal = 14,serialzeFeatures =  {SerializerFeature.WriteMapNullValue})
    @JSONField(name = "poi_id" ,ordinal = 14)
    private String poiId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getIntroduct() {
        return introduct;
    }

    public void setIntroduct(String introduct) {
        this.introduct = introduct;
    }

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
}
