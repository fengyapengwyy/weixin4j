package com.foxinmy.weixin4j.model.poiwxa;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 审核信息
 *
 * @author zhangbin
 * @since 2017/7/8 16:29
 */
public class AuditInfo {
    @JSONField(name = "audit_id")
    private String auditId; //审核单id
    private Integer status;//审核状态，0：未提交审核，1：审核成功，2：审核中，3：审核失败，4：管理员拒绝
    private String reason;//审核状态为3或者4时，reason列出审核失败的原因

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
