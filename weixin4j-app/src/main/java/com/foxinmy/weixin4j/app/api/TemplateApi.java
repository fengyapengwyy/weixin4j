package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.app.model.template.Message;
import com.foxinmy.weixin4j.app.model.template.Template;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.paging.Pageable;
import com.foxinmy.weixin4j.model.paging.Pagedata;
import com.foxinmy.weixin4j.token.TokenManager;

import java.util.List;

/**
 * 模版消息管理。
 *
 * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#%E6%A8%A1%E7%89%88%E6%B6%88%E6%81%AF%E7%AE%A1%E7%90%86">模版消息管理</a>
 * @since 1.8
 */
public class TemplateApi extends AppApi {

    private final TokenManager tokenManager;

    public TemplateApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 获取小程序模板库标题列表
     *
     * @param pageable the pagination information.
     * @return templates in library.
     * @throws WeixinException indicates getting access token failed or getting templates failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#1%E8%8E%B7%E5%8F%96%E5%B0%8F%E7%A8%8B%E5%BA%8F%E6%A8%A1%E6%9D%BF%E5%BA%93%E6%A0%87%E9%A2%98%E5%88%97%E8%A1%A8">获取小程序模板库标题列表</a>
     */
    public Pagedata<Template> getTemplatesInLibrary(final Pageable pageable) throws WeixinException {
        String template_library_list = getRequestUri("wxopen_template_library_list_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset", pageable.getOffset());
        jsonObject.put("count", pageable.getPageSize());
        WeixinResponse response = weixinExecutor
                .post(String.format(template_library_list, tokenManager.getAccessToken()), jsonObject.toJSONString());
        JSONObject result = response.getAsJson();
        List<Template> content = JSON.parseArray(result.getString("list"), Template.class);
        return new Pagedata<Template>(pageable, result.getIntValue("total_count"), content);
    }

    /**
     * 获取模板库某个模板标题下关键词库
     *
     * @param id 模板标题id，可通过接口获取，也可登录小程序后台查看获取
     * @return the template in library with specified ID.
     * @throws WeixinException indicates getting access token failed or getting template failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#2%E8%8E%B7%E5%8F%96%E6%A8%A1%E6%9D%BF%E5%BA%93%E6%9F%90%E4%B8%AA%E6%A8%A1%E6%9D%BF%E6%A0%87%E9%A2%98%E4%B8%8B%E5%85%B3%E9%94%AE%E8%AF%8D%E5%BA%93">获取模板库某个模板标题下关键词库</a>
     */
    public Template getTemplateInLibrary(String id) throws WeixinException {
        String wxopen_template_library_get_url = getRequestUri("wxopen_template_library_get_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        WeixinResponse response = weixinExecutor
                .post(String.format(wxopen_template_library_get_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsObject(new TypeReference<Template>() {
        });
    }

    /**
     * 组合模板并添加至帐号下的个人模板库
     *
     * @param id         模板标题id，可通过接口获取，也可登录小程序后台查看获取
     * @param keywordIds 开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如[3,5,4]或[4,5,3]），最多支持10个关键词组合
     * @return the added template ID.
     * @throws WeixinException indicates getting access token failed or adding template failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#3%E7%BB%84%E5%90%88%E6%A8%A1%E6%9D%BF%E5%B9%B6%E6%B7%BB%E5%8A%A0%E8%87%B3%E5%B8%90%E5%8F%B7%E4%B8%8B%E7%9A%84%E4%B8%AA%E4%BA%BA%E6%A8%A1%E6%9D%BF%E5%BA%93">组合模板并添加至帐号下的个人模板库</a>
     */
    public String addUserTemplate(String id, int[] keywordIds) throws WeixinException {
        String wxopen_template_add_url = getRequestUri("wxopen_template_add_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("keyword_id_list", keywordIds);
        WeixinResponse response = weixinExecutor
                .post(String.format(wxopen_template_add_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsJson().getString("template_id");
    }

    /**
     * 获取帐号下已存在的模板列表
     *
     * @param pageable the pagination information.
     * @return the templates.
     * @throws WeixinException indicates getting access token failed or getting template failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#4%E8%8E%B7%E5%8F%96%E5%B8%90%E5%8F%B7%E4%B8%8B%E5%B7%B2%E5%AD%98%E5%9C%A8%E7%9A%84%E6%A8%A1%E6%9D%BF%E5%88%97%E8%A1%A8">获取帐号下已存在的模板列表</a>
     */
    public List<Template> getUserTemplates(final Pageable pageable) throws WeixinException {
        String template_list_url = getRequestUri("wxopen_template_list_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offset", pageable.getOffset());
        jsonObject.put("count", pageable.getPageSize());
        WeixinResponse response = weixinExecutor
                .post(String.format(template_list_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        JSONObject result = response.getAsJson();
        return JSON.parseArray(result.getString("list"), Template.class);
    }

    /**
     * 删除帐号下的某个模板
     *
     * @param templateId 要删除的模板id
     * @throws WeixinException indicates getting access token failed or deleting template failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#5%E5%88%A0%E9%99%A4%E5%B8%90%E5%8F%B7%E4%B8%8B%E7%9A%84%E6%9F%90%E4%B8%AA%E6%A8%A1%E6%9D%BF">删除帐号下的某个模板</a>
     */
    public void deleteUserTemplate(String templateId) throws WeixinException {
        String wxopen_template_del_url = getRequestUri("wxopen_template_del_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("template_id", templateId);
        weixinExecutor.post(String.format(wxopen_template_del_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
    }

    /**
     * 发送模板消息
     *
     * @param message         模板消息体
     * @param templateId      所需下发的模板消息的 id。
     * @param page            点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     * @param formId          表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id。
     * @param data            模板内容，不填则下发空模板。
     * @param emphasisKeyword 模板需要放大的关键词，不填则默认无放大。
     * @throws WeixinException indicates getting access token failed, or sending template message failed.
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/api/notice.html#%E5%8F%91%E9%80%81%E6%A8%A1%E7%89%88%E6%B6%88%E6%81%AF">发送模版消息</a>
     */
    public void sendTemplateMessage(Message message) throws WeixinException {
        String wxopen_template_message_send_url = getRequestUri("wxopen_template_message_send_url");
        weixinExecutor.post(String.format(wxopen_template_message_send_url, tokenManager.getAccessToken()), JSON.toJSONString(message));

    }


}
