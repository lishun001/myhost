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
     * > ture是开始试看，就等同于你点击开始试看的按钮，返给你isTrysee=0代表能够试看，1代表不能试看 </br>
     * > false是结束试看，就等同于你点击结束试看的按钮，表示你试看时间已经全部看完了 </br>
     * > 并不是你点击试看，就代表试看结束的；你需要调用结束试看的这个动作，服务器才知道已经试看结束了 </br>
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
     * > channel= (1=房间、2=个人中心、3=私信、4=收藏推荐)</br>
     * >支持一键关注格式：userIds=1,2,3 用英文逗号,隔开 </br>
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
     * > true代表 需要预约，zbId是主播id
     * > false代表 取消预约，zbId是主播id
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
     * > ture 代表 拉黑用户，userIds是用户id
     * > false 代表 取消拉黑，userIds是用户id
     * >channel= (1=房间、2=个人中心、3=私信、4=收藏推荐)</br>
     * >支持一键关注格式：userIds=1,2,3 用英文逗号,隔开
     * @apiSuccess {String} result	四种情况：拉黑成功，已经拉黑，取消成功，并未拉黑
     */
    public String isBlack(Integer userId, Integer channel,String userIds, Boolean isBlack) throws ServiceException;

    /**
     * @apiVersion 1.0.0
     * @apiGroup user
     * @apiPermission Android/IOS
     * @api {GET} /user/getDetail/{userId} 用户详情
     * @apiName getDetail
     * @apiDescription > 用户迷你卡~用户详情</br>
     *
     * @apiSuccess {Integer} userId	用户ID
     * @apiSuccess {String} nickName		用户昵称
     * @apiSuccess {String} signature		用户签名
     * @apiSuccess {Integer} sex		用户性别
     * @apiSuccess {String} userHeadImg 	主播头像
     * @apiSuccess {Integer} userLevel		用户等级
     * @apiSuccess {Integer} vipLevel		用户VIP等级
     *
     * @apiSuccess {Integer} isAttention 用户是否关注（0=未关注，1=已关注）
     * @apiSuccess {Integer} attentionUserTotal 		粉丝
     * @apiSuccess {Integer} diamondGiftZBTotal   收礼
     */
    public UserResponseVo getDetail(Integer tokenUserId,Integer userId) throws ServiceException;


}
