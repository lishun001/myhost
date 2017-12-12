package com.eason.api.zb.service;

import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.ZhuboResponseVo;

import java.util.List;

/**
 * @apiDefine zhubo 主播API
 */
public interface IZhuboService {

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/getZhuboList/{userId}  主播列表
	 * @apiName overPlay
	 *
	 * @apiDescription
	 * > 点击收藏，没有关注列表，显示热门推荐主播</br>
	 * > 如果没有登陆，只需要传递0即可：/zhubo/getZhuboList/0</br>
	 *> 如果有登陆，只需要传递userId即可：/zhubo/getZhuboList/2</br>
	 * @apiSuccess {Integer} zbId	主播ID
	 * @apiSuccess {String} zbNickname	主播昵称
	 * @apiSuccess {String} zbLevel		主播等级
	 * @apiSuccess {String} zbHeadImg 	主播头像
	 * @apiSuccess {String} zbSignature 主播个性签名
	 * @apiSuccess {String} zbBackgroundImg  直播背景图片
	 * @apiSuccess {Integer} isAttention 用户是否关注
	 * @apiSuccess {Integer} attentionUserTotal 粉丝：已关注主播的人数
	 * @apiSuccess {Integer} diamondGiftZBTotal   收礼：主播累计收礼统计
	 * @apiSuccess {Integer} costTotal	当前用户消费。如果没有用户，忽略此字段
	 *
	 */
	public List<ZhuboResponseVo> getZhuboList(Integer userId);


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/{userId}/getZbDetail/{zbId} 主播详情
	 * @apiName getZbDetail
	 *
	 * @apiDescription
	 * > 点击主播头像，进入主播迷你卡，获取主播详情</br>
	 *
	 *
	 * @apiSuccess {Integer} zbId	主播ID
	 * @apiSuccess {String} zbNickname	主播昵称
	 * @apiSuccess {String} zbLevel		主播等级
	 * @apiSuccess {String} zbHeadImg 	主播头像
	 * @apiSuccess {String} zbSignature 主播个性签名
	 * @apiSuccess {String} zbBackgroundImg  直播背景图片
	 * @apiSuccess {Integer} isAttention 用户是否关注
	 * @apiSuccess {Integer} attentionUserTotal 粉丝：已关注主播的人数
	 * @apiSuccess {Integer} diamondGiftZBTotal   收礼：主播累计收礼统计
	 * @apiSuccess {Integer} costTotal	消费
	 *
	 */
	public ZhuboResponseVo getZbDetail(Integer userId,Integer zbId);


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/{zbId}/getAttentionUserList 主播获取关注用户列表
	 * @apiName getAttentionUserList
	 *
	 * @apiDescription
	 * > 点击主播粉丝用户列表，获取用户列表</br>
	 *
	 *
	 * @apiSuccess {Object[]} userList		userList->user
	 * @apiSuccess {Integer} userList.user.userId		用户ID
	 * @apiSuccess {String} userList.user.nickName	用户昵称
	 * @apiSuccess {String} userList.user.sex	用户性别
	 * @apiSuccess {String} userList.user.userHeadImg 用户头像
	 * @apiSuccess {String} userList.user.userLevel 用户等级
	 *
	 */
	public List<UserLevelRankResponseVo> getAttentionUserList(Integer zbId);

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/{zbId}/getGiftUserList/{category} 主播收礼排行用户列表
	 * @apiName getGiftUserList
	 *
	 * @apiDescription
	 * > 点击钻石礼物，弹出礼物排行对话框</br>
	 * > 	category =today，history
	 * > （1）点击当日，获取当日送礼排行</br>
	 * > （2）点击全部，获取历史送礼排行</br>
	 *
	 *
	 * @apiSuccess {Object[]} userList		userList->user
	 * @apiSuccess {Integer} userList.user.userId		用户ID
	 * @apiSuccess {String} userList.user.nickName	用户昵称
	 * @apiSuccess {String} userList.user.sex	用户性别
	 * @apiSuccess {String} userList.user.userHeadImg 	用户头像
	 * @apiSuccess {String} userList.user.userLevel 	用户等级
	 * @apiSuccess {String} userList.user.giftRankNo1	 当前送礼排行
	 * @apiSuccess {String} userList.user.diamondGiftUserTotal 当前用户在当前房间累计送礼总数
	 *
	 */
	public List<UserResponseVo> getGiftUserList(Integer zbId, String category);

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/{zbId}/getReadyPlayInfo 获取开播信息
	 * @apiName getReadyPlayInfo
	 *
	 * @apiDescription
	 * > 进入主播开播界面</br>
	 * > （1）获取IM地址</br>
	 * > （2）获取Madia地址</br>
	 * > （3）获取房间信息</br>
	 *
	 * @apiSuccess {Integer} roomId  房间id
	 * @apiSuccess {String} roomBackgroundImg  房间背景图
	 * @apiSuccess {Object} media
	 * @apiSuccess {Integer} media.type 视频流类型
	 * @apiSuccess {String} media.url   视频流地址
	 * @apiSuccess {Object} im
	 * @apiSuccess {Integer} im.type 即时通讯类型
	 * @apiSuccess {String} im.url   即时通讯地址
	 * @apiSuccess {String} im.port  即时通讯端口
	 *
	 */
	public ReadyPlayResponseVo getReadyPlayInfo(Integer zbId);


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {POST} /zhubo/{zbId}/startPlay 开始直播
	 * @apiName startPlay
	 *
	 * @apiDescription
	 * > 点击开始直播，进入直播界面</br>
	 * > （1）直播房间状态更新</br>
	 * > （2）发送开播推送</br>
	 *
	 * @apiParam (ticket) {Integer} roomId  房间id
	 * @apiParam (ticket) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiParam (ticket) {String{0..10}} roomTitle 房间标题
	 * @apiParam (ticket)  {String} startTime 开始时间（yyyy-MM-dd HH:mm:ss）
	 * @apiParam (ticket)  {String} activityTime   继续时间=[30,60,90,120]
	 * @apiParam (ticket)  {String} price   每分钟单价=[1,2,5,10]
	 *
	 * @apiParam (time) {Integer} roomId  房间id
	 * @apiParam (time) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiParam (time) {String{0..10}} roomTitle 房间标题
	 * @apiParam (time)  {String} startTime 开始时间（yyyy-MM-dd HH:mm:ss）
	 * @apiParam (time)  {String} activityTime   继续时间=[30,60,90,120]
	 * @apiParam (time)  {String} price   门票单价=[20,50,100,120]
	 *
	 * @apiParam (personal) {Integer} roomId  房间id
	 * @apiParam (personal) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiParam (personal) {String{0..10}} roomTitle 房间标题
	 * @apiParam (personal)  {String} startTime 开始时间（yyyy-MM-dd HH:mm:ss）
	 * @apiParam (personal)  {String} activityTime   继续时间=[30,60,90,120]
	 * @apiParam (personal)  {String} userIds		贵宾的用户id=[user001,user002,user003]
	 *
	 * @apiSuccess {String} result  开播成功或失败
	 *
	 */
	public String  startPlay(Integer zbId, StartPlayRequestVo startPlayRequestVo);


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/{zbId}/overPlay 结束直播
	 * @apiName overPlay
	 *
	 * @apiDescription
	 * > 点击是否结束直播，结束直播</br>
	 * > （1）关闭房间</br>
	 * > （2）获取缓存: 砖石数，礼物数等</br>
	 * > （3）做账，收益统计</br>
	 * > （4）清除当前房间缓存</br>
	 * > （5）房间清算完成</br>
	 *
	 * @apiSuccess {String} result  关播成功或失败
	 *
	 */
	public String overPlay(Integer zbId);




}
