package com.jiuwu.openoo.openapi.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.ApiMethod.ApiMethodInfo;
import model.ApiMethod.AppInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jiuwu.openoo.openapi.service.LogOperatorServiceImpl;
import com.jiuwu.openoo.openapi.utils.OpenApiCommonConst;

public class OpenApiInitDataListener implements ServletContextListener{

	/** log */
	private final Log log= LogFactory.getLog(getClass());
	
	public void contextInitialized(ServletContextEvent sce) {
		
		try{
			
			ServletContext servletContext = sce.getServletContext();
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			LogOperatorServiceImpl logOperatorService = (LogOperatorServiceImpl) context.getBean("logOperatorService");
			//MemCachedClient memCachedClient =(MemCachedClient) context.getBean("memCachedClient");
			//加载method信息
			List<ApiMethodInfo> apiMethodInfoList = logOperatorService.getApiMethodInfoList();
			
			String key = null;
			for(ApiMethodInfo apiMethodInfo : apiMethodInfoList){
				key = apiMethodInfo.getMethod() + "_" + apiMethodInfo.getMethodVer();
				OpenApiCommonConst.allMethodInfoMap.put(key, apiMethodInfo);
			}
			
			// 加载app信息
			List<AppInfo> appInfoList = logOperatorService.getAppinfoList();
			for(AppInfo appInfo : appInfoList){
				OpenApiCommonConst.allAppInfoMap.put(appInfo.getAppKey(), appInfo);
			}
			
			
			//加载服务信息
			/*Date date = new Date(); 
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(date); 
			cal.add(Calendar.DAY_OF_MONTH,30); //加30天
			List<OoServiceModel> serviceList = serviceService.getServiceList();
			Map<String,Object> memMap = new HashMap<String,Object>();
			if(serviceList!=null&&serviceList.size()>0){
				for(OoServiceModel service:serviceList){
					memCachedClient.set(service.getServiceName(), service.getIconUrl(),cal.getTime());
					memMap.put(service.getServiceName(), service.getIconUrl());
					//System.out.println("缓存获取的值为："+memCachedClient.get(service.getServiceName()));
				}
			}
			memCachedClient.set("services", memMap,cal.getTime());*/

			
		} catch (Exception exception){
			exception.printStackTrace();
			log.error("加载接口方法信息失败");
		}
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	
}
