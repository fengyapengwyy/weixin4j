package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.app.model.AuditInfo;
import com.foxinmy.weixin4j.app.model.Category;
import com.foxinmy.weixin4j.app.model.ExtInfo;
import com.foxinmy.weixin4j.app.model.SubmitAuditItem;
import com.foxinmy.weixin4j.app.type.AuditStatus;
import com.foxinmy.weixin4j.app.type.VisitStatus;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.ContentType;
import com.foxinmy.weixin4j.http.HttpHeaders;
import com.foxinmy.weixin4j.http.weixin.ApiResult;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.media.MediaDownloadResult;
import com.foxinmy.weixin4j.token.TokenManager;
import com.foxinmy.weixin4j.util.RegexUtil;
import com.foxinmy.weixin4j.util.StringUtil;

import java.util.List;

/**
 * 代码管理
 *
 * @see <a href='https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140610_Uavc4&token=&lang=zh_CN'></a>
 */
public class CodeApi extends AppApi {


    private final TokenManager tokenManager;

    public CodeApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     * 为授权的小程序帐号上传小程序代码
     *
     * @param templateId  代码库中的代码模版ID
     * @param extInfo     第三方自定义的配置
     * @param userVersion 代码版本号，开发者可自定义
     * @param userDesc    代码描述，开发者可自定义
     */
    public ApiResult commitCode(String templateId, ExtInfo extInfo, String userVersion, String userDesc) throws WeixinException {
        String commit_code_url = getRequestUri("commit_code_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("template_id", templateId);
        jsonObject.put("ext_json", JSON.toJSONString(extInfo));
        jsonObject.put("user_version", userVersion);
        jsonObject.put("user_desc", userDesc);
        WeixinResponse response = weixinExecutor
                .post(String.format(commit_code_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsResult();

    }


    /**
     * 获取体验小程序的体验二维码
     */
    public MediaDownloadResult getQrcode() throws WeixinException {
        String get_qrcode_url = getRequestUri("get_qrcode_url");
        WeixinResponse response = weixinExecutor.get(String.format(get_qrcode_url, tokenManager.getAccessToken()));
        HttpHeaders headers = response.getHeaders();
        String contentType = headers.getFirst(HttpHeaders.CONTENT_TYPE);
        String disposition = headers.getFirst(HttpHeaders.CONTENT_DISPOSITION);
        String fileName = RegexUtil.regexFileNameFromContentDispositionHeader(disposition);
        if (StringUtil.isBlank(fileName)) {
            fileName = String.format("%s.%s", "qr_code", contentType.split("/")[1]);
        }
        return new MediaDownloadResult(response.getContent(), ContentType.create(contentType), fileName);
    }

    /**
     * 获取可以用的分类信息
     */
    public List<Category> getCategorys() throws WeixinException {
        String get_category_url = getRequestUri("get_category_url");
        WeixinResponse response = weixinExecutor.get(String.format(get_category_url, tokenManager.getAccessToken()));
        return JSON.parseArray(response.getAsJson().getString("category_list"), Category.class);
    }


    /**
     * 获取小程序的第三方提交代码的页面配置
     */
    public List<String> getPages() throws WeixinException {
        String get_page_url = getRequestUri("get_page_url");
        WeixinResponse response = weixinExecutor.get(String.format(get_page_url, tokenManager.getAccessToken()));
        return JSON.parseArray(response.getAsJson().getString("page_list"), String.class);
    }

    /**
     * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
     *
     * @return 审核编号
     */
    public Long submitAudit(List<SubmitAuditItem> items) throws WeixinException {
        String submit_audit_url = getRequestUri("submit_audit_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("item_list", items);
        WeixinResponse response = weixinExecutor
                .post(String.format(submit_audit_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsJson().getLong("auditid");
    }

    /**
     * 获取第三方提交的审核版本的审核状态
     *
     * @param auditId 提交审核时获得的审核id
     */
    public AuditStatus getAuditStatus(Long auditId) throws WeixinException {
        String submit_audit_url = getRequestUri("get_auditstatus_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("auditid", auditId);
        WeixinResponse response = weixinExecutor
                .post(String.format(submit_audit_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        AuditInfo auditStatus = response.getAsObject(new TypeReference<AuditInfo>() {
        });

        switch (auditStatus.getStatus()) {
            case 0:
                return AuditStatus.SUCCESS;
            case 1:
                return AuditStatus.FAIL;
            default:
                return AuditStatus.AUDITING;
        }
    }

    /**
     * 获取第三方提交的审核版本的审核状态
     */
    public AuditInfo getLatestAuditStatus() throws WeixinException {
        String submit_audit_url = getRequestUri("get_latest_auditstatus_url");
        WeixinResponse response = weixinExecutor.get(String.format(submit_audit_url, tokenManager.getAccessToken()));
        return response.getAsObject(new TypeReference<AuditInfo>() {
        });
    }

    /**
     * 小程序审核撤回
     */
    public void undoCodeAudit() throws WeixinException {
        String undo_code_audit_url = getRequestUri("undo_code_audit_url");
        WeixinResponse response = weixinExecutor.get(String.format(undo_code_audit_url, tokenManager.getAccessToken()));
    }


    /**
     * 发布已通过审核的小程序（仅供第三方代小程序调用）
     */
    public ApiResult publishRelease() throws WeixinException {
        String release_url = getRequestUri("release_url");
        JSONObject jsonObject = new JSONObject();
        WeixinResponse response = weixinExecutor.post(String.format(release_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsResult();
    }

    /**
     * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）
     */
    public ApiResult changeVisitStatus(VisitStatus visitStatus) throws WeixinException {
        String change_visitstatus_url = getRequestUri("change_visitstatus_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", visitStatus);
        WeixinResponse response = weixinExecutor
                .post(String.format(change_visitstatus_url, tokenManager.getAccessToken()), jsonObject.toJSONString());
        return response.getAsResult();
    }


    /**
     * 小程序版本回退（仅供第三方代小程序调用）
     */
    public ApiResult revertcoderelease() throws WeixinException {
        String change_visitstatus_url = getRequestUri("revertcoderelease_url");
        WeixinResponse response = weixinExecutor.get(String.format(change_visitstatus_url, tokenManager.getAccessToken()));
        return response.getAsResult();
    }


}
