package com.foxinmy.weixin4j.model.poiwxa.category;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author zhangbin
 * @since 2017/7/8 15:20
 */
public class CategoryInfo {
    private Integer id;
    private String name; //名称
    private Integer level; //级别
    private Integer father;//父亲节点
    private List<Integer> children;//子节点
    private Qualify qualify;//需要资质

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFather() {
        return father;
    }

    public void setFather(Integer father) {
        this.father = father;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }

    public Qualify getQualify() {
        return qualify;
    }

    public void setQualify(Qualify qualify) {
        this.qualify = qualify;
    }

    static class Qualify {
        @JSONField(name = "exter_list")
        private List<ExterList> exterList;
        private Integer scene;
        @JSONField(name = "sensitive_type")
        private Integer sensitiveType; ////如果sensitive_type=1，在创建门店小程序时，需要添加相关证件

        public List<ExterList> getExterList() {
            return exterList;
        }

        public void setExterList(List<ExterList> exterList) {
            this.exterList = exterList;
        }

        public Integer getScene() {
            return scene;
        }

        public void setScene(Integer scene) {
            this.scene = scene;
        }

        public Integer getSensitiveType() {
            return sensitiveType;
        }

        public void setSensitiveType(Integer sensitiveType) {
            this.sensitiveType = sensitiveType;
        }
    }

    static class ExterList {
        @JSONField(name = "inner_list")
        private List<InnerList> innerList;

        public List<InnerList> getInnerList() {
            return innerList;
        }

        public void setInnerList(List<InnerList> innerList) {
            this.innerList = innerList;
        }
    }

    static class InnerList {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
