package com.jiuwu.openoo.common.openapi.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;

import com.aliyun.openservices.ClientConfiguration;
import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;
import com.jiuwu.openoo.common.openapi.FileItem;

//文件上传公用方法                 
public class FileUtil {

	private final static Log logger = LogFactory.getLog(FileUtil.class);

	// 加载配置文件
	private static MessageSource messageSource;

	// OSSClient对象
	private static OSSClient client;

	/**
	 * 获取 OSSClient 对象
	 */
	public static void getOSSClient() {
		// 初始化
		if (client == null) {
			synchronized (FileUtil.class) {
				if (client == null) {
					ClientConfiguration conf = new ClientConfiguration();
					// 设置HTTP最大连接数为500
					conf.setMaxConnections(Integer.parseInt(getText("max_connection")));
					// 设置TCP连接超时为20秒
					conf.setConnectionTimeout(Integer.parseInt(getText("connectionT_timeout")));
					// 设置最大的重试次数为5
					conf.setMaxErrorRetry(Integer.parseInt(getText("max_error_retry")));
					// 设置Socket传输数据超时的时间为1000秒
					conf.setSocketTimeout(Integer.parseInt(getText("socket_timeout")));
					// 阿狸云地址
					String url = getText("OSS_URL");
					// 创建OSSClient对象。
					client = new OSSClient(url, getText("ACCESS_ID"), getText("ACCESS_KEY"), conf);
				}
			}
		}
	}

	/**
	 * @FunName uploadFile
	 * @Description 上传文件通用方法
	 * @param userId 上传者ID
	 * @param file  上传的文件
	 * @param source  上传文件来源(adv、mkt、user、task)
	 * @param messageSource
	 *            加载配置文件类
	 * @return 保存文件的地址
	 * @Create Date: 2015-09-12
	 */
	public static String uploadFile(String userId, FileItem file, String source, MessageSource ms) {
		// 开始时间
		long startTime = System.currentTimeMillis();
		messageSource = ms;
		// 上传的路径
		String url = uploadFile(userId, file, source);
		logger.info("本次文件【" + file.getFileName() + "】上传耗时(毫秒)："+ (System.currentTimeMillis() - startTime));
		return url;

	}
	
	/**
	 * @FunName uploadFile
	 * @Description 上传文件通用方法
	 * @param userId 上传者ID
	 * @param file  上传的文件
	 * @param source 上传文件来源(adv、mkt、user、task)
	 * @param messageSource
	 *            加载配置文件类
	 * @return 保存文件的地址
	 * @Create Date: 2015-09-12
	 */
	private static String uploadFile(final String userId, final FileItem file,final String source) {
		logger.info("文件上传阿里云 ");
		// 返回OSS文件地址
		String result = "";
		InputStream input = null;
		// ①参数判断
		try {
			// ①参数判断
			if (StringUtils.isNotBlank(userId) && file != null
					&& file.getContent() != null && file.getFileName() != null
					&& source != null) {
				// 获取阿里云上传路径
				String bucketName = "bucketName";
				String domain = "domain";
				// 获取文件后缀名
				String fileExt = "";
				// 位置
				Integer positionNum = file.getFileName().lastIndexOf(".");
				if (positionNum != -1) {
					fileExt = file.getFileName().substring(positionNum);
				}
				// 使用userid和guid重新生成文件名
				final String uuidName = UUID.randomUUID().toString().replace("-", "");
				String name = uuidName + fileExt;
				// 用户名+文件名
				String newFileName = source+"/"+userId + "/" + "s1" + "/" + name;
				// 新域名
				result = "http://" + getText(bucketName)+ getText(domain)+ "/" + newFileName;
				// 创建OSSClient对象。
				getOSSClient();
				// OSS上传
				ObjectMetadata objectMeta = new ObjectMetadata();
				objectMeta.setContentLength(file.getContent().length);
				input = new ByteArrayInputStream(file.getContent());
				// 上传对象 开始上传的时间
				long startTime = System.currentTimeMillis();
				PutObjectResult put = client.putObject(getText(bucketName), newFileName,input, objectMeta);
				logger.info("返回的结果" + put.getETag() + "---文件【"+ file.getFileName() + "】上传到oss的时间 :"+ (System.currentTimeMillis() - startTime));
				logger.info("阿里云位置 ：" + result + ";文件上传的原始名称："+ file.getFileName());
			} else {
				logger.error("上传文件参数为空，参数：用户ID=" + userId + ";file=" + file+ ";source=" + source);
			}
		} catch (Exception e) {
			logger.error("上传文件异常，参数：用户ID=" + userId + ";file=" + file+ ";source=" + source, e);
		} finally {
			try {
				// 关闭文件流
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				logger.error("关闭文件流异常，参数：用户ID=" + userId + ";file=" + file + ";source" + source, e);
			}
		}
		return result;
	}

	/**
	 * @FunName deleteFile
	 * @Description 上传文件通用方法
	 * @param filePathKey 文件的在OSS的路径
	 * @Create Date: 2015-09-12
	 */
	public static boolean deleteFile(final String filePathKey) {
		logger.info("删除阿里云的上传文件： "+ filePathKey);
		// 返回OSS文件地址
		String bucketName = "bucketName";
		String domain = "domain";
		// ①参数判断
		try {
			// ①参数判断
			if (StringUtils.isNotBlank(filePathKey)) {
				//去掉域名：http://awesome.oss-cn-beijing.aliyuncs.com/
				String header = "http://" + getText(bucketName)+ getText(domain)+ "/";
				String key=filePathKey.replace(header, "");
				client.deleteObject(getText(bucketName), key);
				return true;
			} else {
				logger.info("删除阿里云的上传文件，参数：用户ID=" +filePathKey+",不存在");
			}
		} catch (Exception e) {
			logger.error("删除阿里云的上传文件，参数：用户ID=" + filePathKey, e);
		}
		return false;
	}

	/**
	 * 获取配置文件中的值
	 */
	public static String getText(String code) {
		// 返回获取的地址
		return messageSource.getMessage(code, null, null);
	}


	/**
	 * @FUNNAME getSource
	 * @Description 将File文件转换为byte数组
	 * @param File 
	 */
	public static byte[] chagenFileToByte(File file) {
		byte[] buffer = null;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		if(file!=null){
			try {
				fis = new FileInputStream(file);  
	            bos = new ByteArrayOutputStream();  
	            byte[] b = new byte[1024];  
	            int n;  
	            while ((n = fis.read(b)) != -1)  {  
	                bos.write(b, 0, n);  
	            }  
	            
	            buffer = bos.toByteArray();  
			} catch (Exception e) {
				logger.error("将File转换为byte数组出错");
			}finally{
				try {
					if(fis!=null){
						fis.close();  
					}
					if(bos!=null){
						 bos.close();  
					}
				} catch (Exception e2) {
					logger.error("将File转换为byte数组出错");
				}
				
			}
			
	            
		}
		return buffer;
	}
}
