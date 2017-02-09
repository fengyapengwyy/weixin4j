package com.foxinmy.weixin4j.model.poi;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 门店信息
 * 非必填字段
 * @author zhangbin
 * @since 2017 /1/19 13:53
 */
public class PoiChoose implements Serializable {

    private static final long serialVersionUID = 5900325069890670479L;

    @JSONField(name = "poi_id",ordinal=12)
    private String poiId;
    /**
     * 特殊字段 是选填字段,系统中使用
     */
    /**
     * 商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系。请商户自己保证唯一识别性
     */
    @JSONField(name = "sid",ordinal=0)
    private String sid;
    /**
     * 门店的电话（纯数字，区号、分机号均由“-”隔开
     */
    @JSONField(name = "telephone", ordinal = 7)
    private String telephone;

    /**
     * 选填字段(可不填写)
     */
    /**
     * 图片列表，url 形式，可以有多张图片，尺寸为 640*340px。
     * 必须为上一接口生成的url
     * 图片内容不允许
     * 与门店不相关 二维码、员工合照（或模特肖像）、营业执照、无门店正门的街景、地图截图、公交地铁站牌、菜单截图等
     */
    @JSONField(name = "photo_list",ordinal=14)
    private List<PoiPhoto> photoList;
    /**
     * 推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容
     * 200字以内
     */
    @JSONField(name = "recommend",ordinal=15)
    private String recommend;
    /**
     * 特色服务，如免费wifi，免费停车，送货上门等商户能提供的特色功能或服务
     */
    @JSONField(name = "special",ordinal=16)
    private String special;
    /**
     * 商户简介，主要介绍商户信息等
     * 300字以内
     */
    @JSONField(name = "introduction",ordinal=17)
    private String introduction;
    /**
     * 营业时间，24 小时制表示，用“-”连接
     * 如：8:00-20:00
     */
    @JSONField(name = "open_time",ordinal=18)
    private String openTime;
    /**
     * 人均价格，大于0 的整数
     */
    @JSONField(name = "avg_price",ordinal=19)
    private Integer avgPrice;


    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<PoiPhoto> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PoiPhoto> photoList) {
        this.photoList = photoList;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Integer getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Integer avgPrice) {
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "PoiChoose{" +
                "poiId='" + poiId + '\'' +
                ", sid='" + sid + '\'' +
                ", telephone='" + telephone + '\'' +
                ", photoList=" + photoList +
                ", recommend='" + recommend + '\'' +
                ", special='" + special + '\'' +
                ", introduction='" + introduction + '\'' +
                ", openTime='" + openTime + '\'' +
                ", avgPrice=" + avgPrice +
                '}';
    }
}
