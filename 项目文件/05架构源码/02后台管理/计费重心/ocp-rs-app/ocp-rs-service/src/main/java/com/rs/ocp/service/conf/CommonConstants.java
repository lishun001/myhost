/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.conf;

/**
 *
 * @author wangxinming
 */
public class CommonConstants {
    /**
     * 计费服务端口
     */
    public static int OCP_PORT=8000;
    /*
     * logback配置, 数据源配置 
     */
    public  final static String CONFIG_DATABASES = "/data/ocp/ocp_conf.properties";
    public  final static String CONFIG_LOGBACK = "/data/ocp/logback.xml";
//    public final static String CONFIG_DATABASES = "E:/ocp_conf.properties";
//    public final static String CONFIG_LOGBACK = "E:/logback.xml";
    /**
     * 每分钟扣除的点数
     */
    public final static byte MINUTE_DEDUCT_QOINT = 1;
    /**
     * 提醒快用完点数
     */
    public final static int REMIND_RUN_OUT_QOINT_NUM_300 = 30;
    public final static int REMIND_RUN_OUT_QOINT_NUM_180 = 20;
    public final static int REMIND_RUN_OUT_QOINT_NUM_60 = 10;
    public final static int REMIND_RUN_OUT_QOINT_NUM_5 = 5;
    public final static int REMIND_RUN_OUT_QOINT_NUM_3 = 3;
    public final static int REMIND_RUN_OUT_QOINT_NUM_2 = 2;
    public final static int REMIND_RUN_OUT_QOINT_NUM_1 = 1;
    /**
     * 点数即将用完
     */
    public final static int POINT_WILL_RUN_OUT = 1;
    /**
     * 点数不够
     */
    public final static int POINT_NOT_ENOUGH = 2;
    /**
     * 防沉迷玩家
     */
    public final static int IS_FCM = 3;
    /**
     * 试玩玩家
     */
    public final static int IS_TRY_PLAY = 4;
    /**
     * 正常扣费
     */
    public final static int NORMAL = 5;
    /**
     * 扣费失败
     */
    public final static int DEDUCT_QPINT_FAIL = -1;
    /**
     * 密保卡使用状态
     */
    public final static int MBCARD_USE_SRARUS = 1;
    /**
     * 防沉迷累计下线时间清0时间点
     */
    public static int FCM_OFF_LINETIME_SET_UP_ZERO_NUM = 18000;
    //public final static int FCM_OFF_LINETIME_SET_UP_ZERO_NUM = 1800;
    /**
     * 消息处理超时毫秒数
     */
    public final static long MSG_HANDLER_TIME_OUT_MILLISECOND = 55000;
    /**
     * 消息处理超时最近一次发送邮件预警时间，没有发送默认为0
     */
    private static long EARLY_WARNING_TIME = 0;
    /**
     * GM字段标示
     */
    public final static String GM_MARK = "0";
    /**
     * 消息处理超时发送邮件预警间隔毫秒数
     */
    public final static long EARLY_WARNING_TIME_MILLISECOND = 300000;
    public final static int FOREVER_NOT_GAMEID = -965341;
    /**
     * * 封号标示
     */
    public final static int CLOSED_STATE = 1;
    /**
     * * 官方冻结标示
     */
    public final static int OFFICIAL_FROZEN = 2;
    /**
     * * 玩家申请冻结标示
     */
    public final static int APPLY_FROZEN = 3;
    public final static String VERTICAL = "\\|";
    /**
     * 逗号分割符
     */
    public final static String COMMA_DECOLLATOR = ",";

    /**
     * @return the EARLY_WARNING_TIME
     */
    public static long getEARLY_WARNING_TIME() {
        return EARLY_WARNING_TIME;
    }

    /**
     * @param aEARLY_WARNING_TIME the EARLY_WARNING_TIME to set
     */
    public static void setEARLY_WARNING_TIME(long aEARLY_WARNING_TIME) {
        EARLY_WARNING_TIME = aEARLY_WARNING_TIME;
    }
}
