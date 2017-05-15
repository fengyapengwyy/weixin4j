package com.foxinmy.weixin4j.app.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 小程序 域名信息
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 11:18
 */
public class DomainInfo {

    /**
     * request合法域名
     */
    @JSONField(name = "requestdomain")
    private List<String> requestDomain;
    /**
     * socket合法域名
     */
    @JSONField(name = "wsrequestdomain")
    private List<String> wsrequestDomain;
    /**
     * uploadFile合法域名
     */
    @JSONField(name = "uploaddomain")
    private List<String> uploadDomain;
    /**
     * downloadFile合法域名
     */
    @JSONField(name = "downloaddomain")
    private List<String> downloadDomain;

    public List<String> getRequestDomain() {
        return requestDomain;
    }

    public void setRequestDomain(List<String> requestDomain) {
        this.requestDomain = requestDomain;
    }

    public List<String> getWsrequestDomain() {
        return wsrequestDomain;
    }

    public void setWsrequestDomain(List<String> wsrequestDomain) {
        this.wsrequestDomain = wsrequestDomain;
    }

    public List<String> getUploadDomain() {
        return uploadDomain;
    }

    public void setUploadDomain(List<String> uploadDomain) {
        this.uploadDomain = uploadDomain;
    }

    public List<String> getDownloadDomain() {
        return downloadDomain;
    }

    public void setDownloadDomain(List<String> downloadDomain) {
        this.downloadDomain = downloadDomain;
    }
}
