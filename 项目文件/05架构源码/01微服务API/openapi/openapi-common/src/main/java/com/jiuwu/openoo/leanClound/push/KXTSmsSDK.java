/*
 *  Copyright (c) 2016 The KXTSMS project authors. All Rights Reserved.
 *
 * 说明：
 * 以下代码只是为了方便客户测试而提供的样例代码，客户可以根据自己网站的需要，按照技术文档自行编写,并非一定要使用该代码。
 * 该代码仅供学习和研究使用，只是提供一个参考。
 */
package com.jiuwu.openoo.leanClound.push;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

public class KXTSmsSDK {
	private String address = null;
    private int port = 0;
    private String account = null;
    private String token = null;
	private int userId = 0;
    /**
     * 初始化必须参数
     * 
     * @param address
     *			必选参数，服务器地址 不带 http://
     * @param port
     *			必选参数，服务器点端口号
     * @param account
     * 			必选参数，账号
	 * @param token
     * 			必选参数，密码
	 * @param userId
     * 			必选参数，用户Id
     * */
    public void init(String address, int port, String account, String token,int userId)
    {
        this.address = address;
        this.port = port;
        this.account = account;
        this.token = token;
		this.userId = userId;
    }
    /**
     * 发送短信
     * @param mobile
     * 			手机号码
     * @param body
     * 			短信内容
     * @return 
     * */
    public String send( String mobile, String body)
    {
        String uriStr = MessageFormat.format("http://{0}:{1}/sms.aspx", address,String.valueOf(port));
        return getResponse(uriStr,MessageFormat.format("action=send&userid={0}&account={1}&password={2}&mobile={3}&content={4}",userId,account, token, mobile, body));
    }
    /**
     * 获取请求数据
     * 
     * @param uriStr
     * 			请求路径
     * @param param
     * 			请求参数
     * @return 
     * */
    private String getResponse(String uriStr, String param) 
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(uriStr);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setConnectTimeout(50000);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if(out != null){
                    out.close();
                }
                if(in != null){
                    in.close();
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
