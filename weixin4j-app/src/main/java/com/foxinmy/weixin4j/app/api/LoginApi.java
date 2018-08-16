package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.app.model.Session;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.WeixinAccount;

/**
 * TODO(这个类的作用)
 *
 * @auther: Feng Yapeng
 * @since: 2018/8/10 9:35
 */
public class LoginApi extends AppApi {

    private final WeixinAccount weixinAccount;

    public LoginApi(WeixinAccount weixinAccount) {

        this.weixinAccount = weixinAccount;
    }


    /**
     * 登录凭证校验
     *
     * @param jsCode    登录时获取的 code
     * @return the session.
     * @throws WeixinException 发生错误时。比如 <code>js                                                                                                                                                                                              _code</code> 无效。
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/api-login.html#%E7%99%BB%E5%BD%95%E5%87%AD%E8%AF%81%E6%A0%A1%E9%AA%8C">登录凭证校验<a/>
     */
    public Session jscode2session(String jsCode) throws WeixinException {
        String jscode2sessionUri = String
                .format(getRequestUri("login_jscode2session_url"), weixinAccount.getId(), weixinAccount.getSecret(), jsCode);
        WeixinResponse response = weixinExecutor.get(jscode2sessionUri);
        return response.getAsObject(new TypeReference<Session>() {
        });
    }
}
