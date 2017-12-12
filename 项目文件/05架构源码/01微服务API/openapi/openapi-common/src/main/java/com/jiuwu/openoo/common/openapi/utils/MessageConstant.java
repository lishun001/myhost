package com.jiuwu.openoo.common.openapi.utils;

/**
 * 100：参数异常 200：业务异常 300：服务器异常
 * 
 * @author Administrator
 * 
 */
public class MessageConstant {

	/**
	 * 对象存在
	 * 
	 * @author lishun
	 */
	public static final Integer OBJECT_EXIST = 0;
	/**
	 * 对象不存在
	 */
	public static final Integer OBJECT_INEXISTENT = 1;
	/**
	 * 有没有被修改 0是没有修改
	 */
	public static final Integer OBJECT_NOT_UPDATE = 0;
	/**
	 * 有木有被修改，1为修改过
	 */
	public static final Integer OBJECT_UPDATE = 1;
	/** 系统级参数 */
	public static String[] SYSTEM_PARAM_ARRAY = new String[] { "timestamp",
			"method", "ver", "sign" };
	/** timestamp */
	public static final String STRING_TIMESTAMP = "timestamp";
	/** 返回数据格式 xml/json */
	public static final String STRING_FORMAT = "format";
	/** 验证码 */
	public static final String STRING_SIGN = "sign";
	/** 版本号 */
	public static final String STRING_VER = "ver";
	/** 调用的接口名称 */
	public static final String STRING_METHOD = "method";
	/** 选择显示字段 */
	public static final String STRING_FIELDS = "fields";
	/** appKey */
	public static final String STRING_APPKEY = "appKey";
	/** sessionKey */
	public static final String STRING_SESSIONKEY = "sessionKey";
	public static final Integer FIVE= 5; 

	/**
	 * 新用户注册
	 * 
	 * @author SamFan
	 * 
	 */
	public interface INSERT_USER {
		public static final String METHOD = "jiuwu.user.register_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 电话为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户头像为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 昵称为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 性别为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 生日为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 生日格式错误，其输入：yyyy-MM-dd
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 密码不可为空
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 用户已经注册
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 插入零条数据
		 */
		/**
		 * 插入用户设置信息失败
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 插入用户设置信息失败
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 接口异常
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 头像路径更新失败
		 */
		public static final String ERROR_301 = "301";
		/**
		 * 头像上传失败
		 */
		public static final String ERROR_302 = "302";
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
	}

	/**
	 * 根据电话薄查询已经注册的用户信息
	 * 
	 * @author SamFan
	 * 
	 */
	public interface FIND_REGISTERED_USER {
		public static final String METHOD = "jiuwu.user.registered.find_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 电话薄为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 电话薄包含非法字符
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 无法获取用户ID
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 接口异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取好友信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_FRIENDS_INFO {
		public static final String METHOD = "jiuwu.friend.info.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 重置密码前检验或者注册用户时检测用户是否存在
	 */
	public interface GET_USERCODE {

		public static final String METHOD = "jiuwu.user.usercode.find_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 手机号为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * mac地址为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 类型type为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 类型只能为1或者2
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 用户手机号不存在
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
		 * /** 验证码为空
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
		 * 该手机已注册
		 */
		public static final String ERROR_205 = "205";
		/**
		 * 系统错误
		 * 
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 重置密码
	 */
	public interface SET_PASSWORD {

		public static final String METHOD = "jiuwu.user.setpw.update_";
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
		 * 
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
	}

	/**
	 * 修改密码
	 */
	public interface UPDATE_PASSWORD {

		public static final String METHOD = "jiuwu.user.updatepw.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户主键id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户旧密码为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户新密码为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 用户不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 用户输入的旧密码不准确
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 修改密码失败
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 只接受https请求
		 */
		public static final String ERROR_399 = "399";
	}

	/**
	 * 搜索好友
	 */
	public interface SEARCH_FRIEND {

		public static final String METHOD = "jiuwu.user.search.friend.find_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 好友参数为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户主键id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 当前用户不存在，无法查询好友
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 查找好友时没有找到用户
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 不允许通过手机号搜索到我
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 查找好友来源（1为通过手机号查找，0为通过圈圈号查找）
		 */
		public static final Integer SEARCH_FRIEND_SOURCE_0 = 0;
		/**
		 * 查找好友来源（1为通过手机号查找，0为通过圈圈号查找）
		 */
		public static final Integer SEARCH_FRIEND_SOURCE_1 = 1;
		/**
		 * 是否是好友，0为不是好友
		 */
		public static final Integer IS_FRIEND_0 = 0;
		/**
		 * 是否是好友，1为是好友
		 */
		public static final Integer IS_FRIEND_1 = 1;
	}

	/**
	 * 修改好友备注
	 * 
	 * @author lishun
	 * 
	 */
	public interface UPDATE_FRIEND {
		public static final String METHOD = "jiuwu.friend.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * friendId为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 修改好友临时手机号
	 * 
	 * @author SamFan
	 * 
	 */
	public interface UPDATE_FRIEND_TEMP_PHONE {
		public static final String METHOD = "jiuwu.friend.tempPhone.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * friendId为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 号码为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 文件上传
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_FILEINFO {
		public static final String METHOD = "jiuwu.file.insert_";
		/**
		 * 上传的文件为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * oss文件路径为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 文件来源为空
		 */
		public static final String ERROR_103 = "103";

		/**
		 * 文件来源不正确.
		 */
		public static final String ERROR_104 = "104";

		/**
		 * 文件后缀超长.
		 */
		public static final String ERROR_105 = "105";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 文件上传常量
	 * 
	 * @author lishun
	 * 
	 */
	public interface FILE_CONSTANT {
		/**
		 * 用户个人账户的图片
		 */
		public static final String FILE_SOURCE_USER_SET = "user";
		/**
		 * 认证发布图片
		 */
		public static final String FILE_SOURCE_AUTHOR_SET = "author";
		/**
		 * 活动的发布图片
		 */
		public static final String FILE_SOURCE_MKT_SET = "mkt";
		/**
		 * 广告的发布图片
		 */
		public static final String FILE_SOURCE_ADV_SET = "ADV";


		/**
		 * 图片的格式-GIF
		 */
		public static final String FILE_TYPE_GIF = "GIFImageReader";
		/**
		 * 图片的格式-JPEG
		 */
		public static final String FILE_TYPE_JPEG = "JPEGImageReader";
		/**
		 * 图片的格式-PNG
		 */
		public static final String FILE_TYPE_PNG = "PNGImageReader";
		/**
		 * 图片的格式-BMP
		 */
		public static final String FILE_TYPE_BMP = "BMPImageReader";
		/**
		 * 图片后缀-gif
		 */
		public static final String FILE_EXT_GIF = ".gif";

		/**
		 * 图片后缀-bmp
		 */
		public static final String FILE_EXT_BMP = ".bmp";
		/**
		 * 图片后缀-jpg
		 */
		public static final String FILE_EXT_JPG = ".jpg";
		/**
		 * 图片后缀-jpeg
		 */
		public static final String FILE_EXT_JPEG = ".jpeg";
		/**
		 * 图片后缀-PNG
		 */
		public static final String FILE_EXT_PNG = ".png";

	}

	/**
	 * 根据圈圈号或者手机号查找用户
	 */
	public interface GET_USERINFO {

		public static final String METHOD = "jiuwu.user.find_";

		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户主键id为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 用户经度为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户纬度为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 当前用户不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 没有查询到用户
		 */
		public static final String ERROR_201 = "201";

		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 新增常用设备信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_USERDEVICEINFO {
		public static final String METHOD = "jiuwu.user.device.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 设备名称为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 设备唯一标识为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取指定用户信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface QUERY_USERS {
		public static final String METHOD = "jiuwu.user.query_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 手机号列表为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 新增离线消息
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_OFFLINESMS {
		public static final String METHOD = "jiuwu.message.offlinesms.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 接受者地址为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 消息内容为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 消息类型为空
		 */
		public static final String ERROR_103 = "103";

		/**
		 * 消息内容过长
		 */
		public static final String ERROR_104 = "104";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

		/**
		 * 常量：离线消息的长度
		 */
		public static final int CONTENT_LENGTH = 4000;

	}

	/**
	 * 获取离线消息
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_OFFLINESMS {
		public static final String METHOD = "jiuwu.message.offlinesms.get_";
		/**
		 * 不存在离线
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取上传消息
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_SMSFILE {
		public static final String METHOD = "jiuwu.message.sms.file.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 上传的文件为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 消息类型为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 消息接受者不能为空
		 */
		public static final String ERROR_103 = "103";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 修改用户手机号
	 * 
	 * @author lishun
	 * 
	 */
	public interface UPDATE_PHONE {
		public static final String METHOD = "jiuwu.phone.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 手机号为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 验证码为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 验证码错误
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 验证码已超时失效
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 验证码已使用
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 30天内已修改过手机号，请稍候再试
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 该手机号已注册
		 */
		public static final String ERROR_204 = "204";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 將离线消息未读改为已读
	 * 
	 * @author lishun
	 * 
	 */
	public interface UPDATE_SMSINFORMATION {
		public static final String METHOD = "jiuwu.smsinformation.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 消息id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 用户登录
	 * 
	 * @author lishun
	 * 
	 */
	public interface USER_LOGIN {
		public static final String METHOD = "jiuwu.user.login_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 圈圈号或手机号为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 密码为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 设备唯一标识为空
		 */
		public static final String ERROR_103 = "103";

		/**
		 * 设备名称为空
		 */
		public static final String ERROR_104 = "104";

		/**
		 * 密码错误
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 圈圈号不存在
		 */
		public static final String ERROR_201 = "201";

		/**
		 * 手机号没注册
		 */
		public static final String ERROR_202 = "202";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 创建群聊
	 */
	public interface CREATE_GROUPCHAT {
		public static final String METHOD = "jiuwu.user.groupchat.create_";
		/**
		 * 用户主键id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 群聊id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 要加入的成员id列表为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 创建群聊失败
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 人数不够，无法创建群聊
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 退出群聊
	 * 
	 */
	public interface EXIT_GROUPCHAT {

		public static final String METHOD = "jiuwu.chat.exit_";
		/**
		 * 用户主键id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 群聊id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 要退出此群聊的人员为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 群聊或成员是否存在，存在为0
		 */
		public static final Integer GROUP_EXIT = 0;
		/**
		 * 群聊或成员是否存在，不存在为1
		 */
		public static final Integer GROUP_NOT_EXIT = 1;
		/**
		 * 要退出的群聊不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 要退出此群聊的成员不存在此群
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 退出群聊失败
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 删除群聊失败
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 加入群聊
	 */
	public interface JOIN_GROUPCHAT {

		public static final String METHOD = "jiuwu.chat.join_";
		/** 用户主键id为空 */
		public static final String ERROR_100 = "100";
		/** 群聊id为空 */
		public static final String ERROR_101 = "101";
		/** 要加入的成员列表为空 */
		public static final String ERROR_102 = "102";
		/** 群聊不存在 */
		public static final String ERROR_200 = "200";
		/** 无法获取要加入的成员，加入群聊失败 */
		public static final String ERROR_201 = "201";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 根据id获取此用户的所有群聊
	 * 
	 */
	public interface GET_ALL_GROUPCHAT {
		public static final String METHOD = "jiuwu.chat.get_";

		/**
		 * 用户id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 当前用户不存在，无法查询群聊
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 群名称是否修改过,0为没有修改过
		 */
		public static final Integer UPDATE_GROUP_NAME_0 = 0;

		/**
		 * 群名称是否修改过,1为修改过
		 */
		public static final Integer UPDATE_GROUP_NAME_1 = 1;

		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 根据群聊id获取单个群聊
	 * 
	 */
	public interface GET_GROUPCHAT {
		public static final String METHOD = "jiuwu.chat.find_";

		/**
		 * 用户id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 群聊id为空和sipId不能同时为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 当前用户不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	public interface ADD_FRIEND {
		public static final String METHOD = "jiuwu.friend.request.add_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId或friendId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友类型不合法
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 好友来源不合法
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 双方已是好友
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 好友请求已存在
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 数据不一致
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 用户(好友)不存在
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface DELETE_FRIEND {
		public static final String METHOD = "jiuwu.friend.delete_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId或friendId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友关系不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface FRIEND_REQUEST {
		public static final String METHOD = "jiuwu.friend.request.handle_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId或friendId或handleResult为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * handleResult错误
		 */
		public static final String ERROR_102 = "102";
		/**
		 * friendType错误
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 双方已是好友
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 数据不一致
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 好友请求不存在
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 用户(好友)不存在
		 */
		public static final String ERROR_204 = "204";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface USER_LOGO {
		public static final String METHOD = "jiuwu.user.logo.get_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface REQUEST_HTTPS {
		public static final String METHOD = "jiuwu.request.https_";

		/**
		 * 不是https请求
		 */
		public static final String ERROR_399 = "399";
	}

	public interface FRIEND_TYPE {
		public static final String METHOD = "jiuwu.friend.friendType.update_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * friendId为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * friendType不合法
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface OUT_FRIEND {
		public static final String METHOD = "jiuwu.friend.outFriend.find_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * userId为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface CHAT_SET {
		public static final String METHOD = "jiuwu.chat.chatSet_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 好友ID或群ID为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友ID或群ID同时存在
		 */
		public static final String ERROR_102 = "102";
		/**
		 * userId为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 聊天设置不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取与我相关信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_ATME {
		public static final String METHOD = "jiuwu.atme.get_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 清空与我相关信息
	 * @author lishun
	 *
	 */
	public interface DELETE_ATME{
		public static final String METHOD = "jiuwu.atme.delete_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100="100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101="101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 标记该动态为删除状态
	 * 
	 * @author lishun
	 * 
	 */
	public interface REMOVE_TREND {
		public static final String METHOD = "jiuwu.trend.remove_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 动态id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 删除评论
	 * 
	 * @author wengtao
	 * 
	 */
	public interface REMOVE_REPLY {
		public static final String METHOD = "jiuwu.trend.reply.remove_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/*
		 * 动态id为空
		 */
		public static final String ERROR_102 = "102";
		// 评论id为空
		public static final String ERROR_103 = "103";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 取消点赞
	 * 
	 * @author lishun
	 * 
	 */
	public interface UN_PRAISE {
		public static final String METHOD = "jiuwu.trend.unpraise_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 动态id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 新增动态
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_TREND {
		public static final String METHOD = "jiuwu.trend.insert_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 可见状态为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 内容和图片为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface REPORT_REQUEST {
		public static final String METHOD = "jiuwu.report.add_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 被举报对象ID为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 举报类型或违反的种类为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户ID为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 新增用户建议
	 * 
	 * @author SamFan
	 * 
	 */
	public interface ADD_ADVICE_REQUEST {
		public static final String METHOD = "jiuwu.advice.add_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 举报内容为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户ID为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取所有系统兴趣圈
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_SYSTEM_INTEREST {
		public static final String METHOD = "jiuwu.interest.system.interest.get_";
		/**
		 * 查询数据为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取用户的兴趣圈
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_INTEREST_BY_USER {
		public static final String METHOD = "jiuwu.interest.user.interest.get_";
		/**
		 * 查询记录为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取兴趣圈里的用户
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_USER_BY_INTEREST {
		public static final String METHOD = "jiuwu.interest.userinfo.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 兴趣圈ID为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 性别格式不正确：性别（-1 全部，0女，1男）
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 批量删除用户兴趣关系
	 * 
	 * @author lishun
	 * 
	 */
	public interface DEL_BATCH_USER_INTEREST {
		public static final String METHOD = "jiuwu.interest.batch.user.del_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 兴趣圈ID组为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 兴趣圈ID组中的第{0}个元素为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 删除记录为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 删除用户的兴趣
	 * 
	 * @author lishun
	 * 
	 */
	public interface DEL_USER_INTEREST {
		public static final String METHOD = "jiuwu.interest.user.del_";
		/**
		 * 删除的记录为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 兴趣圈ID为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取热门兴趣
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_HOT_INTEREST {
		public static final String METHOD = "jiuwu.interest.hot.interest.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 保存用户自定义兴趣
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_INTEREST {
		public static final String METHOD = "jiuwu.interest.interest.insert_";
		/**
		 * 兴趣名称超过长度限制
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 兴趣圈名称不能为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 最多只能加入{0}个兴趣圈
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 保存用户兴趣关系
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_USER_INTEREST {
		public static final String METHOD = "jiuwu.interest.user.interest.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 兴趣圈id组不能为空
		 */
		public static final String ERROR_101 = "101";

		/**
		 * 兴趣圈id组的第{0}个元素为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 最多只能加入{0}个兴趣圈
		 */
		public static final String ERROR_103 = "103";

		/**
		 * 用户【{0}】已经加入兴趣【{1}】中
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 根据兴趣圈名称查询兴趣圈
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_INTEREST_BY_NAME {
		public static final String METHOD = "jiuwu.interest.interest.by.name.get_";
		/**
		 * 查询的记录条数为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 兴趣圈名称不能为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 分组系统兴趣圈
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_INTEREST_BY_CLASS {
		public static final String METHOD = "jiuwu.interest.class.system.interest.get_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 查询的结果为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 添加相亲信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface INSERT_MARRY_INFO {
		public static final String METHOD = "jiuwu.interest.marry.info.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 身高不在范围{130-230cm}内
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 收入不在范围{0-5}内
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 学历不在范围{0-6}内
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 婚否不在范围{0-3}内
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 是否有子女不在范围{0-3}内
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 是否有车不在范围{0-3}内
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 是否有房不在范围{0-5}内
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 对方身高格式不正确：格式{165-174}
		 */
		public static final String ERROR_108 = "108";
		/**
		 * 对方年龄格式不正确：格式{22-66}
		 */
		public static final String ERROR_109 = "109";
		/**
		 * 对方学历不在范围{0-6}内
		 */
		public static final String ERROR_110 = "110";
		/**
		 * 对方婚否不在范围{0-3}内
		 */
		public static final String ERROR_111 = "111";
		/**
		 * 对方是否有照片不在范围{0-1}内
		 */
		public static final String ERROR_112 = "112";
		/**
		 * 对方收入不在范围{0-4}内
		 */
		public static final String ERROR_113 = "113";
		/**
		 * 对方是否有房不在范围{0-3}内
		 */
		public static final String ERROR_114 = "114";
		/**
		 * 对方是否有车不在范围{0-3}内
		 */
		public static final String ERROR_115 = "115";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 修改相亲信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface UPDATE_MARRY_INFO {
		public static final String METHOD = "jiuwu.interest.marry.info.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 身高不在范围{130-230cm}内
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 收入不在范围{0-4}内
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 学历不在范围{0-5}内
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 婚否不在范围{0-2}内
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 是否有子女不在范围{0-3}内
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 是否有车不在范围{0-3}内
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 是否有房不在范围{0-4}内
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 对方身高格式不正确：格式{165-174}
		 */
		public static final String ERROR_108 = "108";
		/**
		 * 对方年龄格式不正确：格式{22-66}
		 */
		public static final String ERROR_109 = "109";
		/**
		 * 对方学历不在范围{0-5}内
		 */
		public static final String ERROR_110 = "110";
		/**
		 * 对方婚否不在范围{0-2}内
		 */
		public static final String ERROR_111 = "111";
		/**
		 * 对方是否有照片不在范围{0-1}内
		 */
		public static final String ERROR_112 = "112";
		/**
		 * 对方收入不在范围{0-4}内
		 */
		public static final String ERROR_113 = "113";
		/**
		 * 对方是否有房不在范围{0-2}内
		 */
		public static final String ERROR_114 = "114";
		/**
		 * 对方是否有车不在范围{0-2}内
		 */
		public static final String ERROR_115 = "115";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取相亲信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_MARRY_INFO {
		public static final String METHOD = "jiuwu.interest.marry.info.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 用户【{0}】没有添加相亲资料
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 判断用户是否填写相亲信息
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_MARRY_EXIST {
		public static final String METHOD = "jiuwu.interest.marry.exist.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 用户是否是第一次进入兴趣圈
	 * 
	 * @author lishun
	 * 
	 */
	public interface IS_SELECT_INTEREST {
		public static final String METHOD = "jiuwu.interest.user.first.is_";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取鹊桥里面的用户 getMarryUserList
	 * 
	 * @author lishun
	 * 
	 */
	public interface GET_MARRY_USER {
		public static final String METHOD = "jiuwu.interest.marry.user.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";

		/**
		 * 兴趣id为空
		 * 
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户经度为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户纬度为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 从第几条开始查询为空
		 */
		public static final String ERROR_104 = "104";

		/**
		 * 用户性别格式不正确，格式：{-1,0或1}
		 */
		public static final String ERROR_105 = "105";

		/**
		 * 查询的结果为空
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

		/**
		 * 每页显示的记录
		 */
		public static final Integer PAGE_NUM = 15;

		/**
		 * 最小距离
		 */
		public static final Integer MIN_DISTANCE = 100;
		/**
		 * 最小距离说明
		 */
		public static final String MIN_DISTANCE_SHOW = "100以内";
		/**
		 * 超过最远距离
		 */
		public static final String MAX_DISTANCE_SHOW = "2公里以外";
		/**
		 * 要求不限
		 */
		public static final int ASK_LIMIT = 0;

	}

	/**
	 * 获取鹊桥里面的用户信息 lishun
	 */
	public interface GET_MARRY_USER_BY_USER_ID {
		public static final String METHOD = "jiuwu.interest.marry.user.info.get_";
		/**
		 * otherUserId为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户{0}不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";

		/**
		 * 陌生人
		 */
		public static final String STRANGER_FLAG = "-1";
		/**
		 * 自己
		 */
		public static final String ME_FLAG = "2";
	}

	/**
	 * 实时添加用户坐标至mongodb中
	 */
	public interface ADD_USER_COORDINATE {

		public static final String METHOD = "jiuwu.roam.add_";
		/**
		 * 请求参数为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户经度为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户纬度为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 性别为空
		 */
		public static final String ERROR_104 = "104";
		/** 是否对陌生人可见为空 */
		public static final String ERROR_105 = "105";
		/**
		 * 更新坐标失败
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 更新坐标失败
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 更新坐标失败
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 随机漫游或者定点漫游
	 */
	public interface RANDOM_SET_ROAM {

		public static final String METHOD = "jiuwu.roam.find_";

		/**
		 * 漫游类型，0为随机漫游
		 */
		public static final String ROAM_TYPE_0 = "0";
		/**
		 * 1为附近的人
		 */
		public static final String ROAM_TYPE_1 = "1";

		/**
		 * 2为定点漫游
		 */
		public static final String ROAM_TYPE_2 = "2";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 漫游类型为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 要查询的经度为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 要查询的纬度为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 用户经度为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 用户纬度为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 从第几条开始查询为空
		 */
		public static final String ERROR_107 = "107";
		/**
		 * 随机漫游查询不到用户
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 定点漫游查询不到用户
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 根据兴趣id从mongodb中获取用户
	 */
	public interface GET_USER_MONGODB {

		public static final String METHOD = "jiuwu.interest.mongodb.find_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 兴趣id为空
		 * 
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户经度为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 用户纬度为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 从第几条开始查询为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
		/**
		 * 根据此兴趣没有找到附近的人
		 */
		public static final String ERROR_200 = "200";
	}

	/**
	 * 发表评论或点赞 lishun
	 */
	public interface INSERT_REPLY {

		public static final String METHOD = "jiuwu.trend.reply.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 动态id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 回复状态为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取单条动态 lishun
	 */
	public interface GET_ONE_TREND {

		public static final String METHOD = "jiuwu.trend.onetrend.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 动态id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 官方问答
	 */
	public interface QUESTION_AND_ANSWER {

		public static final String METHOD = "jiwu.assistant.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户的问题为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 根据用户id查看可见动态 lishun
	 */
	public interface GET_USERS_TREND {

		public static final String METHOD = "jiuwu.trend.userstrend.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 查看好友动态类型为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 开始查询条数为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取指定用户动态 lishun
	 */
	public interface GET_USER_TREND {

		public static final String METHOD = "jiuwu.trend.usertrend.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 动态发布者为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 查看动态类型为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 开始查询条数为空
		 */
		public static final String ERROR_104 = "104";
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取单用户最新的一条动态 lishun
	 */
	public interface GET_USER_LASTTREND {

		public static final String METHOD = "jiuwu.trend.lasttrend.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 动态发布者为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取动态封面图册 lishun
	 */
	public interface GET_SYSTREND_COVERS {

		public static final String METHOD = "jiuwu.trend.syscovers.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 更新用户动态封面 lishun
	 */
	public interface UPDATE_TREND_COVER {

		public static final String METHOD = "jiuwu.trend.cover.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 更新类型为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 封面地址为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 封面图片为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取常用设备信息 lishun
	 */
	public interface GET_USER_DEVICE {

		public static final String METHOD = "jiuwu.user.device.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 请求修改手机号 lishun
	 */
	public interface REQUEST_UPDATE_PHONE {

		public static final String METHOD = "jiuwu.userphone.update.request_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 电话号码为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 今天已获取3次验证码，请明天再试
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 30天内已修改过手机号，请稍候再试
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 该手机号已注册
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 一分钟内无法重复发送验证码
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 修改用户设置 lishun
	 */
	public interface UPDATE_USERSETTING {

		public static final String METHOD = "jiuwu.usersetting.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * itemId为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 设置值为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取用户设置 lishun
	 */
	public interface GET_USERSETTING {

		public static final String METHOD = "jiuwu.usersetting.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 显示或取消显示该好友动态 lishun
	 */
	public interface UPDATE_SHOWTREND {

		public static final String METHOD = "jiuwu.showtrend.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友Id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 设置值为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 拉黑及恢复 lishun
	 */
	public interface UPDATE_BLACKLIST {

		public static final String METHOD = "jiuwu.blacklist.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友Id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 设置值为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取用户黑名单 lishun
	 */
	public interface GET_BLACKLIST {

		public static final String METHOD = "jiuwu.blacklist.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	public interface FIND_FRIEND_INFO {
		public static final String METHOD = "jiuwu.friend.findInfo_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友ID为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 好友关系不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 好友信息不存在
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 批量上传照片
	 * 
	 * @author lishun
	 */
	public interface INSERT_BATCH_USER_ALBUM {
		public static final String METHOD = "jiuwu.album.batch.album.insert_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 上传文件为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 文件{0}不是图片类型：请上传图片
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 批量删除照片
	 * 
	 * @author lishun
	 */
	public interface DEL_BATCH_USER_ALBUM {
		public static final String METHOD = "jiuwu.album.batch.album.del_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 照片id组为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 照片id组中第{0}个为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 修改照片的公开性
	 * 
	 * @author lishun
	 */
	public interface UPDATE_BATCH_USER_ALBUM {
		public static final String METHOD = "jiuwu.album.batch.album.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 照片id组为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 照片id组中第{0}个为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 公开性isShow为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 公开性isShow格式不正确：只能是0或1
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}

	public interface FIND_FRIEND_REQUEST {
		public static final String METHOD = "jiuwu.friend.findRequest_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * type错误
		 */
		public static final String ERROR_102 = "102";
		/**
		 * handleRequest错误
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 获取分页的相册
	 */
	public interface GET_USER_ALBUM_BY_PAGE {
		public static final String METHOD = "iuwu.album.page.album.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 记录开始位置为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 禁言
	 * 
	 */
	public interface FORBID_SPEAK {
		public static final String METHOD = "jiuwu.user.forbid_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 存在的用户 0为存在
		 */
		public static final Integer FORBID_EXIT = 0;
		/**
		 * 存在的用户 1为不存在
		 */
		public static final Integer FORBID_NOT_EXIT = 1;
		/**
		 * 用户没有被禁言
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";

	}

	public interface DELETE_FRIEND_REQUEST {
		public static final String METHOD = "jiuwu.friend.request.delete_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 请求ID为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 请求不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	public interface FRIEND_FAVOURITE {
		public static final String METHOD = "jiuwu.friend.favourite_";
		/**
		 * userId为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 好友信息为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 好友信息不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 好友收藏不存在
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}

	/**
	 * 电子围栏消息
	 * 
	 * @author lishun
	 * @create Date 2014-10-21
	 */
	public interface UPLOAD_ELEC_FENCE {
		public static final String METHOD = "jiuwu.router.elec.fence.upload_";
		/**
		 * elecFenceInfo为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * elecFenceInfo格式不正确
		 */
		public static final String ERROR_101 = "101";
		/**
		 * wifiId为空
		 */
		public static final String ERROR_102 = "102";

		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取表情包列表
	 * 
	 * @author lishun
	 * @create Date 2014-10-23
	 */
	public interface GET_EMOJI_GROUP {
		public static final String METHOD = "jiuwu.emojo.group.get_";

		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 获取表情包列表
	 * 
	 * @author lishun
	 * @create Date 2014-10-23
	 */
	public interface GET_EMOJI_DETAIL {
		public static final String METHOD = "jiuwu.emojo.detail.get_";

		/**
		 * 表情包id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";

	}

	public interface GET_SENSITIVE {

		public static final String METHOD = "jiuwu.sensitive.get_";
		/**
		 * 获取敏感词列表为空
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";

	}

	/**
	 * 判断用户是否是第一次进入零工圈
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface USER_SERVICE_EXIST{
		public static final String METHOD = "jiuwu.user.service.exist_";
		
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取服务类别名称
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_SERVICE_NAME{
		public static final String METHOD = "jiuwu.service.name.get_";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取系统服务
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_SYSTEM_SERVICE_LIST{
		public static final String METHOD = "jiuwu.system.service.list.get_";

		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取用户服务
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_SERVICE_LIST{
		public static final String METHOD = "jiuwu.service.list.get_";
		
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 保存用户常用服务
	 * @author lishun
	 *
	 */
	public interface INSERT_SERVICE{
		public static final String METHOD = "jiuwu.service.insert_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_100 = "100";
		
		/**
		 * 服务idList不能为空
		 */
		public static final String ERROR_101 = "101";
		
		/**
		 * 服务idList的第{0}个元素为空
		 */
		public static final String ERROR_102 = "102";
		
		/**
		 * 最多只能加入{0}个常用服务
		 */
		public static final String ERROR_103 = "103";
		
		/**
		 * 用户【{0}】已经添加服务【{1}】
		 */
		public static final String ERROR_200 = "200";
		
		
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 删除用户常用服务
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface DELETE_SERVICE{
		public static final String METHOD = "jiuwu.service.delete_";
		
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 删除用户自定义技能
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface DELETE_DIY_SKILL{
		public static final String METHOD = "jiuwu.diy.skill.delete_";
		
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取10大热门服务
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_HOT_SERVICE_LIST{
		public static final String METHOD = "jiuwu.hot.service.list.get_";
		
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 添加一个自定义服务
	 * @author lishun
	 *
	 */
	public interface INSERT_DIY_SERVICE{
		public static final String METHOD = "jiuwu.service.diy.insert_";
		/**
		 * 服务名称超过长度限制
		 */
		public static final String ERROR_100 = "100";
		
		/**
		 * 服务名称不能为空
		 */
		public static final String ERROR_101 = "101";
		
		/**
		 * 最多只能加入{0}个服务
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 服务名已存在
		 */
		public static final String ERROR_104 = "104";
		
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 添加一个自定义服务
	 * @author lishun
	 *
	 */
	public interface INSERT_DIY_SKILL{
		public static final String METHOD = "jiuwu.skill.diy.insert_";
		/**
		 * 服务名称超过长度限制
		 */
		public static final String ERROR_100 = "100";
		
		/**
		 * 服务名称不能为空
		 */
		public static final String ERROR_101 = "101";
		
		/**
		 * 最多只能加入{0}个服务
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 服务名已存在
		 */
		public static final String ERROR_104 = "104";
		
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 雇主评论订单
	 * @author SamFan
	 * @create Date 2014-12-05
	 */
	public interface COMMENT_ORDER{
		
		public static final String METHOD = "jiuwu.hire.order.comment_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID为空*/
		public static final String ERROR_101 = "101";
		/** 未进行星级评价*/
		public static final String ERROR_102 = "102";
		/** 评价内容为空*/
		public static final String ERROR_103 = "103";
		/** 评价内容超过500字，请缩减*/
		public static final String ERROR_104 = "104";
		/** 雇主未支付定金*/
		public static final String ERROR_200 = "200";
		/** 订单不在评论状态*/
		public static final String ERROR_201 = "201";
		/** 订单不存在*/
		public static final String ERROR_202 = "202";
		/** 接口异常*/
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 雇主发布需求
	 * @author SamFan
	 * @create Date 2014-12-08
	 */
	public interface DEPLOY_DEMAND{
		
		public static final String METHOD = "jiuwu.hire.order.deploy_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 请填写正确的时间*/
		public static final String ERROR_101 = "101";
		/** 请填写正确的地点*/
		public static final String ERROR_102 = "102";
		/** 请填写备注*/
		public static final String ERROR_103 = "103";
		/** 备注过长*/
		public static final String ERROR_104 = "104";
		/** 请输入定金*/
		public static final String ERROR_105 = "105";
		/** 订单类别为空*/
		public static final String ERROR_106 = "106";
		/** 订单来源为空*/
		public static final String ERROR_107 = "107";
		/** 雇员ID为空*/
		public static final String ERROR_108 = "108";
		/** 定金请输入大于0小于100000000的正整数*/
		public static final String ERROR_109 = "109";
		/** 洗衣信息为空 */
		public static final String ERROR_110 = "110";
		/** 家政服务具体内容为空  */
		public static final String ERROR_111 = "111";
	}
	
	/**
	 * 查看雇主单个订单
	 * @author SamFan
	 * @create Date 2014-12-08
	 */
	public interface SINGLE_ORDER{
		
		public static final String METHOD = "jiuwu.hire.order.single.find_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID为空*/
		public static final String ERROR_101 = "101";
		/** 订单不存在，或者已经删除*/
		public static final String ERROR_102 = "102";
		/** 用户ID为空*/
		public static final String ERROR_103 = "103";
		
	}
	
	/**
	 * 查看雇主批量订单
	 * @author SamFan
	 * @create Date 2014-12-08
	 */
	public interface BATCH_ORDER{
		
		public static final String METHOD = "jiuwu.hire.order.batch.find_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 雇主ID为空 */
		public static final String ERROR_101 = "101";
		/** 页号为空 */
		public static final String ERROR_102 = "102";
		
	}
	
	/**
	 * 获取雇主订单链接
	 * @author lishun
	 * @create Date 2015-02-08
	 */
	public interface GET_HIRE_ORDER_LINK{
		
		public static final String METHOD = "jiuwu.hire.order.link.get_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 订单id为空 */
		public static final String ERROR_102 = "102";
		/** 订单不存在 */
		public static final String ERROR_200 = "200";
	}
	
	/**
	 * 拒绝雇主订单
	 * @author SamFan
	 * @create Date 2014-12-08
	 */
	public interface REFUSE_PAYMENT{
		
		public static final String METHOD = "jiuwu.hire.order.payment.refuse_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID为空 */
		public static final String ERROR_101 = "101";
		/** 订单不在确认结算状态 */
		public static final String ERROR_200 = "200";
		/** 订单不存在 */
		public static final String ERROR_201 = "201";
		
	}
	
	/**
	 * 雇主取消订单
	 * @author SamFan
	 * @create Date 2014-12-11
	 */
	public interface CANCEL_ORDER{
		
		public static final String METHOD = "jiuwu.hire.order.cancle_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID 或者 取消来源为空 */
		public static final String ERROR_101 = "101";
		/** 定金退回异常 */
		public static final String ERROR_200 = "200";
		/** 订单状态不正确 */
		public static final String ERROR_201 = "201";
		/** 订单不存在*/
		public static final String ERROR_202 = "202";
		
	}
	
	/**
	 * 雇主确认付款
	 * @author SamFan
	 * @create Date 2014-12-13
	 */
	public interface CONFIRM_PAYMENT{
		
		public static final String METHOD = "jiuwu.hire.order.payment.confirm_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID为空 */
		public static final String ERROR_101 = "101";
		/** 账户余额不足 */
		public static final String ERROR_200 = "200";
		/** 账户异常，支付失败*/
		public static final String ERROR_201 = "201";
		/** 订单异常，支付失败 */
		public static final String ERROR_202 = "202";
		
	}
	
	/**
	 * 获取用户地址
	 * @author SamFan
	 * @create Date 2015-1-7
	 */
	public interface GET_ADDRESS{
		
		public static final String METHOD = "jiuwu.hire.address.get_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 用户ID为空 */
		public static final String ERROR_101 = "101";
		
	}
	
	/**
	 * 雇主重启订单
	 * @author SamFan
	 * @create Date 2014-12-15
	 */
	public interface REOPEN_ORDER{
		
		public static final String METHOD = "jiuwu.hire.order.reopen_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID为空 */
		public static final String ERROR_101 = "101";
		/** 订单状态错误，无法重启 */
		public static final String ERROR_200 = "200";
		
	}
	
	/**
	 * 雇主申请退单
	 * @author SamFan
	 * @create Date 2014-12-15
	 */
	public interface RETUEN_ORDER{
		
		public static final String METHOD = "jiuwu.hire.order.return	_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 订单ID为空 */
		public static final String ERROR_101 = "101";
		
	}
	
	/**
	 * 完善用户信息
	 * @author SamFan
	 * @create Date 2014-12-15
	 */
	public interface COMPLETE_LG_USER_INFO{
		
		public static final String METHOD = "jiuwu.linggong.user.register_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 头像文件为空 */
		public static final String ERROR_101 = "101";
		/** 昵称为空 */
		public static final String ERROR_102= "102";
		/** 昵称过长 */
		public static final String ERROR_103 = "103";
		/** 性别为空 */
		public static final String ERROR_104 = "104";
		/** 性别输入不合法 */
		public static final String ERROR_105 = "105";
		/** 生日为空 */
		public static final String ERROR_106 = "106";
		/** 生日输入不合法 */
		public static final String ERROR_107 = "107";
		/** 手机号 */
		public static final String ERROR_108 = "108";
		/** 密码为空 */
		public static final String ERROR_109 = "109";
		/** 坐标为空 */
		public static final String ERROR_110 = "110";
		/** 地址为空 */
		public static final String ERROR_111 = "111";
		/** 用户已经完善信息*/
		public static final String ERROR_200 = "200";
		
	}

	/**
	 * 修改用户信息
	 * @author lishun
	 * @create Date 2015-2-3
	 */
	public interface UPDATE_LG_USER_INFO{
		
		public static final String METHOD = "jiuwu.linggong.user.update_";
		/** 用户为空 */
		public static final String ERROR_101 = "101";
		/** 昵称过长 */
		public static final String ERROR_102 = "102";
		/** 生日输入不合法 */
		public static final String ERROR_201 = "201";
		/** 用户不存在 */
		public static final String ERROR_202 = "202";
		/** 系统异常*/
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 第一次进入插入零工圈用户信息
	 * @author lishun
	 * @create Date 2015-2-3
	 */
	public interface INSERT_LG_USER_INFO{
		
		public static final String METHOD = "jiuwu.linggong.user.insert_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 用户类别为空 */
		public static final String ERROR_102 = "102";
		/** 手机号 */
		public static final String ERROR_108 = "108";
		/** 密码为空 */
		public static final String ERROR_109 = "109";
		/** 坐标为空 */
		public static final String ERROR_110 = "110";
		/** 系统异常 */
		public static final String ERROR_300= "300";
	}
	
	/**
	 * 是否需要完善资料
	 * @author lishun
	 * @create Date 2015-2-3
	 */
	public interface IS_NEED_COMPLETE{
		
		public static final String METHOD = "jiuwu.is.complete.need_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 没有找到该用户 */
		public static final String ERROR_200 = "200";
		/** 系统异常 */
		public static final String ERROR_300= "300";
	}
	
	/**
	 * 获取零工用户信息
	 * @author lishun
	 * @create Date 2015-2-5
	 */
	public interface GET_LG_USER_INFO{
		
		public static final String METHOD = "jiuwu.linggong.user.get_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 没有找到该用户 */
		public static final String ERROR_200 = "200";
		/** 生日转换异常 */
		public static final String ERROR_201 = "201";
		/** 系统异常 */
		public static final String ERROR_300= "300";
	}
	
	/**
	 * 完善用户信息
	 * @author SamFan
	 * @create Date 2014-12-15
	 */
	public interface CHECK_LG_USER{
		
		public static final String METHOD = "jiuwu.lg.user.check_";
		/** 请求对象为空 */
		public static final String ERROR_100 = "100";
		/** 用户ID为空 */
		public static final String ERROR_101 = "101";
		/** 用户类型为空 */
		public static final String ERROR_102= "102";
		/** 密码为空 */
		public static final String ERROR_103= "103";
		/** 坐标为空 */
		public static final String ERROR_104= "104";
		/** 系统异常 */
		public static final String ERROR_300= "300";
	}
	/**
	 * 搜索服务类别
	 * @author lishun
	 * 
	 */
	public interface FIND_SERVICE{
		public static final String METHOD = "jiuwu.service.find_";
		/**
		 * 查询的记录条数为空
		 */
		public static final String ERROR_200 = "200";
		
		/**
		 * 搜索关键字为空
		 */
		public static final String ERROR_100 = "100";
	
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 根据类别分组系统兴趣
	 * @author lishun
	 */
	public interface GET_SERVICE_BY_CLASS{
		public static final String METHOD = "jiuwu.service.by.class.get_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		
		/**
		 * 查询的结果为空
		 */
		public static final String ERROR_200 = "200";

		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
		
	}
	/**
	 * 雇员接单
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_ORDER{
		
		public static final String METHOD = "jiuwu.employee.order.get_";
		/**
		 * 雇员id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 雇主id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 订单id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 订单状态为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 订单类别为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 订单来源为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 订单不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 雇主订单状态不符
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	/**
	 * 根据用户id查询所有零工订单
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_EMPLOYEE_ORDER{
		
		public static final String METHOD = "jiuwu.employee.order.select_";
		
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	
	/**
	 * 根据订单id查询雇员订单详情
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface QUERY_EMPLOYEE_ORDER{
		
		public static final String METHOD = "jiuwu.employee.order.query_";
		/**
		 * 订单id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	/**
	 * 雇员抢单
	 * @author lishun
	 * @create Date 2014-12-08
	 */
	public interface GRAB_ORDER{
		
		public static final String METHOD="jiuwu.employee.order.grab_";
		/**
		 * 订单id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 抢单备注信息为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 抢单失败
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 此订单不存在
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 此订单无法抢单
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 此订单不支持抢单
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 无法抢单，已存在抢单记录
		 */
		public static final String ERROR_204 = "204";
		/**
		 * 发布雇佣者无法抢单
		 */
		public static final String ERROR_205= "205";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	/**
	 * 雇员退单
	 * @author lishun
	 * @create Date 2014-12-08
	 */
	public interface RETURN_ORDER{
		
		public static final String METHOD="jiuwu.order.return_";
	
	    /**
	     * 被退单人id为空
	     */
		public static final String ERROR_100 = "100";
		/**
		 * 退单人类型
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 订单id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 必须间隔3小时才可以再次申请退单
		 */
		public static final String ERROR_200 = "200";
	}
	/**
	 * 雇员搜索
	 * @author lishun
	 * @create Date 2014-12-08
	 */
	public interface FIND_EMPLOYEE{
		
		public static final String METHOD="jiuwu.employee.find_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 排序方式为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 经度为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 纬度为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 开始查询数为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 用户信息为空
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 分页加载雇员
	 * @author lishun
	 * @create Date 2014-12-08
	 */
	public interface LOAD_EMPLOYEE{
		
		public static final String METHOD="jiuwu.employee.load_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 排序方式为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 经度为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 纬度为空
		 */
		public static final String ERROR_105 = "105";
		/**
		 * 开始查询数为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 用户信息为空
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 新增用户服务资料
	 * @author lishun
	 * @create Date 2014-12-09
	 */
	public interface INSERT_SERVICE_INFO{
		
		public static final String METHOD="jiuwu.service.info.insert_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 该用户信息已存在
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取用户服务资料
	 * @author lishun
	 * @create Date 2014-12-09
	 */
	public interface GET_SERVICE_INFO{
		
		public static final String METHOD="jiuwu.service.info.get_";
		/**
		 * 雇员id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 纬度为空
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取用户服务技能
	 * @author lishun
	 * @create Date 2014-12-09
	 */
	public interface GET_SERVICE_SKILL{
		
		public static final String METHOD="jiuwu.service.skill.get_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	
	/**
	 * 跳转到支付宝支付
	 * @author lishun
	 * @create Date 2014-12-09
	 */
	public interface ALIPAY_API{
		
		public static final String METHOD="jiuwu.service.pay.alipay.api_";
		/**
		 * 订单号不能为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 订单类型不能为空
		 */
		public static final String ERROR_101 = "101";
		
		/**
		 * 商品名称不能为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 支付金额不能为空
		 */
		public static final String ERROR_103 = "103";
		
		/**
		 * 订单类型格式不正确（0|1|2）
		 */
		public static final String ERROR_104 = "104";
		/** 支付金额格式不正确(00.00)*/
		public static final String ERROR_105 = "105";
		/** 支付宝业务错误*/
		public static final String ERROR_200 = "200";
		/**系统异常*/
		public static final String ERROR_300 = "300";

	}

	
	/**
	 * 用户服务技能数验证
	 * @author lishun
	 * @create Date 2014-12-09
	 */
	public interface CHECK_SKILL_COUNT{
		
		public static final String METHOD="jiuwu.skill.count.check_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 添加用户服务技能
	 * @author lishun
	 * @create Date 2014-12-09
	 */
	public interface INSERT_SERVICE_SKILL{
		
		public static final String METHOD="jiuwu.service.skill.insert_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101"; 
		/**
		 * 服务id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 价格为空或价格不合法
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 已添加该技能
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	/**
	 * 雇主或雇员对退单进行确认
	 */
	public interface CONFIRM_RETURN{
		
		public static final String METHOD="jiuwu.return.confirm_";
		/** 退单id为空*/
		public static final String ERROR_100 ="100";
		/** 退单结果为空 */
		public static final String ERROR_101 ="101";
		/** 订单id为空 */
		public static final String ERROR_102 ="102";
		/** 用户类型为空 */
		public static final String ERROR_103 ="103";
	}
	/**
	 * 雇员结算
	 */
	public interface EMPLOYEE_BALANCE{
		
		public static final String METHOD="jiuwu.employee.order.balance_";
		/** 订单id为空*/
		public static final String ERROR_100 = "100";
		/** 雇员请求结算金额为空 */
		public static final String ERROR_101 = "101";
		/** 雇主id为空 */
		public static final String ERROR_102 = "102";
		/** 雇员请求结算金额过长 */
		public static final String ERROR_103 = "103";
		/** 有未处理完的结算，无法请求结算  */
		public static final String ERROR_200 = "200";
	}
	
	/**
	 * 模糊搜索服务类别
	 * @author lishun
	 * @create Date 2014-12-11
	 */
	public interface FIND_SERVICE_TYPE{
		
		public static final String METHOD="jiuwu.service.type.find_";
		/**
		 * 搜索关键字为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 账户
	 * @author mazhengzheng
	 *
	 */
	public interface ACCOUNT_OPER{
		public static final String METHOD = "jiuwu.account.oper_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**身份证不合法*/
		public static final String ERROR_102="102";
		/**身份证不一致*/
		public static final String ERROR_103="103";
		/**账户不存在*/
		public static final String ERROR_201="201";
		/**账户冻结*/
		public static final String ERROR_202="202";
		/**账户状态异常*/
		public static final String ERROR_203="203";
		/**账户身份证已存在*/
		public static final String ERROR_204="204";
	}
	
	/**
	 * 账户-订单
	 * @author mazhengzheng
	 *
	 */
	public interface ACCOUNT_ORDER{
		public static final String METHOD = "jiuwu.account.order_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**订单编号为空*/
		public static final String ERROR_102="102";
		/**流水号为空*/
		public static final String ERROR_103="103";
		/**支付类型错误*/
		public static final String ERROR_104="104";
		/**支付密码为空*/
		public static final String ERROR_105="105";
		/**支付金额不合法*/
		public static final String ERROR_106="106";
		/**支付结果类型不合法*/
		public static final String ERROR_107="107";
		/**目标用户ID为空*/
		public static final String ERROR_108="108";
		/**金额用途不合法*/
		public static final String ERROR_109="109";
		/**账户不存在*/
		public static final String ERROR_200="200";
		/**账户冻结*/
		public static final String ERROR_201="201";
		/**账户余额不足*/
		public static final String ERROR_202="202";
		/**支付密码错误*/
		public static final String ERROR_203="203";
		/**账户状态异常*/
		public static final String ERROR_204="204";
		/**目标账户不存在*/
		public static final String ERROR_205="205";
		/**目标账户状态异常*/
		public static final String ERROR_206="206";
		/**已经支付定金*/
		public static final String ERROR_207="207";
	}
	
	/**
	 * 账户-转账
	 * @author mazhengzheng
	 *
	 */
	public interface ACCOUNT_TRANSFER{
		public static final String METHOD = "jiuwu.account.transfer_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**身份证为空*/
		public static final String ERROR_102="102";
		/**支付密码为空*/
		public static final String ERROR_103="103";
		/**金额不合法*/
		public static final String ERROR_104="104";
		/**卡号不合法*/
		public static final String ERROR_105="105";
		/**卡类型不合法*/
		public static final String ERROR_106="106";
		/**账户不存在*/
		public static final String ERROR_200="200";
		/**账户冻结*/
		public static final String ERROR_201="201";
		/**账户余额不足*/
		public static final String ERROR_202="202";
		/**身份证错误*/
		public static final String ERROR_203="203";
		/**支付密码错误*/
		public static final String ERROR_204="204";
		/**账户状态异常*/
		public static final String ERROR_205="205";
	}
	
	/**
	 * 账户历史
	 * @author mazhengzheng
	 *
	 */
	public interface ACCOUNT_HISTORY{
		public static final String METHOD = "jiuwu.account.history_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**业务类型不合法*/
		public static final String ERROR_102="102";
	}
	
	/**
	 * 银行卡
	 * @author mazhengzheng
	 *
	 */
	public interface BANK_ACCOUNT{
		public static final String METHOD = "jiuwu.bank.account_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**卡类型不合法*/
		public static final String ERROR_102="102";
		/**卡号不合法*/
		public static final String ERROR_103="103";
		/**所属行为空*/
		public static final String ERROR_104="104";
		/**卡ID为空*/
		public static final String ERROR_105="105";
		/**账号或卡号已存在*/
		public static final String ERROR_201="201";
	}
	
	/**
	 * 删除订单
	 * @author lishun
	 */
	public interface DELETE_ORDER{
		
		public static final String METHOD = "jiuwu.order.delete_";
		/** 订单id为空*/
		public static final String ERROR_100 = "100";
		/** 要删除的订单类型为空 */
		public static final String ERROR_101 = "101";
		/** 要删除的订单不存在 */
		public static final String ERROR_200 = "200";
		/** 订单还没处理完，无法删除*/
		public static final String ERROR_201 = "201";
		
	}
	
	/**
	 * 判断用户是否添加了该服务
	 * @author lishun
	 */
	public interface CHECK_SERVICE{
		
		public static final String METHOD = "jiuwu.user.service.check_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 服务id为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 判断用户是否添加了该技能
	 * @author lishun
	 */
	public interface CHECK_SKILL{
		
		public static final String METHOD = "jiuwu.user.skill.check_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 服务id为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 判断用户是否是第一次进入打零工
	 * @author lishun
	 */
	public interface SERVICE_INFO_EXIST{
		
		public static final String METHOD = "jiuwu.service.info.exist_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 完善资料第一次进入打零工初始化用户服务资料
	 * @author lishun
	 */
	public interface SERVICE_INFO_INSTALL{
		
		public static final String METHOD = "jiuwu.service.info.install_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 获取用户手机号
	 * @author lishun
	 */
	public interface GET_PHONE_NUM{
		
		public static final String METHOD = "jiuwu.user.phone.get_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 获取用户昵称
	 * @author lishun
	 */
	public interface GET_NICKNAME{
		
		public static final String METHOD = "jiuwu.user.nickname.get_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 删除服务技能
	 * @author lishun
	 */
	public interface DELETE_SERVICE_SKILL{
		
		public static final String METHOD = "jiuwu.service.skill.delete_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 服务id为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 获取用户服务资料
	 * @author lishun
	 */
	public interface GET_USER_SERVICE_INFO{
		
		public static final String METHOD = "jiuwu.user.service.info.get_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 获取用户服务资料
	 * @author lishun
	 */
	public interface GET_USER_SERVICE_INFO_BY_ID{
		
		public static final String METHOD = "jiuwu.user.service.info.get.by.id_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 服务资料id为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 请求修改服务手机号 lishun
	 */
	public interface REQUEST_UPDATE_SERVICE_PHONE {

		public static final String METHOD = "jiuwu.service.phone.update.request_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 电话号码为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 今天已获取3次验证码，请明天再试
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 30天内已修改过手机号，请稍候再试
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 一分钟内无法重复发送验证码
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 验证手机号修改时间 lishun
	 */
	public interface CHECKPHON_PHONE_UPDATE_TIME {

		public static final String METHOD = "jiuwu.phone.update.time.check_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 30天内已修改过手机号，请稍候再试
		 */
		public static final String ERROR_104 = "104";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 修改用户服务手机号
	 * 
	 * @author lishun
	 * 
	 */
	public interface UPDATE_SERVICE_PHONE {
		public static final String METHOD = "jiuwu.service.phone.update_";
		/**
		 * 请求对象为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 手机号为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 验证码为空
		 */
		public static final String ERROR_103 = "103";
		/**
		 * 验证码错误
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 验证码已超时失效
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 验证码已使用
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 30天内已修改过手机号，请稍候再试
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 系统异常
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 修改用户服务资料
	 * @author lishun
	 */
	public interface UPDATE_USER_SERVICE_INFO{
		
		public static final String METHOD = "jiuwu.service.info.update_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 根据id修改用户服务资料
	 * @author lishun
	 */
	public interface UPDATE_USER_SERVICE_INFO_BY_ID{
		
		public static final String METHOD = "jiuwu.service.info.update.by.id_";

		/** 资料id为空 */
		public static final String ERROR_101 = "101";
		/** 是否提交为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 提交用户服务资料
	 * @author lishun
	 */
	public interface SUBMIT_SERVICE_INFO{
		
		public static final String METHOD = "jiuwu.service.info.submit_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 资料id为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 我的零工圈信息显示
	 * @author lishun
	 */
	public interface GET_MY_SERVICE_INFO{
		
		public static final String METHOD = "jiuwu.my.service.info.get_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 账户信息为空 */
		public static final String ERROR_102 = "102";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 收藏及取消收藏
	 * @author lishun
	 */
	public interface COLLECT_EMPLOYEE{
		
		public static final String METHOD = "jiuwu.employee.collect_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 雇员id为空 */
		public static final String ERROR_102 = "102";
		/** 收藏or取消收藏为空 */
		public static final String ERROR_103 = "103";
		/** 该用户已从收藏夹移除 */
		public static final String ERROR_201 = "201";
		/** 该用户已在收藏夹中 */
		public static final String ERROR_202 = "202";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 收藏及取消收藏
	 * @author lishun
	 */
	public interface COLLECT{
		
		public static final String METHOD = "jiuwu.agent.collect_";

		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 收藏id为空 */
		public static final String ERROR_102 = "102";
		/** 收藏or取消收藏为空 */
		public static final String ERROR_103 = "103";
		/** 收藏类型为空 */
		public static final String ERROR_104 = "104";
		/** 服务类型为空 */
		public static final String ERROR_105 = "105";
		/** 已取消收藏 */
		public static final String ERROR_201 = "201";
		/** 已收藏 */
		public static final String ERROR_202 = "202";
		/** 系统异常 */
		public static final String ERROR_300 = "300";
		
	}
	
	/**
	 * 获取收藏雇员列表
	 * @author lishun
	 * @create Date 2014-12-22
	 */
	public interface GET_COLLECTION{
		
		public static final String METHOD="jiuwu.collection.get_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 入口方式为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 开始查询数为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 用户信息为空
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取家政职员收藏列表
	 * @author lishun
	 * @create Date 2015-3-17
	 */
	public interface GET_STAFF_COLLECTION{
		
		public static final String METHOD="jiuwu.staff.collection.get_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 每页加载条数位空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 页数为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取洗护店铺收藏列表
	 * @author lishun
	 * @create Date 2015-3-17
	 */
	public interface GET_STORE_COLLECTION{
		
		public static final String METHOD="jiuwu.store.collection.get_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 每页加载条数位空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 页数为空
		 */
		public static final String ERROR_106 = "106";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取收藏雇员服务资料
	 * @author lishun
	 * @create Date 2014-12-22
	 */
	public interface GET_COLLECTION_DETAILS{
		
		public static final String METHOD="jiuwu.collection.details.get_";
		/**
		 * 雇员id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_102 = "102";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取服务建议价格
	 * @author lishun
	 * @create Date 2014-12-25
	 */
	public interface GET_SUGGESTED_PRICE{
		
		public static final String METHOD="jiuwu.suggested.price.get_";
		/**
		 * 服务id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 分页获取推送的消息
	 * @author lishun
	 * @create Date 2014-12-25
	 */
	public interface GET_PUSH_MESSAGE_LIST{
		public static final String METHOD="jiuwu.service.push.get_";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 修改消息为已读
	 * @author lishun
	 * @create Date 2014-12-25
	 */
	public interface UPDATE_ALREADY_READ{
		public static final String METHOD="jiuwu.service.push.already.update_";
		/**
		 * 通知Id不能为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 删除消息
	 * @author lishun
	 * @create Date 2014-12-25
	 */
	public interface DELETE_MESSAGE{
		public static final String METHOD="jiuwu.service.message.delete_";
		/**
		 * 订单Id不能为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	/**
	 * 获取未读消息的数量
	 * @author lishun
	 * @create Date 2014-12-25
	 */
	public interface GET_ALREADY_READ_NUM{
		public static final String METHOD="jiuwu.service.push.already.get_";
		
		/**
		 * 系统错误
		 */
		public static final String ERROR_300 = "300";
	}
	/**
	 *雇员通过分类找雇主
	 * @author lishun
	 * @create Date 2014-12-25
	 */
	public interface FIND_HIRE_BY_TYPE{
		public static final String METHOD="jiuwu.order.find.hire_";
		
		/**
		 * 系统错误
		 */
		public static final String ERROR_100 = "类别为空";
	}
	
	/**
	 * 获取零工用户的所有评论
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_EMPLOYEE_COMMENT{
		
		public static final String METHOD = "jiuwu.order.employee.get.comment_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 当前用户不是一个零工用户
		 */
		public static final String ERROR_200 = "200";
	}
	/**
	 * 判断用户是否可以抢单
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface JUDGE_EMPLOYEE_CAN_DRAG{
		
		public static final String METHOD = "jiuwu.order.employee.can.drag_";
		/**
		 * 用户id为空
		 */
		public static final String ERROR_100 = "100";
		/**
		 * 订单id为空
		 */
		public static final String ERROR_101 = "101";
		/**
		 * 此订单不存在
		 */
		public static final String ERROR_200 = "200";
		/**
		 * 此订单无法抢单
		 */
		public static final String ERROR_201 = "201";
		/**
		 * 不能重复抢单
		 */
		public static final String ERROR_202 = "202";
		/**
		 * 此订单不支持抢单
		 */
		public static final String ERROR_203 = "203";
		/**
		 * 发布雇佣者无法抢单
		 */
		public static final String ERROR_204 = "204";
		
	}
	
	/**
	 * 职员
	 * @author mazhengzheng
	 */
	public interface AGENT_STAFF{
		public static final String METHOD = "jiuwu.agent.staff.oper_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**技能ID为空*/
		public static final String ERROR_102="102";
		/**订单ID为空*/
		public static final String ERROR_103="103";
		/**职员ID为空*/
		public static final String ERROR_104="104";
		/**技能不合法*/
		public static final String ERROR_201="201";
		/**状态不合法*/
		public static final String ERROR_202="202";
		/**用户不存在*/
		public static final String ERROR_203="203";
		//代理商没权限
		public static final String ERROR_204="204";
	}
	
	/**
	 * 根据职员ID获取职员详细信息
	 * @author lishun
	 */
	public interface GET_STAFF_DETAIL_BY_ID{
		public static final String METHOD = "jiuwu.staff.detail.get_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**职员ID为空*/
		public static final String ERROR_102="102";
		/**职员信息不存在*/
		public static final String ERROR_200="200";
		/**系统异常*/
		public static final String ERROR_300="300";
	}
	
	/**
	 * 获取洗护店铺信息
	 * @author lishun
	 */
	public interface GET_STORE_DETAIL_BY_ID{
		public static final String METHOD = "jiuwu.store.detail.get_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**店铺ID为空*/
		public static final String ERROR_102="102";
		/**店铺信息不存在*/
		public static final String ERROR_200="200";
		/**系统异常*/
		public static final String ERROR_300="300";
	}
	
	/**
	 * 判通过服务id来查询对于的商户(闪电派单)
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface FIND_BUSSINESS_BY_SERVICEID{
		
		public static final String METHOD = "jiuwu.shandian.select.bussiness_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 服务类别为空  */
		public static final String ERROR_101 = "101";
		
		
	}
	/**
	 * 通过服务大类id来查询下面的小类(闪电)
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface SELECT_LIST_BY_SERVICEID{
		
		public static final String METHOD = "jiuwu.shandian.select.service_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 服务类别为空  */
		public static final String ERROR_101 = "101";
		
		
	}
	/**
	 * 通过服务大类id来查询下面的小类(闪电)
	 * @author lishun
	 * @create Date 2014-12-05
	 */
	public interface GET_SERVICE_WASH{
		
		public static final String METHOD = "jiuwu.shandian.service.wash.get_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 服务类别为空  */
		public static final String ERROR_101 = "101";
		
		
	}
	/**
	 * 获取商家下面服务人员的详情
	 * @author lishun
	 * @create Date 2015.02.06
	 */
	public interface GET_BUSSINESS_SERVICE_INFO{
		
		public static final String METHOD = "jiuwu.shandian.get.serviceinfo_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 订单id为空  */
		public static final String ERROR_101 = "101";
		/** 订单不存在  */
		public static final String ERROR_200 = "200";
		/** 服务商家服务人员信息失败   */
		public static final String ERROR_201 = "201";
		/** 此订单没有具体服务人员   */
		public static final String ERROR_202 = "202";
	}
	/**
	 * 获取商家下面服务人员的详情
	 * @author lishun
	 * @create Date 2015.02.06
	 */
	public interface GET_WASH_INFO{
		
		public static final String METHOD = "jiuwu.shandian.select.wash_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 衣服信息为空  */
		public static final String ERROR_101 = "101";
		/** 代理商为空  */
		public static final String ERROR_102 = "102";
	}
	/**
	 * 获取用户未完成订单的数量
	 * @author lishun
	 * @create Date 2015.02.06
	 */
	public interface GET_NO_COMPLETE_INFO{
		
		public static final String METHOD = "jiuwu.linggong.order.nocomplete_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 当前用户不是零工用户 */
		public static final String ERROR_200 = "200";
		
	}
	/**
	 * 修改订单信息
	 * @author lishun
	 * @create Date 2015.02.06
	 */
	public interface UPDATA_ORDER_INFO{
		
		public static final String METHOD = "jiuwu.linggong.order.update_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 订单不存在 */
		public static final String ERROR_200 = "200";
		
		
	}
	/**
	 * 删除服务地址
	 * @author lishun
	 * @create Date 2015.03.06
	 */
	public interface DELETE_SERVICE_ADDRESS{
		
		public static final String METHOD = "jiuwu.linggong.address.delete_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 此服务地址不存在*/
		public static final String ERROR_200 = "200";
		
		
	}
	
	/**
	 * 微信
	 * @author mazhnegzhneg
	 *
	 */
	public interface WEIXIN_AUTH{
		public static final String METHOD = "jiuwu.linggong.weixin.auth_";
		/**电话为空*/
		public static final String ERROR_100 = "100";
		/**密码为空*/
		public static final String ERROR_101 = "101";
		/**验证码为空*/
		public static final String ERROR_102 = "102";
		/**类型错误*/
		public static final String ERROR_103 = "103";
		/**微信opendId为空*/
		public static final String ERROR_104 = "104";
		/**用户不存在*/
		public static final String ERROR_200 = "200";
		/**密码错误*/
		public static final String ERROR_201 = "201";
		/**用户已存在*/
		public static final String ERROR_202 = "202";
		/**用户已删除*/
		public static final String ERROR_203 = "203";
		/**用户为非普通用户*/
		public static final String ERROR_204 = "204";
		/**用户名或密码错误*/
		public static final String ERROR_205 = "205";
		/**该手机号已被注册*/
		public static final String ERROR_206 = "206";
		/**该账户已被其它微信号绑定*/
		public static final String ERROR_207 = "207";
	}
	
	/**
	 * 获取评论
	 * @author lishun
	 */
	public interface GET_COMMENT{
		public static final String METHOD = "jiuwu.agent.comment.get_";
		/**用户ID为空*/
		public static final String ERROR_101="101";
		/**评论类别为空*/
		public static final String ERROR_102="102";
		/**开始查询条数为空*/
		public static final String ERROR_103="103";
		/**错误的评论类别*/
		public static final String ERROR_201="201";
		/**系统异常*/
		public static final String ERROR_300="300";
	}
	
	public interface GET_AGENT_STAFF_LIST{
		public static final String METHOD = "jiuwu.linggong.agent.staff.list.get_";
		/**经度不能为空*/
		public static final String ERROR_100="100";
		/**维度不能为空*/
		public static final String ERROR_101="101";
	}
	
	public interface PUSH_AGENT_MESSAGE{
		public static final String METHOD = "jiuwu.linggong.agent.message.get_";
		/**订单号不能为空*/
		public static final String ERROR_100="100";
		
	}
	
	/**
	 * 系统分配洗护代理商
	 * @author lishun
	 * @create Date 2015-03-25
	 */
	public interface GET_AGENT_STORE{
		
		public static final String METHOD = "jiuwu.agent.store.get_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 服务类别id为空 */
		public static final String ERROR_102 = "102";
		/** 服务地址为空 */
		public static final String ERROR_103 = "103";
		/** 无法识别服务地址 */
		public static final String ERROR_104 = "104";
		/** 附近没有合适的店铺 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 通过手机号搜索好友
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface FIND_FRIEND_BY_PHONE{
		
		public static final String METHOD = "jiuwu.daboo.friend.find.by.phone_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 手机号为空 */
		public static final String ERROR_102 = "102";
		/** 用户不存在 */
		public static final String ERROR_200 = "200";
		/** 好友信息不存在 */
		public static final String ERROR_201 = "201";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 通过ID获取好友资料
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface GET_FRIEND_BY_ID{
		
		public static final String METHOD = "jiuwu.daboo.friend.get.by.id_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 好友id为空 */
		public static final String ERROR_102 = "102";
		/** 用户不存在 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 通过ID获取用户资料
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface QUERY_USER_INFO_BY_ID{
		
		public static final String METHOD = "jiuwu.daboo.user.info.query.by.id_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 查询用户id为空 */
		public static final String ERROR_102 = "102";
		/** 用户不存在 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 根据用户id获取附近的热聊
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface GET_HOT_CHAT{
		
		public static final String METHOD = "jiuwu.db.get.hotchat_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 经度为空 */
		public static final String ERROR_101 = "101";
		/** 纬度为空 */
		public static final String ERROR_102 = "102";
		/** 页码为空 */
		public static final String ERROR_103 = "103";
		/** 类型为空 */
		public static final String ERROR_104 = "104";
		/** 页码必须大于或等于1*/
		public static final String ERROR_200 = "200";
		/** 用户不存在*/
		public static final String ERROR_201 = "201";
	}
	
	/**
	 * 添加用户收藏热聊
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface ADD_USER_GROUP{
		
		public static final String METHOD = "jiuwu.daboo.user.group.add_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 热聊id为空 */
		public static final String ERROR_102 = "102";
		/** 保存热聊失败 */
		public static final String ERROR_200 = "200";
		/** 获取热聊信息失败 */
		public static final String ERROR_201 = "201";
		/** 已添加 */
		public static final String ERROR_202 = "202";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取用户收藏热聊列表
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface GET_USER_GROUP{
		
		public static final String METHOD = "jiuwu.daboo.user.group.get_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 暂无收藏热聊 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 删除用户收藏热聊
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface DELETE_USER_GROUP{
		
		public static final String METHOD = "jiuwu.daboo.user.group.delete_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 热聊id为空 */
		public static final String ERROR_102 = "102";
		/** 删除热聊失败 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	/**
	 * 搜索好友(好友内模糊搜索)
	 * @author lishun
	 * @create Date 2015-04-13
	 */
	public interface FIND_FRIEND{
		
		public static final String METHOD = "jiuwu.daboo.friend.find_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 查询关键字为空 */
		public static final String ERROR_102 = "102";
		/** 无查询数据 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 大博智家
	 * @author mazhengzheng
	 */
	public interface DB_DEVICE{
		
		public static final String METHOD = "jiuwu.daboo.device_";
		/** 定时类型错误 */
		public static final String ERROR_101 = "101";
		/** 参数为空 */
		public static final String ERROR_102 = "102";
		/** 设备不存在 */
		public static final String ERROR_201 = "201";
		/** 用户不存在 */
		public static final String ERROR_202 = "202";
		/** 定时不存在 */
		public static final String ERROR_203 = "203";
		/** 报警不存在 */
		public static final String ERROR_204 = "204";
		/** 分享不存在 */
		public static final String ERROR_205 = "205";
		/** 设备已绑定 */
		public static final String ERROR_206 = "206";
		/** 分享已存在 */
		public static final String ERROR_207 = "207";
		/** 设备未录入 */
		public static final String ERROR_208 = "208";
		/** 分享用户为自身 */
		public static final String ERROR_209 = "209";
	}
	
	/**
	 * 获取用户加入热聊列表
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface GET_USER_GROUP_LIST{
		
		public static final String METHOD = "jiuwu.daboo.user.group.list.get_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 暂未加入热聊 */
		public static final String ERROR_200 = "200";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 获取用户加入热聊列表
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface SEND_GIFT{
		
		public static final String METHOD = "jiuwu.daboo.gift.send_";
		/** 商户bid为空 */
		public static final String ERROR_100 = "100";
	}
	
	/**
	 * 获取热聊的活跃成员
	 * @author lishun
	 * @create Date 2015-04-15
	 */
	public interface GET_ACTIVE_USER{
		
		public static final String METHOD = "jiuwu.db.get.active.user_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 经度为空 */
		public static final String ERROR_101 = "101";
		/** 纬度为空 */
		public static final String ERROR_102 = "102";
		/** 群聊id为空 */
		public static final String ERROR_103 = "103";
		/** 此热聊不存在 */
		public static final String ERROR_200 = "200";
	}
	/**
	 * 获取热聊的活跃成员
	 * @author lishun
	 * @create Date 2015-04-15
	 */
	public interface GET_BUSINESS_NUM{
		
		public static final String METHOD = "jiuwu.db.get.business.people_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 店铺id为空  */
		public static final String ERROR_101 = "101";
	}
	/**
	 * 根据用户id和热聊类别获取附近的热聊
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface GET_NEAR_HOT_CHAT{
		
		public static final String METHOD = "jiuwu.db.get.near.hotchat_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 经度为空 */
		public static final String ERROR_101 = "101";
		/** 纬度为空 */
		public static final String ERROR_102 = "102";
		/** 页码为空 */
		public static final String ERROR_103 = "103";
		/** 类型为空 */
		public static final String ERROR_104 = "104";
		/** 页码必须大于或等于1*/
		public static final String ERROR_200 = "200";
		/** 用户不存在*/
		public static final String ERROR_201 = "201";
	}
	/**
	 * 根据热聊名称搜索热聊（模糊查询）
	 * @author lishun
	 * @create Date 2015-04-09
	 */
	public interface GET_CHAT_SEARCH_NAME{
		
		public static final String METHOD = "jiuwu.db.get.hotchat.search_";
		/** 用户id为空 */
		public static final String ERROR_100 = "100";
		/** 名称为空  */
		public static final String ERROR_101 = "101";
		
	}
	/**
	 * 获取推荐的商户信息
	 * @author lishun
	 * @create Date 2015-06-02
	 */
	public interface GET_RECOMMENT_BUSINESS{
		
		public static final String METHOD = "jiuwu.db.recomment.business_";
		/** rmac为空  */
		public static final String ERROR_100 = "100";
		/** 经度为空 */
		public static final String ERROR_101 = "101";
		/** 经度为空 */
		public static final String ERROR_102 = "102";
		/** 城市为空 */
		public static final String ERROR_103 = "103";
		/** 获取商户信息失败  */
		public static final String ERROR_200 = "200";
		
	}
	/**
	 * 附近的人
	 * @author lishun
	 * @create Date 2015-06-02
	 */
	public interface GET_NEAR_PEOPLE{
		
		public static final String METHOD = "jiuwu.db.near.people_";
		/** 经度为空 */
		public static final String ERROR_100 = "100";
		/** 经度为空 */
		public static final String ERROR_101 = "101";
		
		
	}
	/**
	 * 搜索附近的活跃成员
	 * @author lishun
	 * @create Date 2015-06-02
	 */
	public interface SEARCH_NEAR_PEOPLE{
		
		public static final String METHOD = "jiuwu.db.near.people.search_";
		/** 经度为空 */
		public static final String ERROR_100 = "100";
		/** 经度为空 */
		public static final String ERROR_101 = "101";
		/** 热聊id为空  */
		public static final String ERROR_102 = "102";
		/** 此热聊不存在  */
		public static final String ERROR_200 = "200";
		
	}
	/**
	 * 获取商户信息
	 * @author lishun
	 * @create Date 2015-06-10
	 */
	public interface GET_BUSINESS_INFO{
		
		public static final String METHOD = "jiuwu.db.get.businessInfo_";
		/** 商户id为空 */
		public static final String ERROR_100 = "100";
		/** 没有获取到商户信息 */
		public static final String ERROR_200 = "200";
		
		
	}
	
	/**
	 * 更新用户坐标
	 * @author lishun
	 * @create Date 2015-06-1
	 */
	public interface UPDATE_USER_LOC{
		
		public static final String METHOD = "jiuwu.daboo.user.loc.update_";
		/** 用户id为空 */
		public static final String ERROR_101 = "101";
		/** 坐标信息为空 */
		public static final String ERROR_102 = "102";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
	
	/**
	 * 检测是否需要强制更新
	 * @author lishun
	 * @create Date 2015-06-15
	 */
	public interface CHECK_UPDATE{
		
		public static final String METHOD = "jiuwu.app.update.check_";
		/** 设备类型为空 */
		public static final String ERROR_101 = "101";
		/** app版本号为空 */
		public static final String ERROR_102 = "102";
		/** appKey为空 */
		public static final String ERROR_103 = "103";
		/** 设备类型不匹配 */
		public static final String ERROR_104 = "104";
		/** 未找到对应的app信息 */
		public static final String ERROR_201 = "201";
		/** 系统错误 */
		public static final String ERROR_300 = "300";
	}
}
