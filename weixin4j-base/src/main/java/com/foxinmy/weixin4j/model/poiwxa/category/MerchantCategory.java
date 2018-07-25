package com.foxinmy.weixin4j.model.poiwxa.category;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhangbin
 * @since 2017/7/8 15:19
 */
public class MerchantCategory {
    @JSONField(name = "all_category_info")
    private AllCategoryInfo allCategoryInfo;

    public AllCategoryInfo getAllCategoryInfo() {
        return allCategoryInfo;
    }

    public void setAllCategoryInfo(AllCategoryInfo allCategoryInfo) {
        this.allCategoryInfo = allCategoryInfo;
    }
}
