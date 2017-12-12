package com.eason.api.zb.service;

import com.eason.api.zb.model.FileItem;
import com.eason.api.zb.vo.room.IsChargedResponseVo;
import com.eason.api.zb.vo.room.RoomResponseVo;
import com.eason.api.zb.vo.room.RoomSetResponseVo;

import java.io.File;

/**
 * @apiDefine room 房间API
 */
public interface IRoomService {

    /**
     * @apiVersion 1.0.0
     * @apiGroup room
     * @apiPermission Android/IOS
     * @api {GET} /room/{roomId}/enterRoom/{userId} 进入房间
     * @apiName enterRoom
     * @apiDescription > 用户与主播，进入房间，获取房间详情明细，包含如下几个动作：</br>
     * > （1）获取房间详情</br>
     * > （2）获取主播详情</br>
     * > （3）获取用户详情</br>
     * > （4）获取粉丝用户列表</br>
     * > （5）获取IM/Video服务器地址</br>
     * @apiSuccess {Integer} roomId 		房间ID
     * @apiSuccess {String} roomTitle  	房间标题
     * @apiSuccess {String} roomType   	房间类型：'normal=普通房间','ticket=门票房间','time=时常房间','personal=私密房间','game=游戏房间'
     * @apiSuccess {Integer} onlineUser  房间当前在线用户
     * @apiSuccess {Integer} machineUser 房间用户
     * @apiSuccess {Integer} diamondGiftNum	 房间钻石礼物总数
     * @apiSuccess {Integer} roomNo1   	房间排名
     * @apiSuccess {String} roomBackgroundImg  房间背景图片
     * @apiSuccess {Integer} zbId 		主播ID
     * @apiSuccess {String} zbNickname	主播昵称
     * @apiSuccess {String} zbLevel		主播等级
     * @apiSuccess {String} zbHeadImg 	主播头像
     * @apiSuccess {String} zbSignature 主播个性签名
     * @apiSuccess {Integer} isAttention 用户是否关注
     * @apiSuccess {String}  userLevel 用户等级息
     * @apiSuccess {Double} diamondBalance  用户钻石余额
     * @apiSuccess {Object[]} diamondRankList		diamondRankList->user（送礼钻石排行）
     * @apiSuccess {Integer} diamondRankList.user.userId		用户ID
     * @apiSuccess {String} diamondRankList.user.nickName	用户昵称
     * @apiSuccess {String} diamondRankList.user.sex	用户性别
     * @apiSuccess {String} diamondRankList.user.userHeadImg 用户头像
     * @apiSuccess {String} diamondRankList.user.userLevel 用户等级
     * @apiSuccess {Integer} diamondRankList.user.giftRankNo1	 当前送礼排行
     * @apiSuccess {Integer} diamondRankList.user.diamondGiftUserTotal 当前用户在当前房间累计送礼总数
     * @apiSuccess {Object[]} userLevelRankList		userLevelRankList->user（用户等级排行）
     * @apiSuccess {Integer} userLevelRankList.user.userId		用户ID
     * @apiSuccess {String} userLevelRankList.user.nickName	用户昵称
     * @apiSuccess {String} userLevelRankList.user.sex	用户性别
     * @apiSuccess {String} userLevelRankList.user.userHeadImg 用户头像
     * @apiSuccess {String} userLevelRankList.user.userLevel 用户等级
     * @apiSuccess {Object} media
     * @apiSuccess {Integer} media.type 视频流类型
     * @apiSuccess {String} media.url   视频流地址
     * @apiSuccess {Object} im
     * @apiSuccess {Integer} im.type 即时通讯类型
     * @apiSuccess {String} im.url   即时通讯地址
     * @apiSuccess {String} im.port  即时通讯端口
     */
    public RoomResponseVo enterRoom(Integer userId, Integer roomId);

    /**
     * @apiVersion 1.0.0
     * @apiGroup room
     * @apiPermission Android/IOS
     * @api {GET} /room/{roomId}/backRoom/{userId} 退出房间
     * @apiName backRoom
     * @apiDescription > 主播结束直播，推送通知用户退出房间，当用户断线无法收到推送，如何判断？</br>
     * > （1）获取当前用户缓存: 开始时间，消费次数等</br>
     * > （2）记录观看时长，缓存数据统计到数据库。做账，消费统计</br>
     * > （3）清除当前用户缓存，退出成功</br>
     * @apiSuccess {String} result 	退房成功或者失败
     */
    public String backRoom(Integer userId, Integer roomId);


    /**
     * @apiVersion 1.0.0
     * @apiGroup room
     * @apiPermission Android/IOS
     * @api {GET} /room/{roomId}/isCharged/{userId} 房间是否收费
     * @apiName isCharged
     * @apiDescription > 判断房间是否收费，获取收费条件等信息</br>
     * > （1）房间收费类型roomType=ticket，time，personal</br>
     *
     * @apiSuccess (ticket Success 200) {Integer} roomId 		房间ID
     * @apiSuccess (ticket Success 200) {Integer} zbId 		主播ID
     * @apiSuccess (ticket Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
     * @apiSuccess (ticket Success 200) {Integer} ticketStatus 0=未购买，1=购买，2=使用中，3=已使用，4=已作废
     * @apiSuccess (ticket Success 200) {Double} price   门票单价
     *
     * @apiSuccess (time Success 200) {Integer} roomId 		房间ID
     * @apiSuccess (time Success 200) {Integer} zbId 		主播ID
     * @apiSuccess (time Success 200) {String="normal","ticket","time","personal","game"} roomType 		房间类型
     * @apiSuccess (time Success 200) {Integer} price 时长单价
     * @apiSuccess (time Success 200) {String} unit   时长单位
     *
     * @apiSuccess (personal Success 200) {Integer} roomId 		房间ID
     * @apiSuccess (personal Success 200) {Integer} zbId 		主播ID
     * @apiSuccess (personal Success 200) {String="normal","ticket","time","personal","game"} roomType 		房间类型
     * @apiSuccess (personal Success 200)  {Integer} personalStatus 0=未预约，1=已预约
     */
    public IsChargedResponseVo isCharged(Integer userId, Integer roomId);


    /**
     * @apiVersion 1.0.0
     * @apiGroup room
     * @apiPermission Android/IOS
     * @api {GET} /room/{roomType}/getRoomSet 获取房间属性设置
     * @apiName getRoomSet
     * @apiDescription > 进入主播开播界面，动态展示开播前的房间设置参数</br>
     * > （1）房间有参数的类型roomType=ticket，time，personal</br>
     * @apiSuccess (ticket Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
     * @apiSuccess (ticket Success 200) {Timestamp} startTime 开始时间
     * @apiSuccess (ticket Success 200) {String} activityTime   继续时间=[30,60,90,120]
     * @apiSuccess (ticket Success 200) {String} price   每分钟单价=[1,2,5,10]
     *
     * @apiSuccess (time Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
     * @apiSuccess (time Success 200) {Timestamp} startTime 开始时间
     * @apiSuccess (time Success 200) {String} activityTime   继续时间=[30,60,90,120]
     * @apiSuccess (time Success 200) {String} price   门票单价=[20,50,100,120]
     *
     * @apiSuccess (personal Success 200) {String="normal","ticket","time","personal","game"} roomType 	房间类型
     * @apiSuccess (personal Success 200) {Timestamp} startTime 开始时间
     * @apiSuccess (personal Success 200) {String} activityTime   继续时间=[30,60,90,120]
     * @apiSuccess (personal Success 200) {String} userIds		贵宾的用户id=[user001,user002,user003]
     */
    public RoomSetResponseVo getRoomSet(String roomType);


    /**
     * @apiVersion 1.0.0
     * @apiGroup room
     * @apiPermission Android/IOS
     * @api {POST} /room/{roomId}/setRoomBackgroundImg 设置房间直播封面
     * @apiName setRoomBackgroundImg
     * @apiDescription > 进入主播开播界面，设置直播房间封面</br>
     * @apiParam {byte[]} roomBackgroundImg  房间背景图
     * @apiSuccess {String} imgUrl 	上传地址
     */
    public String setRoomBackgroundImg(Integer roomId, FileItem fileImg);
}
