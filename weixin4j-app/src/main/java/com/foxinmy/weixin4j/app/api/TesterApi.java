package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.JSONObject;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.ApiResult;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.token.TokenManager;

/**
 * 第三方平台在帮助旗下授权的小程序提交代码审核之前，
 * 可先让小程序运营者体验，体验之前需要将运营者的个人微信号添加到该小程序的体验者名单中。
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 11:54
 * @see <a href='https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140588_nVUgx&token=&lang=zh_CN'></a>
 */
public class TesterApi extends AppApi {

    protected final TokenManager tokenManager;

    /**
     *
     * @param tokenManager
     */
    public TesterApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 绑定微信用户为小程序体验者[管理员默认有体验权限]
     * @param wechatId 微信号
     * @return
     * @throws WeixinException
     */
    public ApiResult bindTester(String wechatId) throws WeixinException {
        String bind_tester_url = getRequestUri("bind_tester_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wechatid", wechatId);
        WeixinResponse response = weixinExecutor.post(String.format(bind_tester_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsResult();
    }

    /**
     * 解除绑定小程序的体验者
     * @param wechatId 微信号
     * @return
     * @throws WeixinException
     */
    public ApiResult unbindTester(String wechatId) throws  WeixinException{
        String bind_tester_url = getRequestUri("unbind_tester_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wechatid", wechatId);
        WeixinResponse response = weixinExecutor.post(String.format(bind_tester_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsResult();
    }




}
