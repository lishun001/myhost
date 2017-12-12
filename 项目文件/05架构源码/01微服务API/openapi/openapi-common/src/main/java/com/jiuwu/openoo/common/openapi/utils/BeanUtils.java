package com.jiuwu.openoo.common.openapi.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeansException;

public abstract class BeanUtils extends org.springframework.beans.BeanUtils {

	public static void copyProperties(Object source, Object target)
			throws BeansException {
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(
						source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass()
								.getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod
									.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							if(value instanceof Date){
								Date date=(Date)value;
								writeMethod.invoke(target, DateUtils.format(date, DateUtils.YMD_DASH_WITH_TIME));
							}else {
								writeMethod.invoke(target, value);
							}
						}
					} catch (Throwable ex) {
					}
				}
			}
		}
	}
	
	public static <T,S> T copyProperties(S s,Class<T> clazz){
			
			try{
				T t = clazz.newInstance();
				BeanUtils.copyProperties(s, t);
				return t;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
	}
	

	
	public static <T, S> List<T> transform(List<S> list, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		for (S s : list) {
			try {
				T o = clazz.newInstance();
				BeanUtils.copyProperties(s, o);
				result.add(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
//	
//	public static <S> List<Map<String,Object>> transform(List<S> list, String... fields) {
//		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
//		for (S s : list) {
//			try {
//				Map<String,Object> map = new HashMap<String,Object>();
//				for (String field : fields) {
//					map.put(field, PropertyUtils.getProperty(s, field));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
}