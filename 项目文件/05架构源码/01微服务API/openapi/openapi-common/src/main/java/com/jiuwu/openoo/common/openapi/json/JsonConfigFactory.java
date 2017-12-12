package com.jiuwu.openoo.common.openapi.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonConfigFactory {

	private static JsonConfig instance = null;

	public static synchronized JsonConfig getInstance() {
		if (instance == null) {
			instance = new JsonConfig();
			register(instance);
		}
		return instance;
	}

	private static void register(JsonConfig jsonConfig) {
		// 如果double类型为null，想输出null，那就注册double.class
		jsonConfig.registerJsonValueProcessor(Double.class,
				new JsonValueProcessor() {
					// 这个方法不用管
					public Object processArrayValue(Object value,
							JsonConfig arg1) {
						return value;
					}

					// 修改此方法就可以
					public Object processObjectValue(String key, Object value,
							JsonConfig arg2) {
						// 如果vlaue为null，就返回"",不为空就返回他的值，
						if (value == null) {
							return "";
						}
						return value;
					}
				});
		// 如果是注册Integer类型的
		jsonConfig.registerJsonValueProcessor(Integer.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig arg1) {
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig arg2) {
						if (value == null) {
							return "";
						}
						return value;
					}
				});
		// 如果是注册Date类型的
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig arg1) {
						String[] obj = {};
						if (value instanceof Date[]) {
							SimpleDateFormat sf = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							Date[] dates = (Date[]) value;
							obj = new String[dates.length];
							for (int i = 0; i < dates.length; i++) {
								obj[i] = sf.format(dates[i]);
							}
						}
						return obj;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig arg2) {
						if (value instanceof java.util.Date) {
							String str = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss").format((Date) value);
							return str;
						}
						if (value != null) {
							return value.toString();
						} else {
							return "";
						}
					}
				});

	}
}
