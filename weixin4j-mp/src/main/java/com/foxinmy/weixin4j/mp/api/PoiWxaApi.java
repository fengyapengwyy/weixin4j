package com.foxinmy.weixin4j.mp.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.poiwxa.AuditInfo;
import com.foxinmy.weixin4j.model.poiwxa.PoiWxaResponse;
import com.foxinmy.weixin4j.model.poiwxa.category.MerchantCategory;
import com.foxinmy.weixin4j.model.poiwxa.map.*;
import com.foxinmy.weixin4j.model.poiwxa.poi.WxaBaseInfo;
import com.foxinmy.weixin4j.model.poiwxa.poi.WxaPoiAdd;
import com.foxinmy.weixin4j.model.poiwxa.poi.WxaPoiInfo;
import com.foxinmy.weixin4j.model.poiwxa.poi.WxaPoiUpdate;
import com.foxinmy.weixin4j.token.TokenManager;
import com.foxinmy.weixin4j.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 门店小程序
 *
 * @className PoiApi
 * @author zhangbin
 * @date 2017年1月19日13:52:32
 * @since JDK 1.7
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1496904104_cfEfT">微信门店小程序接口文档</a>
 */
public class PoiWxaApi extends MpApi {

	protected final TokenManager tokenManager;

	public PoiWxaApi(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}


    /**
     * 1拉取门店小程序类目
     * 请求方式：GET（请使用https协议）
     * @return 返回 分类的对象 具体格式
     * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1496904104_cfEfT
     * @throws WeixinException the weixin exception
     */
    public MerchantCategory getMerchantCategory() throws WeixinException {
		String uri = getRequestUri("poi_wxa_category_uri");
		WeixinResponse response = weixinExecutor.get(
				String.format(uri, tokenManager.getAccessToken()));
        PoiWxaResponse poiResponse = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        if(poiResponse.getErrcode()!=0){
            throw new WeixinException(String.valueOf(poiResponse.getErrcode()),poiResponse.getErrmsg());
        }
        String data = poiResponse.getData();
        return JSON.parseObject(data, new TypeReference<MerchantCategory>() {
        });
	}

    /**
     * 2.创建门店小程序
     * <p>
     * 说明：创建门店小程序提交后需要公众号管理员确认通过后才可进行审核。如果主管理员24小时超时未确认，才能再次提交。
     * 请求方式: POST（请使用https协议）
     * @author zhangbin
     * @since -2017-07-08 16:08:32
     */
    public PoiWxaResponse applyMerchant() throws WeixinException{
        throw new WeixinException("-1","当前功能未实现");
    }

    /**
     * 3.查询门店小程序审核结果
     * 请求方式: GET（请使用https协议）
     * https://api.weixin.qq.com/wxa/get_merchant_audit_info?access_token=TOKEN
     * @return 审核信息
     * @throws WeixinException the weixin exception
     */
    public AuditInfo getMerchantAuditInfo() throws WeixinException {
        String uri = getRequestUri("poi_wxa_get_merchant_audit_info_uri");
        WeixinResponse response = weixinExecutor.get(
                String.format(uri, tokenManager.getAccessToken()));
        PoiWxaResponse poiResponse = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        if(poiResponse.getErrcode()!=0){
            throw new WeixinException(String.valueOf(poiResponse.getErrcode()),poiResponse.getErrmsg());
        }
        String data = poiResponse.getData();
        return JSON.parseObject(data, new TypeReference<AuditInfo>() {
        });
    }

    /**
     * 4.修改门店小程序信息
     * 请求方式: POST（请使用https协议）
     * https://api.weixin.qq.com/wxa/modify_merchant?access_token=TOKEN
     *
     * @param headimgMediaid 图片的媒体ID
     * @param intro          小程序介绍
     * @return the audit info
     * @throws WeixinException the weixin exceptionTODO(方法作用)Modify merchant.
     * @author zhangbin
     * @since -2017-07-08 16:37:24
     */
    public PoiWxaResponse modifyMerchant(String headimgMediaid,String intro) throws WeixinException {
        String uri = getRequestUri("poi_wxa_modify_merchant_uri");
        JSONObject request = new JSONObject();
        request.put("headimg_mediaid",headimgMediaid);
        request.put("intro",intro);
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                request.toJSONString());
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        return result;
    }

    /**
     * 5.从腾讯地图拉取省市区信息
     * 请求方式: GET（请使用https协议）
     * @return the district
     * @throws WeixinException the weixin exception
     */
    public List<List<QQDistrict>> getDistrict() throws WeixinException {
        String uri = getRequestUri("poi_wxa_get_district_uri");
        WeixinResponse response = weixinExecutor.get(
                String.format(uri, tokenManager.getAccessToken()));
        DistrictResponse result = response.getAsObject(new TypeReference<DistrictResponse>() {
        });
        if(result.getStatus()!=0){
            throw new WeixinException(String.valueOf(result.getStatus()),result.getMessage());
        }
        return result.getResult();
    }


    /**
     * 6.在腾讯地图中搜索门店
     * 请求方式: POST（请使用https协议）
     *
     * @param districtId 区域ID
     * @param keyword    查询关键词
     * @return the list
     * @throws WeixinException the weixin exception
     * @author zhangbin
     * @since -2017-07-08 17:22:57
     */
    public List<QQPoi> searchMapPoi(String districtId,String keyword) throws WeixinException {
        String uri = getRequestUri("poi_wxa_search_map_poi_uri");
        JSONObject request = new JSONObject();
        request.put("districtid",districtId);
        request.put("keyword",keyword);
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                request.toJSONString());
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        if(result.getErrcode()!=0){
            throw new WeixinException(String.valueOf(result.getErrcode()),result.getErrmsg());
        }
        String data = result.getData();
        QQPoiList list = JSON.parseObject(data, new TypeReference<QQPoiList>() {
        });
        return list.getItem();
    }


    /**
     * 7.在腾讯地图中创建门店
     *
     * @param qqPoiAdd the qq poi add
     * @return the qq poi add response
     * @author zhangbin
     * @since -2017-07-08 17:39:06
     */
    public QQPoiAddResponse createMapPoi(QQPoiAdd qqPoiAdd) throws WeixinException {
        String uri = getRequestUri("poi_wxa_create_map_poi_uri");
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                JSON.toJSONString(qqPoiAdd));
        QQPoiAddResponse result = response.getAsObject(new TypeReference<QQPoiAddResponse>() {
        });
        if(StringUtil.isNotBlank(result.getError())||result.getData()==null){
            throw new WeixinException("-1",result.getError());
        }
        return result;
    }

    /**
     * 8.添加门店
     *
     * @param wxaPoiAdd the wxa poi add
     * @return the weixin response
     * @throws WeixinException the weixin exception
     * @author zhangbin
     * @since -2017-07-08 20:22:12
     */
    public PoiWxaResponse addStore(WxaPoiAdd wxaPoiAdd) throws WeixinException {
        String uri = getRequestUri("poi_wxa_add_store_uri");
        String accessToken = tokenManager.getAccessToken();//"NGo06IV8J4ENNlSc0yWFnmMAa4vBoZ8oQk-QWr_lHSkvOtcTy0lP5xhUcEuccj9Rl5rlyeKMUiloMKDbg0rVjjsM0-LAAsrb7jG19f2lJ9AzlKshRQVTZ5df3Iwg-HjEHNSgACARXC";
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, accessToken),
                JSON.toJSONString(wxaPoiAdd));
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        return result;
    }

    /**
     * 9.更新门店信息
     * @param wxaPoiUpdate the wxa poi update
     * @return the weixin response
     * @throws WeixinException the weixin exception
     * @author zhangbin
     * @since -2017-07-10 09:39:52
     */
    public PoiWxaResponse updateStore(WxaPoiUpdate wxaPoiUpdate) throws WeixinException {
        String uri = getRequestUri("poi_wxa_update_store_uri");

        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                JSON.toJSONString(wxaPoiUpdate));
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        return result;
    }

    /**
     * 10.获取单个门店信息
     * @param poiId the poi id
     * @return the store info
     * @throws WeixinException the weixin exception
     */
    public WxaPoiInfo getStoreInfo(String poiId) throws WeixinException {
        String uri = getRequestUri("poi_wxa_get_store_info_uri");
        Map<String,Object> request = new HashMap();
        request.put("poi_id",poiId);
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                JSON.toJSONString(request));
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        if(result.getErrcode()!=0){
            throw new WeixinException(String.valueOf(result.getErrcode()),result.getErrmsg());
        }
        String body = result.getBusiness();
        WxaBaseInfo baseInfo = JSON.parseObject(body, new TypeReference<WxaBaseInfo>() {
        });
        return baseInfo.getBaseInfo();
    }

    /**
     * 11.获取门店信息列表
     *
     * @param offset the offset
     * @param limit  the limit
     * @return the store info
     * @throws WeixinException the weixin exception
     */
    public List<WxaPoiInfo> getStoreList(Integer offset,Integer limit) throws WeixinException {
        String uri = getRequestUri("poi_wxa_get_store_list_uri");
        Map<String,Object> request = new HashMap();
        request.put("offset",offset);
        request.put("limit",limit);
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                JSON.toJSONString(request));
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        if(result.getErrcode()!=0){
            throw new WeixinException(String.valueOf(result.getErrcode()),result.getErrmsg());
        }
        String body = result.getBusinessList();
        List<WxaBaseInfo> baseInfoList = JSON.parseArray(body, WxaBaseInfo.class);
        List<WxaPoiInfo> poiList = new ArrayList<WxaPoiInfo>();
        for(WxaBaseInfo baseInfo:baseInfoList){
            poiList.add(baseInfo.getBaseInfo());
        }
        return poiList;
    }

    /**
     * 12.删除门店
     * @param poiId the poi id
     * @return the store info
     * @throws WeixinException the weixin exception
     */
    public PoiWxaResponse delStore(String poiId) throws WeixinException {
        String uri = getRequestUri("poi_wxa_del_store_uri");
        Map<String,Object> request = new HashMap();
        request.put("poi_id",poiId);
        WeixinResponse response = weixinExecutor.post(
                String.format(uri, tokenManager.getAccessToken()),
                JSON.toJSONString(request));
        PoiWxaResponse result = response.getAsObject(new TypeReference<PoiWxaResponse>() {
        });
        return result;
    }

}
