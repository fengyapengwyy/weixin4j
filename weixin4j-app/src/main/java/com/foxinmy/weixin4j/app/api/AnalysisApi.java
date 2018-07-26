package com.foxinmy.weixin4j.app.api;

import com.alibaba.fastjson.JSONObject;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.WeixinResponse;
import com.foxinmy.weixin4j.token.TokenManager;

/**
 * @author zhangbin
 * @since 2017/7/13 19:10
 */
public class AnalysisApi extends AppApi {

    private final TokenManager tokenManager;

    public AnalysisApi(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }


    public String dailySummaryTrend(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_daily_summary_trend_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date", beginDate);
        jsonObject.put("end_date", endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String dailyVisitTrend(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_daily_visit_trend_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date", beginDate);
        jsonObject.put("end_date", endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String weeklyVisitTrend(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_weekly_visit_trend_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",beginDate);
        jsonObject.put("end_date",endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String monthlyVisitTrend(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_monthly_visit_trend_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",beginDate);
        jsonObject.put("end_date",endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String visitDistribution(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_visit_distribution_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",beginDate);
        jsonObject.put("end_date",endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String dailyRetainInfo(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_daily_retain_info_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",beginDate);
        jsonObject.put("end_date",endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String weeklyRetainInfo(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_weekly_retain_info_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",beginDate);
        jsonObject.put("end_date",endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String monthlyRetainInfo(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_monthly_retain_info_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date",beginDate);
        jsonObject.put("end_date",endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

    public String visitPage(String beginDate, String endDate) throws WeixinException {
        String url = this.getRequestUri("analys_visit_page_url_url");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("begin_date", beginDate);
        jsonObject.put("end_date", endDate);
        WeixinResponse response = this.weixinExecutor.post(url, jsonObject.toJSONString());
        return response.getAsString();
    }

}