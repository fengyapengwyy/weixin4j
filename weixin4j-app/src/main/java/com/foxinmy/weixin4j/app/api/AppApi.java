package com.foxinmy.weixin4j.app.api;

import com.foxinmy.weixin4j.api.BaseApi;

import java.util.ResourceBundle;

/**
 * 小程序api
 *
 * @auther: Feng Yapeng
 * @since: 2017/5/5 11:23
 */
public class AppApi extends BaseApi {

    private final static ResourceBundle WEIXIN_BUNDLE;

    static {
        WEIXIN_BUNDLE = ResourceBundle.getBundle("com/foxinmy/weixin4j/app/api/weixin");
    }

    @Override
    protected ResourceBundle weixinBundle() {
        return WEIXIN_BUNDLE;
    }
}
