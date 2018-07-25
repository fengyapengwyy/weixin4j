package com.foxinmy.weixin4j.mp.api;

import com.alibaba.fastjson.JSONObject;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.Token;
import com.foxinmy.weixin4j.token.TokenManager;

/**
 * 微信开放平台账号管理
 *
 * @auther: Feng Yapeng
 * @since: 2018/7/24 16:31
 * @see: <a
 * href="https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1498704199_1bcax&token=c4dcd5045c012e92fa3b3c2dc5ccf037d85cfd7c&lang=zh_CN"></a>
 */
public class OpenPlatformApi extends MpApi {

    /**
     * TokenManager 的tokenCreator 为 TokenCreator，storager 为正常的
     */
    private TokenManager tokenManager;

//	private static String preAuthCodeKey = "wx_pre_auth_code_%s";


    public OpenPlatformApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 该API用于创建一个开放平台帐号，并将一个尚未绑定开放平台帐号的公众号或小程序绑定至该开放平台帐号上。新创建的开放平台帐号的主体信息将设置为与之绑定的公众号或小程序的主体。
     *
     * @param appId 授权公众号或小程序的 appid
     * @return 所创建的开放平台帐号 的appid
     */
    public String create(String appId) throws WeixinException {
        JSONObject content = new JSONObject();
        content.put("appid", appId);
        Token token = tokenManager.getCache();
        String cgi_open_create_uri = getRequestUri("cgi_open_create_uri");
        WeixinResponse response = weixinExecutor.post(String.format(cgi_open_create_uri, token.getAccessToken()), content.toJSONString());
        return response.getAsJson().getString("open_appid");
    }

    /**
     * 该API用于将一个尚未绑定开放平台帐号的公众号或小程序绑定至指定开放平台帐号上。二者须主体相同。
     *
     * @param appId     授权公众号或小程序的appid
     * @param openAppId 开放平台帐号appid
     * @return 没有错误，就表示成功
     */
    public void bind(String appId, String openAppId) throws WeixinException {
        JSONObject content = new JSONObject();
        content.put("appid", appId);
        content.put("open_appid", openAppId);
        Token token = tokenManager.getCache();
        String cgi_open_create_uri = getRequestUri("cgi_open_bind_uri");
        WeixinResponse response = weixinExecutor.post(String.format(cgi_open_create_uri, token.getAccessToken()), content.toJSONString());
    }

    /**
     * 该API用于将一个尚未绑定开放平台帐号的公众号或小程序绑定至指定开放平台帐号上。二者须主体相同。
     *
     * @param appId     授权公众号或小程序的appid
     * @param openAppId 开放平台帐号appid
     * @return 没有错误，就表示成功
     */
    public void unbind(String appId, String openAppId) throws WeixinException {
        JSONObject content = new JSONObject();
        content.put("appid", appId);
        content.put("open_appid", openAppId);
        Token token = tokenManager.getCache();
        String cgi_open_create_uri = getRequestUri("cgi_open_unbind_uri");
        weixinExecutor.post(String.format(cgi_open_create_uri, token.getAccessToken()), content.toJSONString());
    }

    /**
     * 该API用于获取公众号或小程序所绑定的开放平台帐号。
     *
     * @param appId 授权公众号或小程序的appid
     * @return 没有错误，就表示成功
     */
    public String getBoundOpenAppId(String appId) throws WeixinException {
        JSONObject content = new JSONObject();
        content.put("appid", appId);
        Token token = tokenManager.getCache();
        String cgi_open_create_uri = getRequestUri("cgi_open_get_uri");
        WeixinResponse response = weixinExecutor.post(String.format(cgi_open_create_uri, token.getAccessToken()), content.toJSONString());
        return response.getAsJson().getString("open_appid");
    }
}
