package com.foxinmy.weixin4j.model.poi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;


/**
 * @author zhangbin
 * @since 2017/1/20 11:49
 */
public class PoiTest {
    @Test
    public void testJson(){
        String jsonBody = "{\"business_name\":\"老张测试json反解\",\"address\":\"文化路永和国际2705\",\"city\":\"郑州市\",\"available_state\":2,\"latitude\":34.7679595947,\"open_time\":\"9:00-18:00\",\"telephone\":\"6336827\",\"recommend\":\"烤串\",\"avg_price\":10,\"sid\":\"11111\",\"photo_list\":[],\"special\":\"可以在户外烤\",\"update_status\":1,\"province\":\"河南省\",\"offset_type\":1,\"branch_name\":\"第二分店\",\"district\":\"金水区\",\"categories\":[\"美食,小吃快餐\"],\"poi_id\":\"466526036\",\"introduction\":\"这个可以审核不通过,若为人工审核请审核拒绝\",\"longitude\":113.667640686}";
        Poi baseInfo = JSON.parseObject(jsonBody, new TypeReference<Poi>() {
        });
        System.err.println(baseInfo);
    }
}