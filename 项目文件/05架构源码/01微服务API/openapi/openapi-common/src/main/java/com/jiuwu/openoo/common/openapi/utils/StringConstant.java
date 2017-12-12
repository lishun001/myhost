package com.jiuwu.openoo.common.openapi.utils;

import java.util.HashMap;
import java.util.Map;

public class StringConstant {
	
	/** 雇主下单 */
	public static final int EMPLOYEE_STATUS_0 = 0;
	/** 开始服务 */
	public static final int EMPLOYEE_STATUS_1 = 1;
	/** 结算 */
	public static final int EMPLOYEE_STATUS_2 = 2;
	/** 完成 */
	public static final int EMPLOYEE_STATUS_3 = 3;
	
	/**
	 * 雇主订单状态
	 */
	/** 购买服务  */
	public static final int HIRE_STATUS_0 = 0;
	/** 发布需求  */
	public static final int HIRE_STATUS_1 = 1;
	/** 支付定金 */
	public static final int HIRE_STATUS_2 = 2;
	/** 确定服务者*/
	public static final int HIRE_STATUS_3 = 3;
	/** 服务中  */
	public static final int HIRE_STATUS_4 = 4;
	/** 确认评价  */
	public static final int HIRE_STATUS_5 = 5;
	/**0.	已抢单  */
	public static final int DRAG_STATUS_0 = 0;
	/**1.	抢单成功  */
	public static final int DRAG_STATUS_1 = 1;
	/**2.	被退单  */
	public static final int DRAG_STATUS_2 = 2;
	/**3.	雇主取消订单  */
	public static final int DRAG_STATUS_3 = 3;
	/**4.	订单结束  */
	public static final int DRAG_STATUS_4 = 4;
	/**0：未退单  */
	public static final int HIRE_RETURN_STATUS_0 = 0;
	/**1：我申请退单中 */
	public static final int HIRE_RETURN_STATUS_1 = 1;
	/**2：对方申请退单中  */
	public static final int HIRE_RETURN_STATUS_2 = 2;
	/**3：对方同意 */
	public static final int HIRE_RETURN_STATUS_3 = 3;
	/**4：对方拒绝  */
	public static final int HIRE_RETURN_STATUS_4 = 4;
	/**5:我同意  */
	public static final int HIRE_RETURN_STATUS_5 = 5;
	/**6:我拒绝  */
	public static final int HIRE_RETURN_STATUS_6 = 6;
	/**0：购买服务  */
	public static final int HIRE_SOURCE_0 = 0;
	/**1：发布需求  */
	public static final int HIRE_SOURCE_1 = 1;
	
	/**
	 * 退单表退单状态
	 */
	/**0. 等待对方确认  */
	public static final int RETURN_STATUS_0 = 0;
	/**1. 对方同意  */
	public static final int RETURN_STATUS_1 = 1;
	/**2. 对方拒绝  */
	public static final int RETURN_STATUS_2 = 2;
	/**3. 超过2天，对方没有反应，定时器自动关闭订单  */
	public static final int  RETURN_STATUS_3 = 3;
	
	/** 雇主类型 */
	public static final int IS_HIRE = 0;
	/** 雇员类型 */
	public static final int IS_EMPLOYEE = 1;
	/** 1: 是 */
	public static final int YES = 1;
	/** 0: 否 */
	public static final int NO = 0;
	
	/** 0: 雇主主动购买*/
	public static final int HIRE_BUY_0 = 0;
	/** 1: 雇主发布需求 */
	public static final int HIRE_PUBLISH_1 = 1;
	/** 2: 闪电派单 */
	public static final int HIRE_LIGHTNING_2 = 2;
	/**
	 *  订单表退单状态 
	 */
	/**0. 未退单  */
	public static final int ORDER_RETURN_STATUS_0 = 0;
	/**1. 我申请退单中  */
	public static final int ORDER_RETURN_STATUS_1 = 1;
	/**2. 对方申请退单中 */
	public static final int ORDER_RETURN_STATUS_2 = 2;
	/**3. 对方同意退单 */
	public static final int ORDER_RETURN_STATUS_3 = 3;
	/**4. 对方拒绝退单  */
	public static final int ORDER_RETURN_STATUS_4 = 4;
	/**5. 我同意退单 */
	public static final int ORDER_RETURN_STATUS_5 = 5;
	/**6. 我拒绝退单 */
	public static final int ORDER_RETURN_STATUS_6 = 6;
	
	/**
	 * 结算状态
	 */
	 /** 0：等待雇主支付 */
	public static final int BALANCE_STATUS_0 = 0;
	 /**  1：雇主同意  */
	public static final int BALANCE_STATUS_1 = 1;
	 /**  2：雇主拒绝 */
	public static final int BALANCE_STATUS_2 = 2;
	

	
	/**0：等待雇主支付 */
	public static final int SUMMARY_STATUS_0 = 0;
	/**1：雇主同意 */
	public static final int SUMMARY_STATUS_1 = 1;
	/**2：雇主拒绝 */
	public static final int SUMMARY_STATUS_2 = 2;
	/**3:  申请结算，对方没回应，3天内支付 */
	public static final int SUMMARY_STATUS_3 = 3;
	/**
	 * 订单关闭类型
	 */
	/**0. 正常关闭 */
	public static final int ORDER_CLOSE_TYPE_0 = 0;
	/**1. 7天内无人抢单，订单自动关闭 */
	public static final int ORDER_CLOSE_TYPE_1 = 1;
	/**2. 1天内不支付定金，订单自动关闭 */
	public static final int ORDER_CLOSE_TYPE_2 = 2;
	/**3. 申请退单，对方没回应，2天内订单关闭 */
	public static final int ORDER_CLOSE_TYPE_3 = 3;
	/**4. 申请结算，对方没回应，3天内支付，且关闭订单 */
	public static final int ORDER_CLOSE_TYPE_4 = 4;
	/**5.雇主下单，7天内雇员没点击结算，返定金，结束订单 */
	public static final int ORDER_CLOSE_TYPE_5 = 5;
	/**6.超过7天雇主不确定服务者，订单自动关闭*/
	public static final int ORDER_CLOSE_TYPE_6 = 6;
	/**7.雇主同意退单*/
	public static final int ORDER_CLOSE_TYPE_7 = 7;
	/**8.退单超时，不能重启*/
	public static final int ORDER_CLOSE_TYPE_8 = 8;
	/**9.订单重新开启*/
	// TODO
	public static final int ORDER_CLOSE_TYPE_9 = 9;
	/**10.如果雇主拒绝结算，雇员3天内不再请求结算，则返回定金，结束订单 */
	public static final Integer ORDER_CLOSE_TYPE_10 = 10;
	/**11.雇主取消订单*/
	public static final int ORDER_CLOSE_TYPE_11 = 11;
	/**12雇员取消订单*/
	public static final int ORDER_CLOSE_TYPE_12 = 12;
	/**13雇员同意退单*/
	public static final int ORDER_CLOSE_TYPE_13 = 13;
	
	/**1 雇主取消订单*/
	public static final int SOURCE_1 = 1;
	/**2 雇员取消订单*/
	public static final int SOURCE_2 = 2;
	
	/**0. 状态有问题*/
	public static final int SHOW_STATUS_0 = 0;
	/**1. 待支付*/
	public static final int SHOW_STATUS_1 = 1;
	/**2. 结算*/
	public static final int SHOW_STATUS_2 = 2;
	/**3. 确认结算*/
	public static final int SHOW_STATUS_3 = 3;
	/**4. 服务中,等待结算*/
	public static final int SHOW_STATUS_4 = 4;
	/**5. 等待买家确认结算*/
	public static final int SHOW_STATUS_5 = 5;
	/**6. 请等待对方支付定金*/
	public static final int SHOW_STATUS_6 = 6;
	/**7. 请完成服务*/
	public static final int SHOW_STATUS_7 = 7;
	/**8. 对方申请退单*/
	public static final int SHOW_STATUS_8 = 8;
	/**9. 退单申请中*/
	public static final int SHOW_STATUS_9 = 9;
	/**10. 退单被拒绝*/
	public static final int SHOW_STATUS_10 = 10;
	/**11. 对方拒绝确认结算*/
	public static final int SHOW_STATUS_11 = 11;
	/**12. 订单已完成*/
	public static final int SHOW_STATUS_12 = 12;
	/**13. 订单已取消*/
	public static final int SHOW_STATUS_13 = 13;
	/**14. 待评价*/
	public static final int SHOW_STATUS_14 = 14;
	/**15. 订单已关闭*/
	public static final int SHOW_STATUS_15 = 15;
	/**16. 如果1天内不支付定金,订单将自动关闭*/
	public static final int SHOW_STATUS_16 = 16;
	/**17. 请尽快完成服务并结算*/
	public static final int SHOW_STATUS_17 = 17;
	/**18. 如果不进行服务会在三天内返还给买家*/
	public static final int SHOW_STATUS_18 = 18;
	/**19. 申请退单*/
	public static final int SHOW_STATUS_19 = 19;
	/**20. 如果买家3天内没有确认，定金将自动支付到您的账户。*/
	public static final int SHOW_STATUS_20 = 20;
	/**21. 对方已确认并对你的服务进行了评价，交易结束*/
	public static final int SHOW_STATUS_21 = 21;
	/**22. 等待对方确认退单*/
	public static final int SHOW_STATUS_22 = 22;
	/**23. 请耐心等待对方确认，再次退单申请需要等待3小时。*/
	public static final int SHOW_STATUS_23 = 23;
	/**24. 双方已达成协议退单，订单已关闭*/
	public static final int SHOW_STATUS_24 = 24;
	/**25. 雇主拒绝您的退单申请*/
	public static final int SHOW_STATUS_25 = 25;
	/**26. 请尽快完成服务并结算，再次退单申请需要等待3小时。*/
	public static final int SHOW_STATUS_26 = 26;
	/**27. 等待确认服务者*/
	public static final int SHOW_STATUS_27 = 27;
	/**28. 已经退单*/
	public static final int SHOW_STATUS_28 = 28;
	/**29. 服务中*/
	public static final int SHOW_STATUS_29 = 29;
	/**30. 雇主同意支付 */
	public static final int SHOW_STATUS_30 = 30;
	/**31. 雇主同意退单 */
	public static final int SHOW_STATUS_31 = 31;
	/**32. 雇员同意退单 */
	public static final int SHOW_STATUS_32 = 32;
	/**33. 雇员拒绝退单 */
	public static final int SHOW_STATUS_33 = 33;
	/**34. 雇主已下单，等待商家分配 (洗衣洗鞋) */
	public static final int SHOW_STATUS_34 = 34;
	/**35. 商家已分配，正在服务(洗衣洗鞋)  */
	public static final int SHOW_STATUS_35 = 35;
	/**36. 已确认结算，未评论  */
	public static final int SHOW_STATUS_36 = 36;
	/**37. 已评论，订单完成  */
	public static final int SHOW_STATUS_37 = 37;
	/**38. 雇主已下单，等待分配(家政)   */
	public static final int SHOW_STATUS_38 = 38;
	/**39. 已分配，服务中(家政)   */
	public static final int SHOW_STATUS_39 = 39;
	/**40. 雇主取消订单(家政)  */
	public static final int SHOW_STATUS_40 = 40;
	/**41. 交易完成(家政)  */
	public static final int SHOW_STATUS_41 = 41;
	/**38. 雇主已下单，等待分配(洗衣洗鞋)   */
	public static final int SHOW_STATUS_42 = 42;
	/**39. 已分配，服务中(洗衣洗鞋)   */
	public static final int SHOW_STATUS_43 = 43;
	/**40. 雇主取消订单(洗衣洗鞋)  */
	public static final int SHOW_STATUS_44 = 44;
	/**41. 交易完成(洗衣洗鞋)  */
	public static final int SHOW_STATUS_45 = 45;
	/**41. 代理商关闭订单(洗衣洗鞋)  */
	public static final int SHOW_STATUS_46 = 46;
	/**41. 代理商关闭订单(家政)  */
	public static final int SHOW_STATUS_47 = 47;
	/**41. 雇主已下单，等待商家分配 (家政)  */
	public static final int SHOW_STATUS_48 = 48;
	/**41. 商家已分配，正在服务 (家政)  */
	public static final int SHOW_STATUS_49 = 49;
	/**41. 交易成功(洗衣洗鞋)  */
	public static final int SHOW_STATUS_50 = 50;
	/**42  定时器关闭订单 */
	public static final int SHOW_STATUS_51 = 51;
	/**42   申请结算，对方没回应，3天内支付，且关闭订单 */
	public static final int SHOW_STATUS_52 = 52;
	/**43 申请退单，对方没回应，2天内订单关闭*/
	public static final int SHOW_STATUS_53 = 53;
	/**43 7天内雇员没点击结算，返定金，结束订单*/
	public static final int SHOW_STATUS_54= 54;
	/**43  1天内不支付定金，订单自动关闭*/
	public static final int SHOW_STATUS_55= 55;
	/**43 7天内无人抢单，订单自动关闭*/
	public static final int SHOW_STATUS_56= 56;
	/**43 超过7天雇主不确定服务者，订单自动关闭*/
	public static final int SHOW_STATUS_57= 57;
	/**
	 * 订单结算状态
	 */
	/** 0.未结算 */
	public static final Integer SUMMARY_STATUS_TYPE_0 = 0;
	/** 1.雇员请求结算中  */
	public static final Integer SUMMARY_STATUS_TYPE_1 = 1;
	/** 2.雇主同意结算  */
	public static final Integer SUMMARY_STATUS_TYPE_2 = 2;
	/** 3.雇主拒绝结算  */
	public static final Integer SUMMARY_STATUS_TYPE_3 = 3;
	/**  
	 * 订单状态 
	 *
	*/
	/** 0为没有结束 */
	public static final Integer ORDER_NO =  0;
	/**  1 为已经结束 */
	public static final Integer ORDER_YES =  1; 
	
	/** 用于页面显示的订单状态*/
	@SuppressWarnings("serial")
	public final static Map<Integer,String> showMsg = new HashMap<Integer,String>() {
	{    
	    put(1, "支付");    
	    put(2, "结算");    
	    put(3, "确认结算");
	    put(4, "服务中,等待结算");  
	    put(5, "等待买家确认结算");  
	    put(6, "等待雇主支付定金");  
	    put(7, "请完成服务");  
	    put(8, "对方申请退单");  
	    put(9, "退单申请中");  
	    put(10, "退单被拒绝");  
	    put(11, "对方拒绝结算");  
	    put(12, "订单已完成");  
	    put(13, "订单已取消");  
	    put(14, "待评价");  
	    put(15, "订单已关闭");  
	    put(16, "如果1天内不支付定金,订单将自动关闭");  
	    put(17, "请尽快完成服务并结算");  
	    put(18, "如果不进行服务会在三天内返还给买家");  
	    put(19, "申请退单");  
	    put(20, "如果买家3天内没有确认，定金将自动支付到您的账户。");  
	    put(21, "对方已确认并对你的服务进行了评价，交易结束");  
	    put(22, "等待对方确认退单");  
	    put(23, "请耐心等待对方确认，再次退单申请需要等待3小时。");  
	    put(24, "双方已达成协议退单，订单已关闭");  
	    put(25, "雇主拒绝您的退单申请");  
	    put(26, "请尽快完成服务并结算，再次退单申请需要等待3小时。");  
	    put(27, "重新结算");  
	    put(28, "买家拒绝结算，请您和买家协商后重新结算。");  
	    put(29, "对方已确认并对你的服务进行了评价，交易结束。");  
	}}; 
	
	/** 
	 * 查询备注时所用状态
	*/
	/** 处于退单的备注*/
	public static final Integer REMARK_TYPE_1 = 1;
	/** 处于结算的备注*/
	public static final Integer REMARK_TYPE_2 = 2;
	/** 申请*/
	public static final Integer REMARK_STATUS_1 = 1;
	/** 确认*/
	public static final Integer REMARK_STATUS_2 = 2;
	
	/** 发送推送消息的地址  */
	//public static final String PUSH_HOST = "http://192.168.1.78:8080/forward/linggong/";
	public static final String PUSH_HOST = "http://openapi.openoo.com/forward/linggong/";
	
	//public static final String PUSH_HOST = "http://openapi.openoo.com/forward/linggong/";
	
	/**
	 * 评论星级
	 */
	//赞
	public static final Integer STAR_FIVE = 5;
	//一般
	public static final Integer STAR_THREE = 3;
	//不爽
	public static final Integer STAR_ONE = 1;
	
	/**
	 * 用户类型
	 */
	//  普通用户
	public static final Integer GENERAL_0 = 0;
	//  闪电派单（代理商用户）
	public static final Integer lightning_1 = 1;
	
	/**
	 *  服务类别所属功能圈 
	 */
//  属于零工圈
	public static final Integer LOCATION_0 = 0;
	// 属于闪电派单
	public static final Integer LOCATION_1 = 1;
//  零工圈和闪电派单都有
	public static final Integer LOCATION_2 = 2;
	
	/**
	 * 用户角色
	 */
	/** 雇主 */
	public static final Integer ROLE_HIRE = 0;
	/** 雇员 */
	public static final Integer ROLE_EMPLOYEE = 1;
	
	/**
	 * 闪电类别
	 */
	//家政服务
	public static final Integer LIGHTNINGType_0 = 0; 
	//洗衣洗鞋
	public static final Integer LIGHTNINGType_1 = 1;
	
	/**  
	 * 支付方式
	 */
	//现金支付
	public static final Integer pay_type_4 = 4;
	
	/**  
	 * 1m对应的经度
	 */
	public static final Double DIS_LON = 0.000009788;
	/**  
	 * 1m对应的纬度
	 */
	public static final Double DIS_LAT = 0.000009;
	
	/**  
	 * 无效的经纬度
	 */
	public static final Double INVALID_LOC = 0.0;
}
