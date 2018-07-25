package com.foxinmy.weixin4j.model.poiwxa.map;

import java.util.List;

/**
 * @author zhangbin
 * @since 2017/7/8 16:53
 */
public class QQDistrict {
    private String id;
    private String name;
    private String fullname; //注意 这里 就是全部小写
    private List<String> pinyin;
    private QQLocation location;
    private List<Integer> cidx;//子节点区间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getPinyin() {
        return pinyin;
    }

    public void setPinyin(List<String> pinyin) {
        this.pinyin = pinyin;
    }

    public QQLocation getLocation() {
        return location;
    }

    public void setLocation(QQLocation location) {
        this.location = location;
    }

    public List<Integer> getCidx() {
        return cidx;
    }

    public void setCidx(List<Integer> cidx) {
        this.cidx = cidx;
    }
}
