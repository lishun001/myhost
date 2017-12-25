package com.eason.api.zb;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.vo.gift.*;

import java.util.List;

/**
 * @apiDefine gift 礼物API
 */
public interface IGiftService {
		
	/**
	 * @apiVersion 1.0.0
	 * @apiGroup gift
	 * @apiPermission Android/IOS
	 * @api {GET} /gift/getList 礼物列表
	 * @apiName getList
	 * 
	 * @apiDescription 
	 * > 点击送礼按钮，进入礼物列表</br>
	 *
	 * @apiSuccess {Integer} giftId	礼物ID
	 * @apiSuccess {String} giftName	礼物名称 
	 * @apiSuccess {String} giftImg		礼物图片 地址
	 * @apiSuccess {String} giftPrice 	礼物价格
	 * @apiSuccess {String} specialStyle 特效方式
	 *
	 */
	public List<GiftResponseVo> getList(Integer userId) throws ServiceException;
	
	/**
	 * @apiVersion 1.0.0
	 * @apiGroup gift
	 * @apiPermission IM
	 * @api {POST}  /gift/sendGift/{zbId} 发送礼物
	 * @apiName sendGift
	 * 
	 * @apiDescription 
	 * > 在礼物列表，选好礼物跟价格，发送礼物</br>
	 * > 待定：IM实现？还是API实现？</br>
	 * @apiParam {Integer} giftId  礼物id
	 * @apiParam {Integer} giftNum  礼物数
	 * 
	 * @apiSuccess {String} userId		用户ID
	 * @apiSuccess {Double} diamondBalance 用户钻石余额
	 * @apiSuccess {Double} cost 消费金额
	 */
	public SendGiftResponseVo sendGift(Integer userId, Integer zbId, SendGiftRequestVo vo) throws ServiceException;
	
	/**
	 * @apiVersion 1.0.0
	 * @apiGroup gift
	 * @apiPermission IM
	 * @api {POST}  /gift/sendBombScreen/{zbId} 发送飞屏
	 * @apiName sendBombScreen
	 * 
	 * @apiDescription 
	 * > 在聊天窗口，选择飞屏，发送飞屏消息</br>
	 * > 待定：IM实现？还是API实现？</br>
	 * 
	 * @apiParam {String} msgText  飞屏内容
	 * 
	 * @apiSuccess {Integer} userId		用户ID
	 * @apiSuccess {Double} diamondBalance 用户钻石余额
	 * @apiSuccess {Double} cost 消费金额
	 */
	public SendBombScreenResponseVo sendBombScreen(Integer userId, Integer zbId, SendBombScreenRequestVo vo) throws ServiceException;
	
}
