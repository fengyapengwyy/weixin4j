package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.app.model.DomainInfo;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.ApiResult;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.Token;
import com.foxinmy.weixin4j.token.TokenManager;

/**
 * 授权给第三方的小程序，其服务器域名只可以为第三方的服务器，当小程序通过第三方发布代码上线后，<br/>
 * 小程序原先自己配置的服务器域名将被删除，只保留第三方平台的域名，<br/>
 * 所以第三方平台在代替小程序发布代码之前，需要调用接口为小程序添加第三方自身的域名。
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 11:21
 * @see <a href='https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489138143_WPbOO&token=&lang=zh_CN'></a>
 */
public class DomainApi extends AppApi {

    protected final TokenManager tokenManager;

    /**
     *
     * @param tokenManager
     */
    public DomainApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 获取小程序的domainInfo
     * @return
     * @throws WeixinException
     */
    public DomainInfo getDomainInfo() throws WeixinException {
        String domain_url = getRequestUri("domain_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", "get");
        Token token = tokenManager.getCache();
        WeixinResponse response = weixinExecutor.post(String.format(domain_url, token.getAccessToken()),jsonObject.toJSONString());
        return response.getAsObject(new TypeReference<DomainInfo>(){});
    }

    /**
     * 添加域名
     * @param domainInfo
     * @return
     */
    public ApiResult addDomain(DomainInfo domainInfo) throws WeixinException {
        String domain_url = getRequestUri("domain_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", "add");
        jsonObject.put("requestdomain",domainInfo.getRequestDomain());
        jsonObject.put("wsrequestdomain",domainInfo.getWsrequestDomain());
        jsonObject.put("uploaddomain",domainInfo.getUploadDomain());
        jsonObject.put("downloaddomain",domainInfo.getDownloadDomain());
        Token token = tokenManager.getCache();
        WeixinResponse response = weixinExecutor.post(String.format(domain_url, token.getAccessToken()),jsonObject.toJSONString());
        return response.getAsResult();
    }


    /**
     * 覆盖域名
     * @param domainInfo
     * @return
     */
    public ApiResult setDomain(DomainInfo domainInfo) throws WeixinException {
        String domain_url = getRequestUri("domain_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", "set");
        jsonObject.put("requestdomain",domainInfo.getRequestDomain());
        jsonObject.put("wsrequestdomain",domainInfo.getWsrequestDomain());
        jsonObject.put("uploaddomain",domainInfo.getUploadDomain());
        jsonObject.put("downloaddomain",domainInfo.getDownloadDomain());
        Token token = tokenManager.getCache();
        WeixinResponse response = weixinExecutor.post(String.format(domain_url, token.getAccessToken()),jsonObject.toJSONString());
        return response.getAsResult();
    }

    /**
     * 删除域名
     * @param domainInfo
     * @return
     */
    public ApiResult deleteDomain(DomainInfo domainInfo) throws WeixinException {
        String domain_url = getRequestUri("domain_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", "delete");
        jsonObject.put("requestdomain",domainInfo.getRequestDomain());
        jsonObject.put("wsrequestdomain",domainInfo.getWsrequestDomain());
        jsonObject.put("uploaddomain",domainInfo.getUploadDomain());
        jsonObject.put("downloaddomain",domainInfo.getDownloadDomain());
        Token token = tokenManager.getCache();
        WeixinResponse response = weixinExecutor.post(String.format(domain_url, token.getAccessToken()),jsonObject.toJSONString());
        return response.getAsResult();
    }
}
