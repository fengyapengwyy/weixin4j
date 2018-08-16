package com.foxinmy.weixin4j.app.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 审核信息
 *
 * @auther: Feng Yapeng
 * @since: 2018/8/14 17:13
 */
public class AuditInfo {


    @JSONField(name = "auditid")
    private String auditId;

    private Integer status;

    private String reason;

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
