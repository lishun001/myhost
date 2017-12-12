/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.domain.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zhaoweixing
 */
public class DomainConfConst {
    /*
     服务器状态1:正常, 2:禁用, 3:冻结, 4:维护中，5：服务器合并，9：删除 
     */
    
    public final static int SERVER_STATUS_NORMAL = 1;
    public final static int SERVER_STATUS_FORBID = 2;
    public final static int SERVER_STATUS_BLOCKED = 3;
    public final static int SERVER_STATUS_MAINTENANCE = 4;
    public final static int SERVER_STATUS_MERGE = 5;
    public final static int SERVER_STATUS_DELETE = 9;
    /*
     * 账号状态1:正常, 2:锁定(玩家自己锁定), 3:冻结(官方暂时冻结), 4停封(官方永久停封), 9:删除
     */
    public final static String PASSPORT_STATUS_NORMAL = "1";
    public final static String PASSPORT_STATUS_LOCKED = "2";
    public final static String PASSPORT_STATUS_FROZEN = "3";
    public final static String PASSPORT_STATUS_FROZEN_FOREVER = "4";
    public final static String PASSPORT_STATUS_DELETE = "9";
    /*
     * 账户状态1:正常, 2:锁定(玩家自己锁定), 3:冻结(官方暂时冻结), 4停封(官方永久停封), 9:删除
     */
    public final static int ACCOUNT_STATUS_NORMAL = 1;
    public final static int ACCOUNT_STATUS_LOCKED = 2;
    public final static int ACCOUNT_STATUS_FROZEN = 3;
    public final static int ACCOUNT_STATUS_FROZEN_FOREVER = 4;
    public final static int ACCOUNT_STATUS_DELETE = 9;
    /*
     * 是否为防沉迷用户
     */
    public final static String IS_NOT_FCM_PASSPORT = "1";
    public final static String IS_FCM_PASSPORT = "2";
    /**
     * 结束防沉迷状态标示
     */
    public final static String END_FCM_PASSPORT = "3";
    /*
     /*
     * 是否人民币玩家account_isrmb
     */
    public final static int IS_ACCOUNT_RMB = 1;
    public final static int IS_NOT_ACCOUNT_RMB = 2;
    /**
     * 终止非RMB玩家标示
     */
    public final static int END_NOT_ACCOUNT_RMB = 3;
    /*
     * 登陆类型
     */
    public final static int TYPE_OF_LOGIN = 1;
    public final static int TYPE_OF_LOGOUT = 2;
    /**
     * gameServer为注册状态标示
     */
    public final static int GAME_SERVER_REGISTER = 1;
    /**
     * gameServer为注销状态标示
     */
    public final static int GAME_SERVER_UN_REGISTER = 0;
    /**
     * gameServer为异常注销状态标示
     */
    public final static int GAME_SERVER_ERROR_UN_REGISTER = 2;
    /**
     * 终止试玩、防沉迷状态标示
     */
    public final static int END_STATE = -1;
    /*
     * 密保卡行数, 列数
     */
    public final static int MIBAO_ROW_NUMS = 8;
    public final static int MIBAO_COL_NUMS = 9;
    public static Map<String, String> MiBaoColsMap = new HashMap<String, String>();
    
    public static void init() {
        for (int i = 0; i < DomainConfConst.MIBAO_ROW_NUMS; i++) {
            for (int j = 0; j < DomainConfConst.MIBAO_COL_NUMS; j++) {
//                System.out.print((char) (65 + i) + "" + (j + 1));
//                System.out.println(i + "," + j);
                MiBaoColsMap.put((char) (65 + i) + "" + (j + 1), i + "," + j);
            }
        }
    }
    
    public static int[] getIndex(String key) {
        int[] index = new int[2];
        String[] result = MiBaoColsMap.get(key).split(",");
        index[0]=Integer.parseInt(result[0]);
        index[1]=Integer.parseInt(result[1]);
        return index;
    }
    
    static {
        init();
    }
}
