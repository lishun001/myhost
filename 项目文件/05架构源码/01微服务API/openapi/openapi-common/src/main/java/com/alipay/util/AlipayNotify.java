package com.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.alipay.config.AlipayConfig;
import com.alipay.sign.RSA;

/* *
 *类名：AlipayNotify
 *功能：支付宝通知处理类
 *详细：处理支付宝各接口通知返回
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考

 *************************注意*************************
 *调试通知返回时，可查看或改写log日志的写入TXT里的数据，来检查通知返回是否正常
 */
public class AlipayNotify {

    /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);

        //写日志记录（若要调试，请取消下面两行注释）
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        if(AlipayConfig.sign_type.equals("RSA")){
        	isSign = RSA.verify(preSignStr, sign, AlipayConfig.ali_public_key, AlipayConfig.input_charset);
        }
        return isSign;
    }

    /**
    * 获取远程服务器ATN结果,验证返回URL
    * @param notify_id 通知校验ID
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String verifyResponse(String notify_id) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

        String partner = AlipayConfig.partner;
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(veryfy_url);
    }

    /**
    * 获取远程服务器ATN结果
    * @param urlvalue 指定URL路径地址
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
    public static void main(String[] args) {
//    	{buyer_id=2088302316998674, trade_no=2015091800001000670061318420, body=0.01元验证, use_coupon=N, notify_time=2015-09-18 14:26:43, subject=开通猎人服务, 
//    	sign_type=RSA, is_total_fee_adjust=Y, notify_type=trade_status_sync, out_trade_no=userPay1509181426370001, trade_status=WAIT_BUYER_PAY, discount=0.00, 
//    			sign=OTDuiqzYB8vFuT+n4yuLPMI3gekulLlPawLn56QDaVL0xQ6yi4/vjOAKFw32gDhIn3ZuZ2AwPP+uuraNTAHQJ1hF0YXhWzMErIzNtSz61sJJLTKfpRlLutgJfh/+GYcuoFXTB5ZjdPA14Eas+VuVDf+a2ob+iEVOSA7BhaJc2qk=, 
//    			buyer_email=411878157@qq.com, gmt_create=2015-09-18 14:26:43, price=0.01, total_fee=0.01, quantity=1, seller_id=2088021387460555, 
//    			notify_id=56159792b8fbc6de5b8e1bf8d7ba63975q, seller_email=awesomemedia@163.com, payment_type=1}

    	HashMap<String,String> map=new HashMap<String,String>();
    	map.put("buyer_id", "2088421357555256");
    	map.put("trade_no", "2015091800001000670061318420");
    	map.put("body", "0.01元验证");
    	map.put("use_coupon", "N");
    	map.put("notify_time", "2015-09-18 14:26:43");
    	map.put("subject", "开通猎人服务");
    	map.put("sign_type", "RSA");
    	map.put("is_total_fee_adjust", "Y");
    	map.put("notify_type", "trade_status_sync");
    	map.put("out_trade_no", "userPay1509181426370001");
    	map.put("gmt_payment", "2015-09-18 14:26:43");
    	map.put("trade_status", "WAIT_BUYER_PAY");
    	map.put("discount", "0.00");
    	map.put("sign", "OTDuiqzYB8vFuT+n4yuLPMI3gekulLlPawLn56QDaVL0xQ6yi4/vjOAKFw32gDhIn3ZuZ2AwPP+uuraNTAHQJ1hF0YXhWzMErIzNtSz61sJJLTKfpRlLutgJfh/+GYcuoFXTB5ZjdPA14Eas+VuVDf+a2ob+iEVOSA7BhaJc2qk=");
    	map.put("buyer_email", "411878157@qq.com");
    	map.put("gmt_create", "2015-09-18 14:26:43");
    	map.put("price", "0.01");
    	map.put("total_fee", "0.01");
    	map.put("quantity", "1");
    	map.put("seller_id", "2088021387460555");
    	map.put("notify_id", "56159792b8fbc6de5b8e1bf8d7ba63975q");
    	map.put("seller_email", "xiaoxuelenglian@163.com");
    	map.put("payment_type", "1");
    	System.out.println(AlipayNotify.verify(map));
	}
}
