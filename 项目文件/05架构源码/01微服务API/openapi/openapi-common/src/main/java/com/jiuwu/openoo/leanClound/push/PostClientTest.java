package com.jiuwu.openoo.leanClound.push;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;



public class PostClientTest {

	private static String POST_URL = "http://192.168.1.133:8080/forward/api/rest/router";
	
	/**
	* 记录错误的次数
	*/
	public static Integer errorNum = 0;
	
	/**
	 * 接受者地址
	 */
	public static String[] toAddress = {"xiaoyong@gangbeng.com"};
	
	/**
	 * 是否已经发送消息
	 */
	public static boolean sendMessage = false;
	
	public static HttpURLConnection accessServer() {
		String secretKey = "sdfCXGH45tergehHKAHICVDlkhjY";
		String method = "jiuwu.health.check";
		Map<String, String> paramMap = new HashMap<String, String>();
		Date currentTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timestamp = format.format(currentTime);
		paramMap.put("appKey", "appKey00001");
		paramMap.put("timestamp", timestamp);
		paramMap.put("format", "json");
		paramMap.put("method", method);
		paramMap.put("ver", "1.0");
	
		HttpURLConnection data = null;
		
		data = doPost(POST_URL, paramMap, null, 3000, 8000, null, secretKey);
		
		
	
		return data;
	}

	
	private static HttpURLConnection doPost(String url, Map<String, String> params, Map<String, File> fileParams,
			int connectTimeout, int readTimeout, Map<String, String> headerMap, String secretKey) {
			return doPost(url, params, connectTimeout, readTimeout, headerMap, secretKey);
	}
	
	
	private static HttpURLConnection doPost(String url, Map<String, String> params,
			int connectTimeout, int readTimeout, Map<String, String> headerMap,
			String secretKey)  {
		HttpURLConnection conn = null;
		OutputStream out = null;
		//String rsp = null;
		try {

			TreeMap<String, String> treeMap = new TreeMap<String, String>();
			if (params != null) {
				treeMap.putAll(params);
			}

			String sign = Md5Util.md5Signature(treeMap, secretKey);
			params.put("sign", sign);

			String ctype = "application/x-www-form-urlencoded;charset=UTF-8";
			conn = getConnection(new URL(url), "POST", ctype, headerMap);
			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			
			String query = buildQuery(params);
			byte[] content = {};
			if (query != null) {
				content = query.getBytes("UTF-8");
			}

			out = conn.getOutputStream();
			out.write(content);
			//rsp = getResponseAsString(conn);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}

		return conn;
	}

	private static HttpURLConnection getConnection(URL url, String method,
			String ctype, Map<String, String> headerMap) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod(method);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
		conn.setRequestProperty("Content-Type", ctype);
		 if (headerMap != null) {
			 for (Map.Entry<String, String> entry : headerMap.entrySet()) {
				 conn.setRequestProperty(entry.getKey(), entry.getValue());
			 }
		 }
		
		return conn;
	}
	
	public static String buildQuery(Map<String, String> params)
			throws IOException {
		if (params == null || params.isEmpty()) {
			return null;
		}

		StringBuilder query = new StringBuilder();
		Set<Entry<String, String>> entries = params.entrySet();
		boolean hasParam = false;

		for (Entry<String, String> entry : entries) {
			String name = entry.getKey();
			String value = entry.getValue();
			// 忽略参数名或参数值为空的参数
			if (hasParam) {
				query.append("&");
			} else {
				hasParam = true;
			}
			query.append(name).append("=")
					.append(URLEncoder.encode(value, "UTF-8"));
			
		}

		return query.toString();
	}



	protected static String getResponseAsString(HttpURLConnection conn)
			throws IOException {
		InputStream es = conn.getErrorStream();
		if (es == null) {
			return getStreamAsString(conn.getInputStream(), "UTF-8");
		} else {
			String msg = getStreamAsString(es, "UTF-8");
			if (msg == null || msg.equals("")) {
				throw new IOException(conn.getResponseCode() + ":"
						+ conn.getResponseMessage());
			} else {
				throw new IOException(msg);
			}
		}
	}

	private static String getStreamAsString(InputStream stream, String charset)
			throws IOException {
		try {
			Reader reader = new InputStreamReader(stream, charset);
			StringBuilder response = new StringBuilder();

			final char[] buff = new char[1024];
			int read = 0;
			while ((read = reader.read(buff)) > 0) {
				response.append(buff, 0, read);
			}

			return response.toString();
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}
	
	/**
	 * @FunName sendMail 
	 * @Decsription 发送邮件方法
	 * @toAddress String[] 接受者邮箱地址
	 * @param title 文件标题
	 * @param 
	 */
	
	public static void sendMail(String[] toAddress, String title, String content){
		   //这个类主要是设置邮件   
	     MailSenderInfo mailInfo = new MailSenderInfo();    
	     mailInfo.setMailServerHost("smtp.163.com");    
	     mailInfo.setMailServerPort("25");    
	     mailInfo.setValidate(true);    
	     mailInfo.setUserName("xiao86y@163.com");    
	     mailInfo.setPassword("xiao8624");//您的邮箱密码    
	     mailInfo.setFromAddress("xiao86y@163.com");    
	     mailInfo.setToAddress(toAddress); 
	     mailInfo.setSubject(title);    
   
	     //这个类主要来发送邮件    
	     //格式
	     content = "<div><span></span><div style='line-height: normal; font-family: 'lucida Grande', Verdana;'><span style='background-color: window; font-size: 10.5pt;'>各位：</span></div><div style='line-height: normal; font-family: 'lucida Grande', Verdana;'>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Java服务端出现异常，异常信息如下：</div><div style='line-height: normal; font-family: 'lucida Grande', Verdana;'><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
	     + content +
	     "</div><div><br></div><hr style='width: 210px; height: 1px;' color='#b5c4df' size='1' align='left'>"+
	     "<div style='font-family: 'lucida Grande', Verdana; orphans: 2; widows: 2; font-size: 16px;'><span style='background-color: window; line-height: normal; '><font face='楷体' style='line-height: 27px; '><b>人力资源及行政部 &nbsp;HR</b></font></span></div><div style='font-family: 'lucida Grande', Verdana; orphans: 2; widows: 2; font-size: 16px;'><span style='background-color: window; line-height: normal; '><font face='楷体' style='line-height: 27px; '><b><br></b></font></span></div><div style='font-family: 'lucida Grande', Verdana; orphans: 2; widows: 2; font-size: 16px;'><span style='background-color: window; line-height: normal; '><font face='楷体' style='line-height: 27px; '><b>武汉九午科技有限公司</b></font></span></div><div style='font-family: 'lucida Grande', Verdana; orphans: 2; widows: 2; font-size: 16px;'><font face='楷体' style='line-height: 27px; '><b><span style='line-height: 18px; '>武汉市洪山区光谷大道国际企业中心锦丰楼A座405室</span></b></font></div><div style='font-family: 'lucida Grande', Verdana; orphans: 2; widows: 2; font-size: 16px;'><font face='楷体' style='line-height: 27px; '><b><span style='line-height: 18px; '>Tel:</span><span style='background-color: window; line-height: 18px; '>(027)8710-8832</span></b>"
	     + "</font></div></div></span></div>";
	     mailInfo.setContent(content);
	     SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式   
	}

}