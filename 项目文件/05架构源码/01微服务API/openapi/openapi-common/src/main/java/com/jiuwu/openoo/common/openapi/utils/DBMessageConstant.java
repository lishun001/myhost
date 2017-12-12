package com.jiuwu.openoo.common.openapi.utils;

/**
 * 100：参数异常 200：业务异常 300：服务器异常
 * 
 * @author Administrator
 * 
 */
public class DBMessageConstant {
	
	/**
	 * 常量
	 */
	//注册，发验证码
	public static final  Integer register_code_type = 1;
	//重置密码，发验证码
	public static final  Integer resetting_code_type = 2;
	
	
	public static final String login_user_key = "user_login_key";
	/**
	 * 新用户注册
	 * 
	 * @author xiaoyong
	 * 
	 */
	public interface INSERT_USER {
		public static final String METHOD = "jiuwu.user.daboo.register_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 电话为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 密码不可为空
		 */
		public static final String ERROR_102 = "102";
		
		/**
		 * 昵称不能为空
		 */
		public static final String ERROR_103 = "103";

		/**
		 * 该昵称已被占用
		 */
		public static final String ERROR_104 = "104";
		
		/**
		 * 用户已经注册
		 */
		public static final String ERROR_200 = "200";
		
		/**
		 * 昵称已经存在
		 */
		public static final String ERROR_201 = "201";
		
	}

	/**
	 * 更新用户信息
	 * 
	 * @author SamFan
	 * 
	 */
	public interface UPDATE_USER_INFO {
		public static final String METHOD = "jiuwu.user.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 没有要更新的用户信息
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户性别类型错误，请输入0：女，1：男
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户签名超过200个字
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 用户兴趣爱好格式错误
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 生日格式错误，其输入：yyyy-MM-dd
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 用户地区格式错误，请输入：01,02,99
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 圈圈账号长度不能小于6个字符
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 圈圈账号已被使用
		 */
		public static final String ERROR_108 = "108";
		/**
		 * 无法获取用户主键ID
		 */
		public static final String ERROR_109 = "109";
		/**
		 * 圈圈账号只能为字母或者数字，且不能为纯数字
		 */
		public static final String ERROR_110 = "110";
		/**
		 * 性别已经修改过一次
		 */
		public static final String ERROR_111 = "111";
		/**
		 * 圈圈账号已经被修改过一次
		 */
		public static final String ERROR_112 = "112";
		/**
		 * 更新了零条数据
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 接口异常
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 图片上传错误
		 */
		public static final String ERROR_301 = "301";
		/**
		 * 完善资料时昵称不能为空
		 */
		public static final String ERROR_302 = "302";
		/**
		 * 完善资料时性别不能为空
		 */
		public static final String ERROR_303 = "303";
		/**
		 * 完善资料时生日不能为空
		 */
		public static final String ERROR_304 = "304";
		/**
		 * 完善资料时id不能为空
		 */
		public static final String ERROR_305 = "305";
		/**
		 * 完善资料时图片不能为空
		 */
		public static final String ERROR_306 = "306";
	}



	/**
	 * 重置密码前检验或者注册用户时检测用户是否存在
	 */
	public interface GET_USERCODE {

		public static final String METHOD = "jiuwu.user.daboo.usercode.find_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 手机号为空
		 */
		public static final String ERROR_101 = "101";
		
		/**
		 * 设备标示为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 类型type为空
		 */
		public static final String ERROR_103 = "103";
		
		/**
		 * 此地区不支持语音验证
		 */
		public static final String ERROR_104= "104";
		
		/**
		 * 手机号码格式有误
		 */
		public static final String ERROR_105= "105";
		
		
		/**
		 * 类型type不正确（注册为1，重置密码为2）
		 */
		public static final String ERROR_106 = "106";
		
		/**
		 * 手机号没有注册
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 超出单日发送验证码次数限制
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 超出发送验证码总次数限制
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 距离上次发送必须间隔60秒
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 30分钟之内只能发送3次验证码
		 */
		public static final String ERROR_204 = "204";
		/**
		 * 此mac发送验证码次数超出限制
		 */
		public static final String ERROR_205 = "205";
		/**
		 * 如果此时用户处于无法进行“验证”的状态，则无法发送验证码
		 */
		public static final String ERROR_206 = "206";
		/**
		 * 重置密码前检验失败
		 */
		public static final String ERROR_207 = "207";
		/**
		 * 用户已经注册
		 */
		public static final String ERROR_208 = "208";
		/**
		 * 发送验证码失败
		 */
		public static final String ERROR_209 = "209";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 验证码类型(1为注册)
		 */
		public static final Integer CODE_TYPE_ONE = 1;
		/**
		 * 验证码类型(2为重置)
		 */
		public static final Integer CODE_TYPE_TWO = 2;
		/**
		 * 验证码状态(1为未使用)
		 */
		public static final Integer CODE_STATE_VALID = 1;
		/**
		 * 验证码状态（3为已经验证成功）
		 */
		public static final Integer CODE_STATE_ISUSED = 3;
		/**
		 * 验证码状态（2为已经验证失效）
		 */
		public static final Integer CODE_STATE_INVALID = 2;
		/**
		 * 短信发送成功
		 */
		public static final String SEND_CODE_SUCCESS = "03";
		
		/**
		 * 封号
		 */
		public static final Byte CLOSE_ACCOUNT = -1;
		/**
		 * 删除
		 */
		public static final Byte REMOVE_ACCOUNT = 0;
		/**
		 * 正常
		 */
		public static final Byte NORMAL_ACCOUNT = 1;
		
	}

	/**
	 * 验证码验证
	 */
	public interface VER_CODE {

		public static final String METHOD = "jiuwu.user.verify_";

		/**
		 * 验证码是否匹配 0为不匹配
		 */
		public static final Integer CODE_MISMATCH = 0;
		/**
		 * 验证码匹配
		 */
		public static final Integer CODE_MATCH = 1;
		/**
		 * 请求对象为空
		 * 
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 验证码为空
		 * 
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 类型为空
		 * 
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户手机号为空
		 * 
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 验证码不匹配
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 连续输入错误，请10分钟后再试
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 验证码过期
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 验证码无效
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 请输入正确的验证码
		 */
		public static final String ERROR_204 = "204";
		/**
		 * 系统错误
		 * 
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 经度不能为空
		 */
		public static final String ERROR_401 = "401";
		/**
		 * 纬度不能为空
		 */
		public static final String ERROR_402 = "402";
	}

	/**
	 * 重置密码
	 */
	public interface SET_PASSWORD {

		public static final String METHOD = "jiuwu.user.daboo.setpw.update_";
		/**
		 * 请求对象为空
		 * 
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 手机号为空
		 * 
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户输入的新密码为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 重置密码失败
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 进行短信验证时出错
		 */
		public static final String ERROR_297 = "297";
		/**
		 * 短信验证失效
		 */
		public static final String ERROR_298 = "298";
		/**
		 * 没有进行过短信验证
		 */
		public static final String ERROR_299 = "299";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 只接受https请求
		 */
		public static final String ERROR_399 = "399";
		/**
		 * 当前密码不能为空
		 */
		public static final String ERROR_400 = "400";
		/**
		 * 当前密码验证失败
		 */
		public static final String ERROR_401 = "401";
	}
	
	/**
	 * 用户登录
	 * 
	 * @author xiaoyong
	 * 
	 */
	public interface USER_LOGIN {
		public static final String METHOD = "jiuwu.daboo.user.login_";
		/**
		 * 手机号为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 密码为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 注册id不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 设备id不能为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 设备名不能为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 版本号不能为空
		 */
		public static final String ERROR_105 = "105";

		/**
		 * 密码错误:用户名或密码错误
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 手机号没注册:用户名或密码错误
		 */
		public static final String ERROR_201 = "201";
	}
	
	
	public interface SET_TASK_DATA{
		
		public static final String METHOD = "jiuwu.task.basic.data.set_";
		/**
		 *	userId为空
		 */
		public static final String ERROR_100 = "100";
		
		/**
		 * 任务标题不能为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 任务属性不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 赏金金额不能为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 纬度不能为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 经度不能为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 多人任务，任务人数不能为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 任务人数不能小于2
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 任务时间不能为空
		 */
		public static final String ERROR_108 = "108";
		/**
		 * 任务状态不能为空
		 */
		public static final String ERROR_109 = "109";
		/**
		 * taskId不能为空
		 */
		public static final String ERROR_110 = "110";
		/**
		 * PageSize不能为0
		 */
		public static final String ERROR_111 = "111";
		/**
		 * Position不能为0
		 */
		public static final String ERROR_112 = "112";
		/**
		 * Hunter不能为0
		 */
		public static final String ERROR_113 = "113";
		/**
		 * 排序不能为空
		 */
		public static final String ERROR_114 = "114";
		/**
		 * 任务地点不能为空
		 */
		public static final String ERROR_115 = "115";
		/**
		 * 任务分类不能为空 (1=附近任务，2=定点任务，3=多人任务，4=指定任务)
		 */
		public static final String ERROR_116 = "116";
		
		/**
		 * 按钮类型不能为空
		 */
		public static final String ERROR_117 = "117";
		/**
		 * 协商内容不能为空
		 */
		public static final String ERROR_118 = "118";
		/**
		 * 协商金额不能为空
		 */
		public static final String ERROR_119 = "119";
		
		/**
		 * 反馈内容不能为空
		 */
		public static final String ERROR_120 = "120";
		
		/**
		 * 上传图片标识不能为空
		 */
		public static final String ERROR_121 = "121";

		/**
		 * HunterId不能为空
		 */
		public static final String ERROR_122 = "122";
		
		/**
		 * userType不能为空
		 */
		public static final String ERROR_123 = "123";
		
		/**
		 * auditId不能为空
		 */
		public static final String ERROR_124 = "124";
		
		/**
		 * taskTitle长度不能长于20个
		 * 任务标题不大于20个字
		 */
		public static final String ERROR_125 = "125";
		
		/**
		 * equipmentId不能为空
		 */
		public static final String ERROR_126 = "126";
		/**
		 * registerId不能为空
		 */
		public static final String ERROR_127 = "127";
		/**
		 * 用户未注册
		 */
		public static final String ERROR_128 = "128";
		/**
		 * 该任务不存在
		 */
		public static final String ERROR_129 = "129";
		
		/**
		 * 举报类型id不能为空
		 */
		public static final String ERROR_130 = "130";
		
		/**
		 * 您已举报过该任务
		 */
		public static final String ERROR_131 = "131";
		/**
		 * 列表类型不能为空
		 */
		public static final String ERROR_132 = "132";
		/**
		 * 期望截止日期不能为空
		 */
		public static final String ERROR_133 = "133";
		
		/**
		 * 用户电话不能为空
		 */
		public static final String ERROR_134 = "134";
		/**
		 * 用户电话和id不能同时为空
		 */
		public static final String ERROR_135 = "135";
		/**
		 * 话题不能为空
		 */
		public static final String ERROR_136 = "136";
		/**
		 * 搜索内容不能为空
		 */
		public static final String ERROR_137 = "137";
		//======以下是业务提示信息==================
//		--------------------HunterTaskServiceImpl中使用--------------
		/**
		 * 请先绑定支付宝
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 该用户不存在
		 */
		public static final String ERROR_301 = "301";
		/**
		 * 当前用户已被删除或者封号
		 */
		public static final String ERROR_302 = "302";
		/**
		 *该任务揭榜人数已达上限5人
		 */
		public static final String ERROR_303 = "303";
		/**
		 * 已经揭榜该任务，请等待被指定
		 */
		public static final String ERROR_304 = "304";
		/**
		 * 当前任务状态不能揭榜
		 */
		public static final String ERROR_305 = "305";
		/**
		 * 您不能揭榜自己发布的任务
		 */
		public static final String ERROR_306 = "306";
		/**
		 * 您的等级不符合任务要求
		 */
		public static final String ERROR_307 = "307";
		/**
		 * 您的年龄不符合任务要求
		 */
		public static final String ERROR_308 = "308";
		/**
		 * 您的性别不符合任务要求
		 */
		public static final String ERROR_309 = "309";
		/**
		 * 当前猎人没有被选择
		 */
		public static final String ERROR_310 = "310";
		
		/**
		 * 任务状态为'已派发',猎人才能执行任务
		 */
		public static final String ERROR_311 = "311";
		
		/**
		 * 当前用户已被删除或者封号,不能发布任务
		 */
		public static final String ERROR_312 = "312";
		
		//--------------------TaskServiceImpl中使用--------------
		/**
		 * 当任务状态不能放弃任务
		 */
		public static final String ERROR_400 = "400";
		/**
		 *放弃任务失败
		 */
		public static final String ERROR_401 = "401";
		/**
		 * 该用户没有权限删除此任务
		 */
		public static final String ERROR_402 = "402";
		/**
		 * 当前任务不能删除
		 */
		public static final String ERROR_403 = "403";
		/**
		 * 当前任务不存在
		 */
		public static final String ERROR_404 = "404";
		/**
		 *当前用户没有权限执行此操作
		 */
		public static final String ERROR_405 = "405";
		/**
		 * 任务状态为'已取消','已创建',猎人才能执行该操作
		 */
		public static final String ERROR_406 = "406";
		
		/**
		 * 当前任务状态下不能重新发布
		 */
		public static final String ERROR_407 = "407";
		
		/**
		 * 当前猎人无法被选择
		 */
		public static final String ERROR_408 = "408";
		/**
		 * 该猎人没有揭榜该任务或已放弃该任务
		 */
		public static final String ERROR_409 = "409";
		/**
		 * 您的任务还没有人揭榜
		 */
		public static final String ERROR_410 = "410";
		/**
		 * 您的任务还没有发布
		 */
		public static final String ERROR_411 = "411";
		/**
		 * 当前任务状态为下无法执行该操作
		 */
		public static final String ERROR_412 = "412";
		
		/**
		 * 该任务已经在'退款中'，请耐心等待处理结果
		 */
		public static final String ERROR_413 = "413";
		
		/**
		 * 当前用户没有权限查收此任务
		 */
		public static final String ERROR_414 = "414";
		
		/**
		 *该任务在当前状态下不能被查收
		 */
		public static final String ERROR_415 = "415";
		
		/**
		 *不支持该表情输入
		 */
		public static final String ERROR_416 = "416";
		
		/**
		 *该任务的订单不存在
		 */
		public static final String ERROR_417 = "417";
		
		/**
		 *对方正在付款中，暂时无法放弃任务
		 */
		public static final String ERROR_418 = "418";
		
		/**
		 *修改信息异常或昵称被占用
		 */
		public static final String ERROR_419 = "419";
		
		/**
		 *当前任务交易不存在
		 */
		public static final String ERROR_420 = "420";
		
		/**
		 * 您的申述已提交成功，请等待，我们会及时与您联系
		 */
		public static final String ERROR_421 = "421";
		
		/**
		 * 申诉原因不能为空
		 */
		public static final String ERROR_422 = "422";
		
		/**
		 * 您已”同意退款“，系统会将赏金返回给悬赏人
		 */
		public static final String ERROR_423 = "423";
		
		/**
		 * 您今天已经催过了，要不等等
		 */
		public static final String ERROR_424 = "424";
		/**
		 * 输入的截止日期无法使用
		 */
		public static final String ERROR_425 = "425";
	}
	/**
	 * 消息推送
	 * 
	 * @author eason
	 * 
	 */
	public interface PUSH_TASK_DATA {
		public static final String METHOD = "jiuwu.daboo.push.verify_";
		/**
		 * APP应用id不能为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 消息标题不能为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 消息内容不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 任务消息ID不能为空
		 */
		public static final String ERROR_103 = "103";
		
		/**
		 * 用户ID不能为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 模板CODE不能为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 即时通讯发送失败
		 */
		public static final String ERROR_106 = "106";
	}
	
	/**
	 * t_task_deal
	 * 
	 * @author eason
	 * 
	 */
	public interface TASK_DEAL_DATA {
		public static final String METHOD = "jiuwu.daboo.deal.verify_";
		/**
		 * 交易id不能为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 任务id不能为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 赏金金额不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 猎人id不能为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 猎人已经放弃该任务，无法创建订单
		 */
		public static final String ERROR_113 = "113";
		/**
		 * 猎人服务不能重复开通
		 */
		public static final String ERROR_104 = "104";
		/**
		 * pageSize不能为0
		 */
		public static final String ERROR_105= "105";
		/**
		 * position不能为0
		 */
		public static final String ERROR_106 = "106";
		
		/**
		 * userId不能为空
		 */
		public static final String ERROR_107 = "107";
		
		/**
		 * 当前任务未完成不能评分
		 */
		public static final String ERROR_400= "400";
		
		/**
		 * 当前用户不存在
		 */
		public static final String ERROR_401 = "401";
		
		/**
		 * 当前用户已被删除或者封号
		 */
		public static final String ERROR_402 = "402";
		
		/**
		 * 当前用户没有权限操作此任务
		 */
		public static final String ERROR_403 = "403";
		/**
		 * 您已提交过评分
		 */
		public static final String ERROR_404 = "404";
		/**
		 *此交易不存在
		 */
		public static final String ERROR_405 = "405";
		
	}
	/**
	 * 活动方案
	 * 
	 * @author eason
	 * 
	 */
	public interface MKT_PLAN_DATA {
		public static final String METHOD = "jiuwu.daboo.mkt.verify_";
		/**
		 * 活动id不能为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 活动名称不能为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 图片URL不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 开始时间不能为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 结束时间不能为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * pageSize不能为0
		 */
		public static final String ERROR_105= "105";
		/**
		 * position不能为0
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 是否置顶不能为空
		 */
		public static final String ERROR_107= "107";
		/**
		 * 是否热门不能为空
		 */
		public static final String ERROR_108 = "108";
		/**
		 * 经度不能为空
		 */
		public static final String ERROR_109 = "109";
		/**
		 * 纬度不能为空
		 */
		public static final String ERROR_110 = "110";
		/**
		 * 用户ID不能为空
		 */
		public static final String ERROR_111 = "111";
	}
	
	public interface WALLET_PAY_DATA {
		
		public static final String METHOD = "jiuwu.daboo.wallet.verify_";
		/**
		 * 用户ID不能为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户Ta币ID不能为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 金额不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 等值Ta币不能为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 支付方式不能为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 支付标题不能为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 还没有可用的账户
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 账户信息不能为空
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 账户名不能为空
		 */
		public static final String ERROR_108 = "108";
		/**
		 * 支付ID不能为空
		 */
		public static final String ERROR_109 = "109";
		/**
		 * 您的余额不足
		 */
		public static final String ERROR_110 = "110";
		/**
		 * 您的输入的用户和钱包不匹配
		 */
		public static final String ERROR_111 = "111";
		/**
		 * 账户不存在或已经删除
		 */
		public static final String ERROR_112 = "112";
		/**
		 * 活动期提款账户最低余额为10Ta币
		 */
		public static final String ERROR_113 = "113";
		/**
		 * 任务金额最低为1Ta币
		 */
		public static final String ERROR_114 = "114";
		/**
		 * 支付密码需验证登陆密码
		 */
		public static final String ERROR_115 = "115";
		/**
		 * 新密码与旧密码不同相同
		 */
		public static final String ERROR_116 = "116";
		/**
		 * 最低提现金额为10Ta币
		 */
		public static final String ERROR_117 = "117";
		/**
		 * 不存在的账户
		 */
		public static final String ERROR_118 = "118";
		/**
		 * 该账户已存在
		 */
		public static final String ERROR_119 = "119";
		/**
		 * 积分格式错误
		 */
		public static final String ERROR_120 = "120";
		/**
		 * 积分不足
		 */
		public static final String ERROR_121 = "121";
	}
	
	public interface SET_SHARE_DATA{
		public static final String METHOD = "jiuwu.daboo.share.verify_";
		/**
		 * 分享Id为空
		 */
		public static final String ERROR_100 = "100";	
		/**
		 * 分享类型为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 找不到分享内容
		 */
		public static final String ERROR_102 = "102";
	}
	
	
	public interface SET_COMMENT_DATA{
			public static final String METHOD = "jiuwu.daboo.comment.verify_";
			/**
			 *	userId为空
			 */
			public static final String ERROR_100 = "100";
			/**
			 * taskId不能为空
			 */
			public static final String ERROR_101 = "101";
			/**
			 * PageSize不能为0
			 */
			public static final String ERROR_102 = "102";
			/**
			 * Position不能为0
			 */
			public static final String ERROR_103 = "103";
			/**
			 * 内容不能为空
			 */
			public static final String ERROR_104 = "104";
			/**
			 * 回复评论id为空
			 */
			public static final String ERROR_105 = "105";
			/**
			 * 评论人id为空
			 */
			public static final String ERROR_106 = "106";
			/**
			 * 评论id为空
			 */
			public static final String ERROR_107 = "107";
			/**
			 * 当前用户无权限删除此评论/回复
			 */
			public static final String ERROR_108 = "108";
			
			/**
			 * 该评论不存在或已删除
			 */
			public static final String ERROR_109 = "109";
			
	}
	
	/**
	 * 举报报错
	 * @author Administrator
	 *
	 */
	public interface SET_REPORT_DATA{
		public static final String METHOD = "jiuwu.daboo.report.verify_";
		/**
		 * 您需要登录之后才能举报
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 评论ID不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 举报类型ID不能为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 您已经举报过该评论
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 任务ID不能为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 该任务已经不存在
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 该评论不存在或已被删除
		 */
		public static final String ERROR_107 = "107";
	}
	
	/**
	 * toolList(搜索栏、数据列表)报错
	 */
	public interface SEARCH_LIST_DATA{
		public static final String METHOD = "jiuwu.daboo.toolList.verify_";
		/**
		 * 话题不能为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 兴趣类型不能为空
		 */
		public static final String ERROR_102 = "102";
	}
}