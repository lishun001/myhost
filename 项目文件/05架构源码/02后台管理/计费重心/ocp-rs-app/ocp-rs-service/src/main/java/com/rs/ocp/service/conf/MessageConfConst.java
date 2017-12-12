/*
 * To change this template; choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.conf;

/**
 *
 * @author zhaoweixing
 */
public class MessageConfConst {

    /*消息心跳*/
    public final static int HEARTBEAT_VALUE = 300;
    public final static int MSG_QUEUE_LENGTH = 90000;
    public final static int MSG_HEAD_LENGTH = 32;
    /*
     * Para Type
     */
    public final static byte TYPE_BYTE = 0;
    public final static byte TYPE_WORD = 1;
    public final static byte TYPE_INT = 2;
    public final static byte TYPE_FLOAT = 3;
    public final static byte TYPE_STRING = 4;
    public final static byte TYPE_WIDESTR = 5;
    public final static byte TYPE_OBJECT = 6;
    public final static byte TYPE_DOUBLE = 7;
    public final static byte TYPE_BINARY = 8;
    /*
     * Para Length
     */
    public final static int TYPE_BYTE_LENGTH = 1;
    public final static int TYPE_WORD_LENGTH = 2;
    public final static int TYPE_INT_LENGTH = 4;
    public final static int TYPE_FLOAT_LENGTH = 4;
    public final static int TYPE_DOUBLE_LENGTH = 8;
    public final static int TYPE_BINARY_LENGTH = 8;
    /* 字符串结束符*/
    public final static byte[] TYPE_STRING_END = new byte[]{0};
    public final static byte[] TYPE_WIDESTR_END = new byte[]{0, 0};
    /*Message Code*/
    public final static int MSG_CODE_FORW_REG = 0x1000;          // 注册服务器(游戏服务器发)
    public final static int MSG_CODE_BACK_REG = 0x1001;              // 注册服务器返回(计费返回)
    public final static int MSG_CODE_FORW_UNREG = 0x1002;        // 注销服务器(游戏服务器发)
    public final static int MSG_CODE_BACK_UNREG = 0x1003;            // 注销服务器(计费返回)
    public final static int MSG_CODE_FORW_RESET = 0x1004;        // 重置当前服务器状态(游戏服务器发)	
    public final static int MSG_CODE_FORW_LOGIN = 0x2000;        // 登陆(游戏服务器发)
    public final static int MSG_CODE_BACK_LOGIN = 0x2001;            // 登陆结果(计费返回)
    public final static int MSG_CODE_FORW_LOGOUT = 0x2002;       // 登出(游戏服务器发)
    public final static int MSG_CODE_BACK_LOGOUT = 0x2003;           // 登出(计费返回)
    public final static int MSG_CODE_FORW_RENEW = 0x2004;        // 更新帐户(游戏服务器发)
    public final static int MSG_CODE_BACK_RENEW = 0x2005;            // 更新帐户(计费返回)
    public final static int MSG_CODE_FORW_RET_POINTS = 0x201C;   // 返回中心点数(游戏服务器发)
    public final static int MSG_CODE_BACK_RET_POINTS = 0x201D;       // 返回中心点数(计费返回)
    public final static int MSG_CODE_FORW_KEEP = 0xFFFF;         // 保持连接（每隔30秒段发一次）
    public final static int MSG_CODE_FORW_VALIDATE_PPPASSPORT = 0x3000;         // 验证帐号（不登陆）(游戏服务器发)
    public final static int MSG_CODE_BACK_VALIDATE_PPPASSPORT = 0x3001;         //  验证帐号(计费返回)
    public final static int MSG_CODE_FORW_TWO_LEVEL_PWD = 0x3002;         // 验证游戏二级密码(游戏服务器发)
    public final static int MSG_CODE_BACK_TWO_LEVEL_PWD = 0x3003;         //  验证游戏二级密码(计费返回)   
    //以下消息，后期再整理
    public final static int MSG_CODE_FORW_QUE_GIFT = 0x2008;			// 查询赠品
    public final static int MSG_CODE_BACK_QUE_GIFT = 0x2009;
    public final static int MSG_CODE_FORW_GET_GIFT = 0x200A;			// 获得赠品
    public final static int MSG_CODE_BACK_GET_GIFT = 0x200B;
    public final static int MSG_CODE_FORW_SELL_CARD = 0x2010;		// 出售点卡
    public final static int MSG_CODE_BACK_SELL_CARD = 0x2011;
    public final static int MSG_CODE_FORW_UNSELL_CARD = 0x2012;		// 撤消出售点卡
    public final static int MSG_CODE_BACK_UNSELL_CARD = 0x2013;
    public final static int MSG_CODE_FORW_BUY_CARD = 0x2014;			// 购买点卡
    public final static int MSG_CODE_BACK_BUY_CARD = 0x2015;
    public final static int MSG_CODE_FORW_BUY_ITEM = 0x2016;			// 购买物品
    public final static int MSG_CODE_BACK_BUY_ITEM = 0x2017;
    public final static int MSG_CODE_FORW_ITEM_INFO = 0x2018;		// 获取物品价格信息
    public final static int MSG_CODE_BACK_ITEM_INFO = 0x2019;
    public final static int MSG_CODE_FORW_BUY_ITEM_RET = 0x201A;		// 购买物品并返回剩余点数
    public final static int MSG_CODE_BACK_BUY_ITEM_RET = 0x201B;
    public final static int MSG_CODE_FORW_TOGM = 0x4000;				// GMCC的消息
    public final static int MSG_CODE_FORW_FROMGM = 0x4002;
    public final static int MSG_CODE_FORW_CUSTOM = 0x6000;			// 自定义消息
    public final static int MSG_CODE_BACK_CUSTOM = 0x6001;
}
