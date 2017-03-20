package com.foxinmy.weixin4j.model.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * TODO(这个类的作用)
 *
 * @auther: Feng Yapeng
 * @since: 2017/3/15 11:33
 */
public class MemberCardPayGiftCardRule {

    @JSONField(name = "type")
    public String type = "RULE_TYPE_PAY_MEMBER_CARD";

    @JSONField(name = "base_info")
    private BaseInfo baseInfo;

    @JSONField(name = "member_rule")
    private MemberRule memberRule;

    private MemberCardPayGiftCardRule() {
    }

    public MemberCardPayGiftCardRule(Builder builder) {
        this.baseInfo = new BaseInfo();
        this.baseInfo.setBeginTime(builder.beginTime);
        this.baseInfo.setEndTime(builder.endTime);
        this.baseInfo.setMchidList(builder.mchidList);
        this.memberRule.setCardId(builder.cardId);
        this.memberRule.setJumpUrl(builder.jumpUrl);
        this.memberRule.setLeastCost(builder.leastCost);
        this.memberRule.setMaxCost(builder.maxCost);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public MemberRule getMemberRule() {
        return memberRule;
    }

    public void setMemberRule(MemberRule memberRule) {
        this.memberRule = memberRule;
    }

    public static class BaseInfo {

        @JSONField(name = "mchid_list")
        private String[] mchidList;

        @JSONField(name = "begin_time")
        private int beginTime;

        @JSONField(name = "end_time")
        private int endTime;

        @JSONField(name = "create_time")
        private int createTime;

        @JSONField(name = "update_time")
        private int updateTime;


        public String[] getMchidList() {
            return mchidList;
        }

        public void setMchidList(String[] mchidList) {
            this.mchidList = mchidList;
        }

        public int getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(int beginTime) {
            this.beginTime = beginTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class MemberRule {

        @JSONField(name = "card_id")
        private String cardId;


        @JSONField(name = "least_cost")
        private String leastCost;

        @JSONField(name = "max_cost")
        private String maxCost;

        @JSONField(name = "jump_url")
        private String jumpUrl;

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public void setLeastCost(String leastCost) {
            this.leastCost = leastCost;
        }

        public void setMaxCost(String maxCost) {
            this.maxCost = maxCost;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }
    }


    public class Builder {

        private String[] mchidList;

        private int beginTime;

        private int endTime;

        private String cardId;

        private String leastCost;

        private String maxCost;

        private String jumpUrl;


        public Builder mchidList(String... mchidList) {
            this.mchidList = mchidList;
            return this;
        }

        public Builder beginTime(int beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        public Builder endTime(int mchidList) {
            this.endTime = endTime;
            return this;
        }

        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        public Builder leastCost(String leastCost) {
            this.leastCost = leastCost;
            return this;
        }

        public Builder maxCost(String maxCost) {
            this.maxCost = maxCost;
            return this;
        }

        public Builder jumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
            return this;
        }


    }

}
