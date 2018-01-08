package com.eason.api.zb;

import com.eason.api.zb.exception.ServiceException;
import com.eason.api.zb.vo.room.RoomStatResponseVo;
import com.eason.api.zb.vo.user.UserLevelRankResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;
import com.eason.api.zb.vo.zhubo.ReadyPlayResponseVo;
import com.eason.api.zb.vo.zhubo.StartPlayRequestVo;
import com.eason.api.zb.vo.zhubo.StartPlayResponseVo;
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
	 * @api {GET} /zhubo/apply 主播申请
	 * @apiName apply
	 *
	 * @apiDescription
	 * > 点击用户中心，进行主播申请</br>
	 * > 使用条件，请先登陆</br>
	 * @apiSuccess {String} result 申请成功或者失败
	 *
	 */
	public String apply(Integer userId) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/getZhuboList/{num}  主播推荐列表
	 * @apiName getZhuboList
	 *
	 * @apiDescription
	 * > 点击收藏，没有关注列表，显示热门推荐主播</br>
	 * > 如果没有登陆，显示热门推荐主播</br>
	 *> 如果有登陆，显示已关注的主播</br>
	 * @apiSuccess {Integer} zbId	主播ID
	 * @apiSuccess {String} zbNickname	主播昵称
	 * @apiSuccess {String} zbLevel		主播等级
	 * @apiSuccess {String} zbHeadImg 	主播头像
	 * @apiSuccess {Integer} isAttention 用户是否关注 0 =未关注，1=已关注
	 *
	 */
	public List<ZhuboResponseVo> getZhuboList(Integer userId,Integer num) throws ServiceException;


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/getZbDetail/{zbId} 主播详情
	 * @apiName getZbDetail
	 *
	 * @apiDescription
	 * > 点击主播头像，进入主播迷你卡，获取主播详情</br>
	 *
	 * @apiSuccess {Integer} userId	用户ID
	 * @apiSuccess {String} zbNickname		主播昵称
	 * @apiSuccess {String} signature		用户签名
	 * @apiSuccess {Integer} sex		用户性别
	 * @apiSuccess {String} userHeadImg 	主播头像
	 * @apiSuccess {Integer} zbLevel		主播等级
	 * @apiSuccess {Integer} userLevel		用户等级
	 * @apiSuccess {Integer} vipLevel		用户VIP等级
	 *
	 * @apiSuccess {Integer} isAttention 用户是否关注（0=未关注，1=已关注）
	 * @apiSuccess {Integer} attentionUserTotal 		粉丝
	 * @apiSuccess {Integer} diamondGiftZBTotal   收礼
	 *
	 */
	public ZhuboResponseVo getZbDetail(Integer userId,Integer zbId) throws ServiceException;


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
	 * @apiSuccess {Integer} userList.user.sex	用户性别
	 * @apiSuccess {String} userList.user.userHeadImg 用户头像
	 * @apiSuccess {Integer} userList.user.userLevel 用户等级
	 *
	 */
	public List<UserLevelRankResponseVo> getAttentionUserList(Integer zbId) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/{zbId}/getGiftUserList/{category} 主播收礼排行用户列表
	 * @apiName getGiftUserList
	 *
	 * @apiDescription
	 * > 点击钻石礼物，弹出礼物排行对话框</br>
	 * > 	category =today，history</br>
	 * > （1）点击当日，获取当日送礼排行</br>
	 * > （2）点击全部，获取历史送礼排行</br>
	 *
	 *
	 * @apiSuccess {Object[]} userList		userList->user
	 * @apiSuccess {Integer} userList.user.userId		用户ID
	 * @apiSuccess {String} userList.user.nickName	用户昵称
	 * @apiSuccess {Integer} userList.user.sex	用户性别
	 * @apiSuccess {String} userList.user.userHeadImg 	用户头像
	 * @apiSuccess {Integer} userList.user.userLevel 	用户等级
	 * @apiSuccess {Integer} userList.user.giftRankNo1	 当前送礼排行
	 * @apiSuccess {String} userList.user.diamondGiftUserTotal 当前用户在当前房间累计送礼总数
	 *
	 */
	public List<UserResponseVo> getGiftUserList(Integer zbId, String category) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/getReadyPlayInfo 获取开播信息
	 * @apiName getReadyPlayInfo
	 *
	 * @apiDescription
	 * > 主播API - 获取开播信息</br>
	 * > 进入主播开播界面业务流程</br>
	 * > （1）验证参数：是否合法</br>
	 * > （2）获取IM与Madia地址：</br>
	 * >              A.如果拿不到地址，IM=null或者Media=null接口正常返回，不中断</br>
	 *>              B.如果拿到地址，不存入缓存，下一次直接重新拿</br>
	 * > （3）验证房间状态：</br>
	 * >             A.未开播（=2）继续（3-7）</br>
	 * >              B.直播中（=1）直接进入直播间，返回上一次的房间配置信息</br>
	 * >              //C.回访中（=3）UI弹出对话框是否结束回放？？？如果是结束回放，更新房间状态3（回访中）-2（未开播）重新设置房间，UI重启API，继续（1-7）？？？待确定？？？</br>
	 * > （4）获取主播权限：</br>
	 * >              A.判断主播是否被禁播；UI弹出提示框</br>
	 * >              B.判断是否拥有 时常房间、门票房间、私密房间、游戏房间的开播权限</br>
	 * > （5）获取房间属性：</br>
	 *  >             A.查库—动态配置开播时间、持续时间、门票价格数据等</br>
	 * >              B.配置UI—根据允许的类型从后台拉对应的房间配置数据，动态配置开播时间、持续时间、门票价格UI显示</br>
	 * > （6）维护表：qvod_zb_t_room</br>
	 *  >             A.如果无房间，创建房间，status=0（创建中）初始化房间zbId,status,createTime</br>
	 *  >             B.如果有房间，</br>
	 *  >                    (a)房间未直播，更新房间，status=2（未开播）-0（创建中）</br>
	 *  >                     (b)房间在直播，直接返回，status=1（直播中）</br>
	 * > （7）组建返回值：</br>
	 *  >             A.如果有房间，返回上一次的房间配置信息（roomId,roomTitle,status,roomBackgroundImg），返回开房权限属性配置组装UI（Map）</br>
	 * >              B.如果无房间，返回当前的房间配置信息（roomId,status,roomTitle=null,roomBackgroundImg=null），返回开房权限属性配置组装UI（Map）</br>
	 *
	 * @apiSuccess {Integer} roomId  房间id
	 * @apiSuccess {Integer=0,1,2,3}  roomStatus 房间状态(0=创建，1=直播中，2=未开播，3=回放中)
	 * @apiSuccess {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiSuccess {String} roomTitle  房间标题=直播标题
	 * @apiSuccess {String} roomBackgroundImg  房间背景图
	 * @apiSuccess {String} download_url  下载地址
	 * @apiSuccess {String} result  返回信息
	 * @apiSuccess {Object} media
	 * @apiSuccess {Integer} media.type 视频流类型
	 * @apiSuccess {String} media.url   视频流地址
	 * @apiSuccess {Object} im
	 * @apiSuccess {Integer} im.type 即时通讯类型
	 * @apiSuccess {String} im.url   即时通讯地址
	 * @apiSuccess {Integer} im.port  即时通讯端口
	 *
	 * @apiSuccess (ticket Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiSuccess (ticket Success 200) {Timestamp} startTime 开始时间
	 * @apiSuccess (ticket Success 200) {String} activityTimeList   继续时间=[30,60,90,120]
	 * @apiSuccess (ticket Success 200) {String} priceList   门票单价列表=[20,50,100,120]
	 * @apiSuccess (ticket Success 200) {Integer} selectActivityTime   当前选择持续时间
	 * @apiSuccess (ticket Success 200) {Integer} selectPrice   当前选择门票价格
	 *
	 * @apiSuccess (time Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiSuccess (time Success 200) {Timestamp} startTime 开始时间
	 * @apiSuccess (time Success 200) {String} activityTimeList   继续时间=[30,60,90,120]
	 * @apiSuccess (time Success 200) {String} priceList   每分钟单价列表=[1,2,5,10]
	 * @apiSuccess (time Success 200) {Integer} selectActivityTime   当前选择持续时间
	 * @apiSuccess (time Success 200) {Integer} selectPrice   当前选择时常价格
	 * @apiSuccess (time Success 200) {Integer} timeInterval   收费间隔
	 *
	 * @apiSuccess (personal Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiSuccess (personal Success 200) {Timestamp} startTime 开始时间
	 * @apiSuccess (personal Success 200) {Integer} activityTimeList   继续时间=[30,60,90,120]
	 * @apiSuccess (personal Success 200) {Integer} userId		贵宾的用户id=1
	 * @apiSuccess (personal Success 200) {Integer} selectActivityTime   当前选择持续时间
	 *
	 */
	public ReadyPlayResponseVo getReadyPlayInfo(Integer userId, String token) throws ServiceException;


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {POST} /zhubo/startPlay 开始直播
	 * @apiName startPlay
	 *
	 * @apiDescription
	 *	> 主播API - 开始直播</br>
	 * >  选择房间类型，点击开始直播：</br>
	 * > （1）验证参数：是否合法</br>
	 * > （2）验证房间状态：</br>
	 *  >             A.未开播（=2）重新设置房间</br>
	 *  >             B.直播中（=1）直接进入直播间，更新DB+缓存直播标题 等数据</br>
	 *  >             //C.回访中（=3）UI弹出对话框是否结束回放？？？如果是结束回放，更新房间状态3（回访中）-2（未开播）重新设置房间，UI重启API，继续（1-7）？？？待确定？？？</br>
	 * > （3）维护表：zb_t_room与zb_t_room_plan</br>
	 *  >             A. 先更新房间表，roomTitle，status=1（直播中）</br>
	 *  >             B.查询当前房间场次，确保缓存中没场次（用户没有直播），在进行场次的创建，场次status=房间status</br>
	 *  >             C.创建场次，存储到缓存 房间信息，主播信息（主播昵称、等级、主播头像等），房间属性配置信息，场次信息</br>
	 * >              D.如果是私密房间，更新用户预约表zb_t_user_personal的邀请时间，已经房间预约信息</br>
	 * > （4）开播消息推送：</br>
	 * >              A.关注粉丝用户的消息推送，并且粉丝已开启了主播消息提醒（勾选了的主播才能进行消息推送）</br>
	 * >              B.对接IM的消息推送接口（多用户发送），接口异常处理，不中断</br>
	 * > （5）组件返回值：</br>
	 *  >             A.planId,status,result</br>
	 *
	 * @apiParam (ticket) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiParam (ticket) {String{0..10}} roomTitle 房间标题
	 * @apiParam (ticket)  {Long} startTime 开始时间（时间戳）
	 * @apiParam (ticket)  {Integer} activityTime   继续时间=30,60,90,120  其中选择值
	 * @apiParam (ticket)  {Integer} price   门票单价=20,50,100,120  其中选择值
	 *
	 * @apiParam (time) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiParam (time) {String{0..10}} roomTitle 房间标题
	 * @apiParam (time)  {Long} startTime 开始时间（时间戳）
	 * @apiParam (time)  {Integer} activityTime   继续时间=30,60,90,120  其中选择值
	 * @apiParam (time)  {Integer} price   每分钟单价=1,2,5,10  其中选择值
	 *
	 * @apiParam (personal) {String="normal","ticket","time","personal","game"} roomType 	房间类型
	 * @apiParam (personal) {String{0..10}} roomTitle 房间标题
	 * @apiParam (personal)  {Long} startTime 开始时间（时间戳）
	 * @apiParam (personal)  {Integer} activityTime   继续时间=30,60,90,120  其中选择值
	 * @apiParam (personal)  {Integer} userId		贵宾的用户id=1
	 *
	 * @apiSuccess {Integer} planId  场次Id
	 * @apiSuccess {Integer} roomStatus 0=创建，1=直播中，2=未开播，3=回放中
	 * @apiSuccess {String} result  开播成功或失败
	 *
	 *
	 */
	public StartPlayResponseVo startPlay(Integer userId, StartPlayRequestVo startPlayRequestVo) throws ServiceException;


	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/overPlay/{planId} 结束直播
	 * @apiName overPlay
	 *
	 * @apiDescription
	 * > 点击确认退出，结束直播</br>
	 * > （1）记录直播视频状态is_video=0</br>
	 *> （2）调Medie接口删除视频</br>
	 * @apiSuccess {String} result  退出成功或者失败
	 *
	 */
	public String overPlay(Integer userId,Integer planId) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/saveVideo/{planId} 保存回放
	 * @apiName saveVideo
	 *
	 * @apiDescription
	 * > 点击是否保存回放，结束直播</br>
	 * > （1）记录直播视频状态is_video=1，保持回放</br>
	 *
	 * @apiSuccess {String} result  退出成功或者失败
	 *
	 */
	public String saveVideo(Integer userId,Integer planId) throws ServiceException;

	/**
	 * @apiVersion 1.0.0
	 * @apiGroup zhubo
	 * @apiPermission Android/IOS
	 * @api {GET} /zhubo/getStat/{planId} 获取直播收益
	 * @apiName getStat
	 * @apiDescription
	 * > 房间API - 获取直播收益</br>
	 * > 主播主动结束退出直播，获取当前直播的收益数据</br>
	 * @apiSuccess {String} result 	退房成功或者失败
	 * @apiSuccess {Integer} statId  记录统计ID
	 * @apiSuccess {Integer} planId  本场次ID
	 * @apiSuccess {Long} activityTime  直播时长
	 * @apiSuccess {Integer} onlineUser  房间当前在线用户
	 * @apiSuccess {Integer} machineUser 房间机器人用户
	 * @apiSuccess {Integer} incomeAmount  累计收益
	 * @apiSuccess {Integer} attentionCount  累计粉丝
	 * @apiSuccess {Integer} viewCount  累计观看次数
	 * @apiSuccess {Integer} giftCount  累计收礼数
	 * @apiSuccess {Integer} bombScreenCount  累计飞屏数
	 */
	public RoomStatResponseVo getStat(Integer userId, Integer planId) throws  ServiceException;


}
