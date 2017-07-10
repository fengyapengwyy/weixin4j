package com.foxinmy.weixin4j.model.poiwxa.map;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

/**
 * 腾讯地图查询出的门店
 *
 * @author zhangbin
 * @since 2017/7/8 17:09
 */
public class QQPoi {
    @JSONField(name = "branch_name")
    private String branchName;//店铺名称
    private String address;//地址
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String telephone;
    private String category;//分类
    @JSONField(name = "sosomap_poi_uid")
    private String sosomapPoiUid; //即后面创建门店接口中的map_poi_id参数
    @JSONField(name = "data_supply")
    private Integer dataSupply; //2需要上传证件
    @JSONField(name = "pic_urls")
    private List<String> picUrls;
    @JSONField(name = "card_id_list")
    private List<String> cardIdList;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSosomapPoiUid() {
        return sosomapPoiUid;
    }

    public void setSosomapPoiUid(String sosomapPoiUid) {
        this.sosomapPoiUid = sosomapPoiUid;
    }

    public Integer getDataSupply() {
        return dataSupply;
    }

    public void setDataSupply(Integer dataSupply) {
        this.dataSupply = dataSupply;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public List<String> getCardIdList() {
        return cardIdList;
    }

    public void setCardIdList(List<String> cardIdList) {
        this.cardIdList = cardIdList;
    }
}
