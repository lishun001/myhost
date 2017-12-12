package com.jiuwu.openoo.common.openapi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.UUID;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

public class StringUtilsCommon {

	private final static Log logger = LogFactory
			.getLog(StringUtilsCommon.class);

	// 加载配置文件
	private static MessageSource messageSource;

	/**
	 * @FuncName getToken
	 * @description 获取token
	 * @return strong token
	 * @author xiaoyong
	 * @throws Exception
	 */
	public static String getToken() {
		logger.info("生成token");
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(UUID.randomUUID().toString().replaceAll("-", "").getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}

				buf.append(Integer.toHexString(i));
			}

		} catch (Exception e) {
			logger.error("生成Token异常" + e);
		}
		return buf.toString();
	}

	/**
	 * @FunName getShortDomain
	 * @Description 使用新浪短域名获取短域名
	 * @param content
	 *            转换的内容
	 * @retrun String 返回的短域名内容
	 */
	public static String getShortDomain(String longUrl,
			MessageSource messageSource) {
		logger.info("转换为短域名");
		String tryUrl = longUrl;
		if (StringUtils.isNotBlank(longUrl) && messageSource != null) {
			try {
				String url = messageSource.getMessage("sina_short_url", null,
						null) + longUrl;
				/**
				 * 请求此url获取短域名 3000连接超时时间 15000 readTimeout超时时间
				 */
				tryUrl = doPost(url, 3000, 15000);
				// 转换为JSONArray
				JSONArray urlArray = JSONArray.fromObject(tryUrl);
				// 获取短连
				if (urlArray.size() > 0) {
					tryUrl = urlArray.getJSONObject(0).getString("url_short");
				}
			} catch (Exception e) {
				logger.error("转换短域名异常", e);
			}
		}
		return tryUrl;
	}

	/**
	 * @Description post请求地址
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param connectTimeout
	 *            连接时间
	 * @param readTimeout
	 *            超时时间
	 * @return 返回的短网址
	 * @throws IOException
	 */
	private static String doPost(String url, int connectTimeout, int readTimeout)
			throws IOException {
		HttpURLConnection conn = null;
		OutputStream out = null;
		String rsp = null;
		try {
			String ctype = "text/xml;charset=UTF-8";
			conn = getConnection(new URL(url), "POST", ctype);
			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			byte[] content = {};
			out = conn.getOutputStream();
			out.write(content);
			rsp = getResponseAsString(conn);

		} catch (IOException e) {
			logger.info("请求短域名地址异常", e);
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}

		return rsp;
	}

	/**
	 * @Description 获取HTTP连接对象
	 * @param url
	 * @param method
	 * @param ctype
	 * @return
	 * @throws IOException
	 */
	private static HttpURLConnection getConnection(URL url, String method,
			String ctype) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(method);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
		conn.setRequestProperty("Content-Type", ctype);
		return conn;
	}

	/**
	 * 获取返回结果
	 * 
	 * @param conn
	 * @return
	 * @throws IOException
	 */
	protected static String getResponseAsString(HttpURLConnection conn)
			throws IOException {
		InputStream es = conn.getErrorStream();
		if (es == null) {
			return getStreamAsString(conn.getInputStream(), "UTF-8");
		} else {
			String msg = getStreamAsString(es, "UTF-8");
			if (StringUtils.isEmpty(msg)) {
				throw new IOException(conn.getResponseCode() + ":"
						+ conn.getResponseMessage());
			} else {
				throw new IOException(msg);
			}
		}
	}

	/**
	 * http请求返回的结果
	 * 
	 * @param stream
	 * @param charset
	 * @return
	 * @throws IOException
	 */
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
	 * 获取替换后的内容
	 * 
	 * @param content
	 *            需要替换的内容
	 * @param messageSource
	 *            获取配置文件对象
	 * @return 替换后的内容
	 */
	public static String getShortUrlContent(String content,
			MessageSource messageSource) {
		logger.info("替换文本内容");
		try {
			String rex = "(http|https)://[\\w\\-_]+(\\.[\\w\\-_]+)*([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
			// 要替换的字符串
			String replaceStr = UUID.randomUUID().toString();
			// 替换后的字符
			String[] httpList = content.split(rex);
			// 字符串中的url以replaceStr分割
			String url = content;
			for (int i = 0; i < httpList.length; i++) {
				url = url.replace(httpList[i], replaceStr);
			}
			// 获取字符串中所有的http
			httpList = url.split(replaceStr);
			// 获取所有短域名
			for (int i = 0; i < httpList.length; i++) {
				String shortUrl = getShortDomain(httpList[i], messageSource);
				// 长连接替换为短连接
				content = content.replace(httpList[i], shortUrl);
			}

		} catch (Exception e) {
			logger.info("替换文本内容", e);
		}
		return content;
	}
}
