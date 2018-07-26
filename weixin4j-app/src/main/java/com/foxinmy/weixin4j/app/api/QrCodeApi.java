package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foxinmy.weixin4j.app.model.qrcode.WxaCodeParameter;
import com.foxinmy.weixin4j.app.model.qrcode.WxaCodeUnlimitParameter;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.token.TokenManager;

import java.awt.*;

/**
 * 获取二维码。
 *
 * <p>
 * 通过后台接口可以获取小程序任意页面的二维码，扫描该二维码可以直接进入小程序对应的页面。
 * 目前微信支持两种二维码，小程序码，小程序二维码。
 * </p>
 *
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/qrcode.html">获取二维码</a>
 * @since 1.8
 */
public class QrCodeApi extends AppApi {

    private final TokenManager tokenManager;

    public QrCodeApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }


    /**
     * 获取小程序码.
     *
     * <p>接口A: 适用于需要的码数量较少的业务场景</p>
     * <p>
     * 注意：通过该接口生成的小程序码，永久有效，数量限制见微信小程序文档文末说明，请谨慎使用。
     * 用户扫描该码进入小程序后，将直接进入 path 对应的页面。
     * </p>
     *
     * @param path      不能为空，最大长度 128 字节
     * @param width     二维码的宽度，默认值 430
     * @param autoColor 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     * @param lineColor <code>authColor</code> 为 false 时生效
     * @param hyaline   是否需要透明底色， 为true时，生成透明底色的小程序码
     * @return image bytes of WXA code.
     * @throws WeixinException indicates getting access token failed or getting WXA code failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/qrcode.html#%E8%8E%B7%E5%8F%96%E5%B0%8F%E7%A8%8B%E5%BA%8F%E7%A0%81">获取小程序码</a>
     */
    public byte[] getWxaCode(String path, Integer width, Boolean autoColor, Color lineColor, Boolean hyaline) throws WeixinException {
        String template_library_list = getRequestUri("wxa_getwxacode_url");
        WxaCodeParameter wxaCodeParameter = new WxaCodeParameter(path, width, autoColor, lineColor, hyaline);
        WeixinResponse response = weixinExecutor
                .post(String.format(template_library_list, tokenManager.getAccessToken()), JSON.toJSONString(wxaCodeParameter));
        return response.getContent();
    }

    /**
     * 获取小程序码.
     *
     * <p>接口B：适用于需要的码数量极多的业务场景</p>
     * <p>
     * 注意：通过该接口生成的小程序码，永久有效，数量暂无限制。
     * 用户扫描该码进入小程序后，开发者需在对应页面获取的码中 scene 字段的值，再做处理逻辑。
     * 使用如下代码可以获取到二维码中的 scene 字段的值。
     * 调试阶段可以使用开发工具的条件编译自定义参数 scene=xxxx 进行模拟，
     * 开发工具模拟时的 scene 的参数值需要进行 urlencode。
     * <p>
     * <pre>
     * // 这是首页的 js
     * Page({
     *   onLoad: function(options) {
     *     // options 中的 scene 需要使用 decodeURIComponent 才能获取到生成二维码时传入的 scene
     *     var scene = decodeURIComponent(options.scene)
     *   }
     * })
     * </pre>
     *
     * @param scene     最大32个可见字符，只支持数字，
     *                  大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
     *                  其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     * @param page      必须是已经发布的小程序存在的页面（否则报错），
     *                  例如 "pages/index/index"，根路径前不要填加'/'，
     *                  不能携带参数（参数请放在scene字段里），
     *                  如果不填写这个字段，默认跳主页面
     * @param width     二维码的宽度，默认值 430
     * @param autoColor 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认值 false
     * @param lineColor <code>autoColor</code> 为 false 时生效，使用 rgb 设置颜色
     * @param hyaline   是否需要透明底色，为true时，生成透明底色的小程序码
     * @return image bytes of WXA code.
     * @throws WeixinException indicates getting access token failed or getting WXA code failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/qrcode.html#%E8%8E%B7%E5%8F%96%E5%B0%8F%E7%A8%8B%E5%BA%8F%E7%A0%81">获取小程序码</a>
     */
    public byte[] getWxaCodeUnlimit(String scene, String page, Integer width, Boolean autoColor, Color lineColor, Boolean hyaline)
            throws WeixinException {
        String template_library_list = getRequestUri("wxa_getwxacodeunlimit_url");
        WxaCodeUnlimitParameter wxaCodeParameter = new WxaCodeUnlimitParameter(scene, page, width, autoColor, lineColor, hyaline);
        WeixinResponse response = weixinExecutor
                .post(String.format(template_library_list, tokenManager.getAccessToken()), JSON.toJSONString(wxaCodeParameter));
        return response.getContent();
    }

    /**
     * 获取小程序二维码.
     *
     * <p>接口C：适用于需要的码数量较少的业务场景</p>
     * <p>
     * 注意：通过该接口生成的小程序二维码，永久有效，数量限制见微信小程序文档文末说明，请谨慎使用。
     * 用户扫描该码进入小程序后，将直接进入 path 对应的页面。
     * </p>
     *
     * @param path  不能为空，最大长度 128 字节
     * @param width 二维码的宽度，默认值 430
     * @return image bytes of WXA QR code.
     * @throws WeixinException indicates getting access token failed or getting WXA QR code failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/qrcode.html#%E8%8E%B7%E5%8F%96%E5%B0%8F%E7%A8%8B%E5%BA%8F%E4%BA%8C%E7%BB%B4%E7%A0%81">获取小程序二维码</a>
     */
    public byte[] createWxaQrCode(String path, Integer width) throws WeixinException {
        String template_library_list = getRequestUri("wxaapp_createwxaqrcode_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path", path);
        jsonObject.put("width", width);
        WeixinResponse response = weixinExecutor
                .post(String.format(template_library_list, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getContent();
    }


}
