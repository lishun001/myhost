package com.eason.api.zb.service;

import com.eason.api.zb.vo.user.TrySeeResponseVo;
import com.eason.api.zb.vo.user.UserResponseVo;

/**
 * @apiDefine user 用户API
 */
public interface IUserService {

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/{userId}/isTrySee/{roomId}/{isTrySee} 开始/结束试看
     * @apiName isTrySee
     * @apiDescription
     * > 判断当前VIP用户是否能试看，如果可以开始试看</br>
     * > isTrySee=true,false</br>
     *
     * @apiSuccess {Integer} userId	用户ID
     * @apiSuccess {Boolean} isTrySee false=未试看，true=已试看
     * @apiSuccess {String} userLevel   用户等级
     * @apiSuccess {String} allowTime  允许试看时间
     * @apiSuccess {Timestamp} overTime  试看结束时间
     */
    public TrySeeResponseVo isTrySee(Integer userId, Integer roomId, Boolean isTrySee);

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/{userId}/isAttention/{zbId}/{isAttention} 关注/取消关注
     * @apiName isAttention
     * @apiDescription > 用户关注主播，关注与未关注来回切换</br>
     * > isAttention=true,false </br>
     * @apiSuccess {String} result	关注成功或者失败消息
     */
    public String isAttention(Integer userId, Integer zbId, Boolean isAttention);

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/{userId}/isBook/{zbId}/{isBook} 预约/取消预约
     * @apiName isBook
     * @apiDescription > 用户关注主播，关注与未关注来回切换</br>
     * > isBook=true,false </br>
     * @apiSuccess {String} result	关注成功或者失败消息
     */
    public String isBook(Integer userId, Integer zbId, Boolean isBook);

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/{userId}/getDetail 用户详情
     * @apiName getDetail
     * @apiDescription > 用户关注主播，关注与未关注来回切换</br>
     * @apiSuccess {Integer} userId		用户ID
     * @apiSuccess {String} nickName	用户昵称
     * @apiSuccess {String} sex	用户性别
     * @apiSuccess {String} userHeadImg 用户头像
     * @apiSuccess {String} userLevel 用户等级
     * @apiSuccess {Double} diamondBalance 用户钻石余额
     * @apiSuccess {String} diamondGiftUserTotal 当前用户在当前房间累计送礼总数
     * @apiSuccess {String} [giftRankNo1]	 当前送礼排行
     */
    public UserResponseVo getDetail(Integer userId);


}
