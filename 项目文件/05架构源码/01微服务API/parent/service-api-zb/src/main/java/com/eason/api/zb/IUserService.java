package com.eason.api.zb;

import com.eason.api.zb.exception.ServiceException;
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
     * @api {GET} /user/isTrySee/{roomId}/{isTrySee} 开始/结束试看
     * @apiName isTrySee
     * @apiDescription
     * > 判断当前VIP用户是否能试看，如果可以开始试看</br>
     * > isTrySee=true,false</br>
     *
     * @apiSuccess {Integer} userId	用户ID
     * @apiSuccess {Integer} isTrySee 0=未试看，1=已试看
     * @apiSuccess {Integer} userLevel   用户等级
     * @apiSuccess {String} allowTime  允许试看时间
     * @apiSuccess {Timestamp} overTime  试看结束时间
     */
    public TrySeeResponseVo isTrySee(Integer userId, Integer roomId, Boolean isTrySee) throws ServiceException;

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/{channel}/isAttention/{userIds}/{isAttention} 关注/取消关注
     * @apiName isAttention
     * @apiDescription > 用户关注主播，或者用户关注用户，关注与未关注来回切换</br>
     * > isAttention=true,false </br>
     * >channel= (1=房间、2=个人中心、3=私信、4=收藏推荐)</br>
     * >支持一键关注格式：userIds=1,2,3 用英文逗号,隔开
     * @apiSuccess {String} result	关注成功或者失败消息
     */
    public String isAttention(Integer userId, Integer channel,String userIds, Boolean isAttention) throws ServiceException;

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/isBook/{zbId}/{isBook} 预约/取消预约
     * @apiName isBook
     * @apiDescription > 用户提前预约主播，进行私密userId传递，主播可以根据userId进行私密直播</br>
     * > isBook=true,false </br>
     * @apiSuccess {String} result	四种情况：预约成功，已经预约，取消成功，并未预约
     */
    public String isBook(Integer userId, Integer zbId, Boolean isBook) throws ServiceException;

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/{channel}/isBlack/{userIds}/{isBlack} 拉黑/取消拉黑
     * @apiName isBlack
     * @apiDescription > 用户拉黑主播，或者用户拉黑用户，拉黑与未拉黑来回切换</br>
     * > isBlack=true,false </br>
     * >channel= (1=房间、2=个人中心、3=私信、4=收藏推荐)</br>
     * >支持一键关注格式：userIds=1,2,3 用英文逗号,隔开
     * @apiSuccess {String} result	四种情况：拉黑成功，已经拉黑，取消成功，并未拉黑
     */
    public String isBlack(Integer userId, Integer channel,String userIds, Boolean isBlack) throws ServiceException;

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/getDetail 用户详情
     * @apiName getDetail
     * @apiDescription > 用户详情</br>
     * @apiSuccess {Integer} userId		用户ID
     * @apiSuccess {String} nickName	用户昵称
     * @apiSuccess {Integer} sex	用户性别
     * @apiSuccess {String} userHeadImg 用户头像
     * @apiSuccess {String} userLevel 用户等级
     * @apiSuccess {Double} diamondBalance 用户钻石余额
     * @apiSuccess {String} diamondGiftUserTotal 当前用户在当前房间累计送礼总数
     * @apiSuccess {String} [giftRankNo1]	 当前送礼排行
     */
    public UserResponseVo getDetail(Integer userId) throws ServiceException;


}
