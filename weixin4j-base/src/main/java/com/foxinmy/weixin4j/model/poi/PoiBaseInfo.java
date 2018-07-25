package com.foxinmy.weixin4j.model.poi;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 门店信息基础数据
 *
 * @author zhangbin
 * @since 2017 /1/19 13:53
 */
public class PoiBaseInfo extends PoiChoose implements Serializable {
    private static final long serialVersionUID = -6356099322858257719L;

    /**
     * 接口中必填字段
     */
    /**
     * 门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、地址、分店名等信息，错误示例：北京国美）
     */
    @JSONField(name = "business_name", ordinal = 1)
    private String businessName;
    /**
     * 分店名称（不应包含地区信息，不应与门店名有重复，错误示例：北京王府井店）
     * 20个字以内
     */
    @JSONField(name = "branch_name", ordinal = 2)
    private String branchName;
    /**
     * 门店所在的省份（直辖市填城市名,如：北京市）
     * 10个字以内
     */
    @JSONField(name = "province", ordinal = 3)
    private String province;
    /**
     * 门店所在的城市
     * 10个字以内
     */
    @JSONField(name = "city", ordinal = 4)
    private String city;
    /**
     * 门店所在地区
     * 10个字以内
     */
    @JSONField(name = "district", ordinal = 5)
    private String district;
    /**
     * 门店所在的详细街道地址（不要填写省市信息）
     */
    @JSONField(name = "address", ordinal = 6)
    private String address;
    /**
     * 门店的电话（纯数字，区号、分机号均由“-”隔开
     */
    @JSONField(name = "telephone", ordinal = 7)
    private String telephone;
    /**
     * 门店的类型（不同级分类用“,”隔开，如：美食，川菜，火锅。详细分类参见附件：微信门店类目表）
     */
    @JSONField(name = "categories", ordinal = 8)
    private List<String> categories; //分类
    /**
     * 坐标类型
     * 1 为火星坐标
     * 2 为sogou经纬度
     * 3 为百度经纬度
     * 4 为mapbar经纬度
     * 5 为GPS坐标
     * 6 为sogou墨卡托坐标
     */
    @JSONField(name = "offset_type", ordinal = 9)
    private Integer offsetType;
    /**
     * 门店所在地理位置的经度
     */
    @JSONField(name = "longitude", ordinal = 10)
    private Double longitude;
    /**
     * 门店所在地理位置的纬度
     */
    @JSONField(name = "latitude", ordinal = 11)
    private Double latitude;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Integer getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(Integer offsetType) {
        this.offsetType = offsetType;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "PoiBaseInfo{" +
                "businessName='" + businessName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", categories=" + categories +
                ", offsetType=" + offsetType +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", " + super.toString()
                 +
                '}';
    }
}


