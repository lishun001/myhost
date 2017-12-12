package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088421357555256";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串
	public static String seller_id = partner;
	// 商户的私钥
	public static String private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAL9TCNZVc77drm6lCwsVEgIaJn9lv66HUAcKDGU0+xKaElqThwVxEXA7BcmnE7sWvUsaX6Y4X47ecTnh81D3MwYxzac3546XxcEIQfVNb/Ovznl/U/e2kUYm4Im2G8ktyZXNsY/NyOQ1fDYZVE+R+q/x+cQqFdK6nO5HQ6Vli8EvAgMBAAECgYEAg4rQgaTA7tK1smcRH6598ioOm/rV/mYUNLLI8PCrSw/ZXKMf6zLhHXvHL+0KmNA6l59rcfpCYRU5XeWnB9zeG8wOH97yNJNc+AziilI7sB5CiD5Iw4NIyckmOxdcNG6BKZVfArlU9y0FlTfSr//l6uJcvyMYvJPmNXvQ6jiZbJECQQDuNg40Hf3R1kmNg7JtTvaGh7FiSEBkoX/u7IgRXiE2UYeF9U5tPHAhYJACoojsJwzI0eSM4MnMsQcsWeLF91vJAkEAzZyhw4kYYswANbdOVKBxwBeg6Z4JfBpBB2e4DGiMoRXBSEWQWlcxVrf0h60UE6e0OemUUCxZjROumO5OINFBNwJBAKA8FEnScs4Xyto6YGdO2l2cISHvYAFQ8XGSAeVM4CJdrT/axqqMIRESl0xucJQJoHvlVEu/WX8rBZw7ymNIBKECQChO/KeIyO8VbzUYqpKMocA24aTrBpD91KHPA5XrKSarTSkN+i67yUBm79lpZPY1em+gCyNsjmHJ6gCxNz/XxiECQQDTxib+WMmZNTADDn0619H0B2SOncz8C0SZVWPXqFtC+f3JZJMQaJg+NE2YKIM6YK/HZyjlDKstZ4NY0wz8nTfB";
	
	// 支付宝的公钥，无需修改该值                                                                  
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";
	
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	
	// 交易安全检验码，由数字和字母组成的32位字符串
	// 如果签名方式设置为“MD5”时，请设置该参数
	public static String key = "oqqjiscz35h6pqlyo5ykpkaygqtanjm5";
	
	public static String seller_email="xiaoxuelenglian@163.com";
	
	

}
