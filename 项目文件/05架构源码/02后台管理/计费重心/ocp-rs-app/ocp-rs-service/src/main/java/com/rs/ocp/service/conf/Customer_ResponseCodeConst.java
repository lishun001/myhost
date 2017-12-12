/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.conf;

/**
 *
 * @author zhaoweixing
 */
public class Customer_ResponseCodeConst {
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*自定义关于游戏服务器类型错误*/

    public final static int CAS_ERR_SERVER_MAINTENANCE = 50005;// 游戏服务器状态为维护中
    public final static int CAS_ERR_SERVER_MERGE = 50006;// 游戏服务器状态为合服
    public final static int CAS_ERR_SERVER_BLOCK = 50007;// 冻结（官方暂时冻结）
    public final static int CAS_ERR_SERVER_DELETE = 50008;// 删除 
    /*自定义账号状态*/
    public final static int CAS_ERR_PASSPORT_BLOCK_FOREVER = 51015;// 账号永久停封
    public final static int CAS_ERR_PASSPORT_DELETE = 51016;// 账号删除
    /*-----------------------------------------------------------------------------------------------------------------------------*/
}
