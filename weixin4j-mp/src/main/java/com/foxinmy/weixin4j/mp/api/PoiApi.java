package com.foxinmy.weixin4j.mp.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.model.poi.Poi;
import com.foxinmy.weixin4j.model.poi.PoiBaseInfo;
import com.foxinmy.weixin4j.model.poi.PoiChoose;
import com.foxinmy.weixin4j.model.poi.PoiList;
import com.foxinmy.weixin4j.token.TokenManager;

import java.util.ArrayList;
import java.util.List;


/**
 * 门店API
 *
 * @className PoiApi
 * @author zhangbin
 * @date 2017年1月19日13:52:32
 * @since JDK 1.7
 * @see <a href="https://mp.weixin.qq.com/wiki?action=doc&id=mp1444378120&t=0.07305985013605498#wxmdjkwd">微信门店接口文档</a>
 */
public class PoiApi extends MpApi {

	protected final TokenManager tokenManager;

	public PoiApi(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}

	/**
	 * 创建一个门店
	 * @param poi the poi
	 * @return the string
	 * @throws WeixinException the weixin exception
	 * @author zhangbin
	 * @since -2017-01-19 18:12:11
	 */
	public String createPoi(PoiBaseInfo poi) throws WeixinException {
		JSONObject baseInfo = new JSONObject();
		baseInfo.put("base_info",poi);
		JSONObject business = new JSONObject();
		business.put("business", baseInfo);
		//System.err.println(business.toJSONString());
		String poi_create_uri = getRequestUri("poi_create_uri");
		WeixinResponse response = weixinExecutor.post(
				String.format(poi_create_uri, tokenManager.getAccessToken()),
				business.toJSONString());
		return response.getAsJson().getString("poi_id");
	}

	/**
	 * 查询门店信息
	 * 查询不到 则抛一个异常!
	 * @param poiId the poi id
	 * @return the poi
	 * @throws WeixinException
	 */
	public Poi getPoi(String poiId) throws WeixinException {
		JSONObject request = new JSONObject();
		request.put("poi_id",poiId);
		String poi_get_uri = getRequestUri("poi_get_uri");
		WeixinResponse response = weixinExecutor.post(
				String.format(poi_get_uri, tokenManager.getAccessToken()),
				request.toJSONString());
		String jsonBody = response.getAsJson().getJSONObject("business").getString("base_info");
		return JSON.parseObject(jsonBody, new TypeReference<Poi>() {
		});
	}

	/**
	 * 查询 当前账户下 门店的数量
	 * @return the integer
	 * @throws WeixinException the weixin exception
	 * @author zhangbin
	 * @since -2017-01-20 16:37:32
	 */
	public Integer countPoi() throws WeixinException {
		JSONObject request = new JSONObject();
		request.put("begin",0);
		request.put("limit",1);//坑爹的微信 必须传入1
		String poi_get_list_uri = getRequestUri("poi_get_list_uri");
		WeixinResponse response = weixinExecutor.post(
				String.format(poi_get_list_uri, tokenManager.getAccessToken()),
				request.toJSONString());
		return response.getAsJson().getInteger("total_count");
	}

	/**
	 * 查询微信门店列表
	 * @param begin the begin
	 * @param limit the limit
	 * @return the poi list
	 * @throws WeixinException the weixin exception
	 */
	public PoiList getPoiList(Integer begin, Integer limit) throws WeixinException {
		begin=(begin==null)?begin=0:begin;
		limit=(limit==null)?limit=30:limit;
		JSONObject request = new JSONObject();
		request.put("begin",begin);
		request.put("limit",limit);
		String poi_get_list_uri = getRequestUri("poi_get_list_uri");
		WeixinResponse response = weixinExecutor.post(
				String.format(poi_get_list_uri, tokenManager.getAccessToken()),
				request.toJSONString());
		PoiList list = new PoiList();
		list.setTotalCount(response.getAsJson().getInteger("total_count"));
		JSONArray jsonArray = response.getAsJson().getJSONArray("business_list");
		List<Poi> array = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++) {
			Poi poi = JSON.parseObject(jsonArray.getJSONObject(i).getString("base_info"), new TypeReference<Poi>() {
			});
			array.add(poi);
		}
		list.setList(array);
		return list;
	}

	/**
	 * 修改门店基本信息
	 * (可变信息)
	 * @param poi the poi
	 * @return the boolean
	 * @throws WeixinException the weixin exceptionTODO(方法作用)Update poi.
	 * @author zhangbin
	 * @since -2017-01-20 16:38:16
	 */
	public boolean updatePoi(PoiChoose poi) throws WeixinException {
		JSONObject baseInfo = new JSONObject();
		baseInfo.put("base_info",poi);
		JSONObject request = new JSONObject();
		request.put("business", baseInfo);
		String poi_update_uri = getRequestUri("poi_update_uri");
		WeixinResponse response = weixinExecutor.post(
				String.format(poi_update_uri, tokenManager.getAccessToken()),
				request.toJSONString());
		if("0".equals(response.getAsResult().getReturnCode())){
			return true;
		}
		return false;
	}

	/**
	 * 删除一个门店
	 *
	 * @param poiId the poi id
	 * @return the boolean
	 * @throws WeixinException the weixin exception
	 * @author zhangbin
	 * @since -2017-01-20 16:38:31
	 */
	public boolean deletePoi(String poiId) throws WeixinException {
        JSONObject request = new JSONObject();
        request.put("poi_id",poiId);
        String poi_del_uri = getRequestUri("poi_del_uri");
        WeixinResponse response = weixinExecutor.post(
                String.format(poi_del_uri, tokenManager.getAccessToken()),
                request.toJSONString());
        if("0".equals(response.getAsResult().getReturnCode())){
            return true;
        }
        return false;
    }

	/**
	 * 查询 设置门店(创建门店)
	 * 所使用的 门店分类信息
	 *
	 * @return the category list
	 * @throws WeixinException the weixin exception
	 */
	public List<String> getCategoryList() throws WeixinException {
		String poi_category_uri = getRequestUri("poi_category_uri");
		WeixinResponse response = weixinExecutor.post(
				String.format(poi_category_uri, tokenManager.getAccessToken()),"");
		String jsonBody = response.getAsJson().getString("category_list");
		return JSON.parseObject(jsonBody, new TypeReference<List<String>>() {
		});
	}

}
