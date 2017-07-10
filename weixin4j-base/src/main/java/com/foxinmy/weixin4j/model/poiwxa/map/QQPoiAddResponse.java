package com.foxinmy.weixin4j.model.poiwxa.map;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 地图 添加门店的返回值
 * @author zhangbin
 * @since 2017/7/8 17:36
 */
public class QQPoiAddResponse {
    private String error;
    private Result data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Result getData() {
        return data;
    }

    public void setData(Result data) {
        this.data = data;
    }

    static class Result{
        @JSONField(name = "base_id")
        private String baseId;
        @JSONField(name = "rich_id")
        private String richId;

        public String getBaseId() {
            return baseId;
        }

        public void setBaseId(String baseId) {
            this.baseId = baseId;
        }

        public String getRichId() {
            return richId;
        }

        public void setRichId(String richId) {
            this.richId = richId;
        }
    }

}
