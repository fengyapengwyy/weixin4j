package com.foxinmy.weixin4j.model.poiwxa.poi;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangbin
 * @since 2017/7/10 13:33
 */
public class WxaPoiInfo {
    @JSONField(name = "business_name")
    private String businessName;
    private String address;//地址
    private String telephone;//电话
    private String city;//城市
    private String province;//省份
    private BigDecimal longitude;
    private BigDecimal latitude;
    @JSONField(name = "photo_list")
    private List<WxaPhoto> photoList;
    @JSONField(name = "open_time")
    private String openTime;
    @JSONField(name = "poi_id")
    private String poiId;
    private String district;//地区
    @JSONField(name = "qualification_num")
    private String qualificationNum; //证件号？
    @JSONField(name = "qualification_name")
    private String qualificationName; //看不懂 证件名称

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public List<WxaPhoto> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<WxaPhoto> photoList) {
        this.photoList = photoList;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getQualificationNum() {
        return qualificationNum;
    }

    public void setQualificationNum(String qualificationNum) {
        this.qualificationNum = qualificationNum;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }
}
