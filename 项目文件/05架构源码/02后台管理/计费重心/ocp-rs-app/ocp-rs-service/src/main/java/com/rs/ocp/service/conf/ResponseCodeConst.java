/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.conf;

/**
 *
 * @author zhaoweixing
 */
public class ResponseCodeConst {

    // 错误码信息格式 [5位整型数]
    // 第1位是子系统代码
    // 第2位是子模块代码
    // 第3位是类型(0-存储过程、1-程序错误、2-网络通信)
    // 后两位为顺序号编码
    // 1000为不可预知的错误
    public final static int OUTER_RESULT_SUCCEED = 1;
    public final static int OUTER_RESULT_FAILED = 0;
    // 1000为不可预知的错误
    public final static int OUTER_ERR_UNEXPECT = 1000;                          // 非预期错误
    // 计费应用相关错误码描述[5xxxx]
    // 服务器注册、注销 50xxx
    public final static int CAS_ERR_SERVER_ID = 50001;// 游戏服务器ID不可识别
    public final static int CAS_ERR_SERVER_FORBID = 50002;// 游戏服务器状态为已禁用
    public final static int CAS_ERR_SERVER_IP = 50003;// 游戏服务器注册IP不正确
    public final static int CAS_ERR_GAME_ID = 50004;// 游戏类型ID不正确
    // 玩家帐号登录、扣点、退出 51xxx
    public final static int CAS_ERR_NO_PASSPORT = 51001;// 帐号不存在
    public final static int CAS_ERR_PASSPORT_PSWD = 51002;// 帐号或密码错误
    public final static int CAS_ERR_PASSPORT_BLOCK = 51003;// 此帐号已被冻结
    public final static int CAS_ERR_PASSPORT_ONLY = 51004;// 实名帐号只能登录绿色服
    public final static int CAS_ERR_PASSPORT_DENIED = 51005;// 普通帐号不能登录绿色服
    public final static int CAS_ERR_ILLEGAL_GM = 51006;// 非法GM帐号登录
    public final static int CAS_ERR_UNACTIVE = 51007;// 此分区帐户尚未激活(代替51014账户不存在)
    public final static int CAS_ERR_EXPIRED = 51008;// 分区游戏帐户余额不足
    public final static int CAS_ERR_SAVE_LOG = 51009;// 创建登录日志失败
    public final static int CAS_ERR_GET_ITEM = 51010;// 获取物品失败，物品不存在或是之前已取完
    public final static int CAS_ERR_PASSPORT_LOGGED = 51011;// 此帐号已在分区内其他服务器登录
    public final static int CAS_ERR_PASSPORT_LOCKED = 51012;// 帐号为锁定状态，请通过手机解锁后再试（玩家主动申请冻结）
    public final static int CAS_ERR_PASSPORT_FORBID = 51013;// 您的帐号不可以登录此游戏服务器(帐号与运营商不匹配),请到会员中心查看自己能登录哪些游戏服务器.（封号）
    public final static int CAS_ERR_NO_ACCOUNT = 51014;// 账户不存在
    // 点卡寄售、购买、道具购买 52xxx
    public final static int CAS_ERR_CARD_PASSPORT = 52000;// 未知帐号请求
    public final static int CAS_ERR_CARD_PSWD = 52001;// 卡号或密码不正确
    public final static int CAS_ERR_CARD_INVALID = 52002;// 无效点卡，已被使用
    public final static int CAS_ERR_CARD_BLOCK = 52003;// 点卡目前已在寄售中
    public final static int CAS_ERR_CARD_DISCARD = 52004;// 无效点卡，已被作废
    public final static int CAS_ERR_NO_POINTS = 52005;// 中心帐户余额不足
    public final static int CAS_ERR_CARD_FILL = 52006;// 购买点卡充值时出错
    public final static int CAS_ERR_CARD_TYPE = 52007;// 卡类型不可识别，不允许寄售
    public final static int CAS_ERR_CARD_SELLED = 52008;// 请求失败,点卡之前已经售出
    public final static int CAS_ERR_CARD_CANCEL = 52009;// 请求失败,点卡可能已撤消寄售
    public final static int CAS_ERR_CARD_SELL_CANCEL = 52010;// 点卡可能之前已售出或已撤消
    public final static int CAS_ERR_CARD_CANT_CANCEL = 52011;// 点卡寄售两小时内不可撤消
    public final static int CAS_ERR_ITEM_NOT_FOUND = 52012;// 虚拟道具编码不存在
    public final static int CAS_ERR_ITEM_AMOUNT_PRICE = 52013;// 购买数量或单价有误
    public final static int CAS_ERR_ITEM_PRICE_CHANGE = 52014;// 物品点数单价发生变化,请刷新
}
