package com.eason.api.zb.vo.zhubo;

import java.io.Serializable;

public class ZhuboResponseVo implements Serializable {

    private Integer zbId;    //主播ID
	private String zbNickname;  //主播昵称
	private String zbLevel;	    	//主播等级
	private String zbHeadImg; 	//主播头像
	private String zbSignature;     //主播个性签名
	private String zbBackgroundImg;     //直播背景图片
	private Integer isAttention;    //用户是否关注
	private Integer attentionUserTotal;     //粉丝：已关注主播的人数
	private Integer diamondGiftZBTotal;      //收礼：主播累计收礼统计
	private Integer costTotal;	    //消费

    public Integer getZbId() {
        return zbId;
    }

    public void setZbId(Integer zbId) {
        this.zbId = zbId;
    }

    public String getZbNickname() {
        return zbNickname;
    }

    public void setZbNickname(String zbNickname) {
        this.zbNickname = zbNickname;
    }

    public String getZbLevel() {
        return zbLevel;
    }

    public void setZbLevel(String zbLevel) {
        this.zbLevel = zbLevel;
    }

    public String getZbHeadImg() {
        return zbHeadImg;
    }

    public void setZbHeadImg(String zbHeadImg) {
        this.zbHeadImg = zbHeadImg;
    }

    public String getZbSignature() {
        return zbSignature;
    }

    public void setZbSignature(String zbSignature) {
        this.zbSignature = zbSignature;
    }

    public String getZbBackgroundImg() {
        return zbBackgroundImg;
    }

    public void setZbBackgroundImg(String zbBackgroundImg) {
        this.zbBackgroundImg = zbBackgroundImg;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public Integer getAttentionUserTotal() {
        return attentionUserTotal;
    }

    public void setAttentionUserTotal(Integer attentionUserTotal) {
        this.attentionUserTotal = attentionUserTotal;
    }

    public Integer getDiamondGiftZBTotal() {
        return diamondGiftZBTotal;
    }

    public void setDiamondGiftZBTotal(Integer diamondGiftZBTotal) {
        this.diamondGiftZBTotal = diamondGiftZBTotal;
    }

    public Integer getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(Integer costTotal) {
        this.costTotal = costTotal;
    }
}
