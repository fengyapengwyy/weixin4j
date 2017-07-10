package com.foxinmy.weixin4j.model.poiwxa.map;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author zhangbin
 * @since 2017/7/8 16:57
 */
public class DistrictResponse {
    private Integer status; //0正常
    private String message;// 信息
    @JSONField(name = "data_version")
    private String dataVersion;
    private List<List<QQDistrict>> result; //0 省 1 市 2 区

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public List<List<QQDistrict>> getResult() {
        return result;
    }

    public void setResult(List<List<QQDistrict>> result) {
        this.result = result;
    }
}
