package com.jiuwu.openoo.openapi.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


public class JsonUtil {

	/**
	 * 转化成json格式
	 * @param content
	 */
	public static void sendMsg(String content){      
	    HttpServletResponse response = ServletActionContext.getResponse();      
	    response.setCharacterEncoding("UTF-8");      
	    try {
			response.getWriter().write(content);
		} catch (IOException e) {
		}      
	}
}
